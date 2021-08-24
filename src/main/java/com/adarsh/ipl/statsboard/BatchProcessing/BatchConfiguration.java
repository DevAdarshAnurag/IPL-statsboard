package com.adarsh.ipl.statsboard.BatchProcessing;

import com.adarsh.ipl.statsboard.Model.BallStats;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final static String[] FIELD_NAMES = {"id", "inning", "over", "ball", "batsman", "non_striker", "bowler", "batsman_runs", "extra_runs", "total_runs", "non_boundary", "is_wicket", "dismissal_kind", "player_dismissed", "fielder", "extras_type", "batting_team", "bowling_team"};

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<BallInput> reader() {
        return new FlatFileItemReaderBuilder<BallInput>()
                .name("personItemReader")
                .resource(new ClassPathResource("ball_by_ball_2008_2020.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<BallInput>() {{
                    setTargetType(BallInput.class);
                }})
                .build();
    }

    @Bean
    public BallItemProcessor processor() {
        return new BallItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<BallStats> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<BallStats>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO ball_stats (match_id, inning, over, ball, batsman, bowler, batsman_runs, extra_runs, total_runs,  is_wicket, dismissal_kind,  player_dismissed, fielder, extras_type, batting_team, bowling_team)" +
                        " VALUES (:matchId, :inning, :over, :ball, :batsman, :bowler, :batsmanRuns, :extraRuns, :totalRuns, :isWicket, :dismissalKind,  :playerDismissed, :fielder, :extrasType, :battingTeam, :bowlingTeam)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<BallStats> writer) {
        return stepBuilderFactory.get("step1")
                .<BallInput, BallStats>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
