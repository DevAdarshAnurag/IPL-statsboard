package com.adarsh.ipl.statsboard.BatchProcessing;

import com.adarsh.ipl.statsboard.Model.BallStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BallItemProcessor implements ItemProcessor<BallInput, BallStats> {

    private static final Logger log = LoggerFactory.getLogger(BallItemProcessor.class);

    @Override
    public BallStats process(final BallInput ballInput) throws Exception {
        BallStats ballStats = new BallStats();
        ballStats.setBall(Integer.parseInt(ballInput.getBall()));
        ballStats.setBatsman(ballInput.getBatsman());
        ballStats.setBowler(ballInput.getBowler());
        ballStats.setInning(Integer.parseInt(ballInput.getInning()));
        ballStats.setOver(Integer.parseInt(ballInput.getOver()));
        ballStats.setFielder(ballInput.getFielder());
        ballStats.setBatsmanRuns(Integer.parseInt(ballInput.getBatsmanRuns()));
        ballStats.setExtraRuns(Integer.parseInt(ballInput.getExtraRuns()));
        ballStats.setExtrasType(ballInput.getExtrasType());
        ballStats.setIsWicket(Integer.parseInt(ballInput.getIsWicket()));
        ballStats.setTotalRuns(Integer.parseInt(ballInput.getTotalRuns()));
        ballStats.setBattingTeam(ballInput.getBattingTeam());
        ballStats.setBowlingTeam(ballInput.getBowlingTeam());
        ballStats.setMatchId(Long.parseLong(ballInput.getId()));
        ballStats.setPlayerDismissed(ballInput.getPlayerDismissed());
        ballStats.setDismissalKind(ballInput.getDismissalKind());
        return ballStats;
    }

}