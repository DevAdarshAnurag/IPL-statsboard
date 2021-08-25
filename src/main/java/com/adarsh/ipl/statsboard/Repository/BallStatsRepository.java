package com.adarsh.ipl.statsboard.Repository;

import com.adarsh.ipl.statsboard.Model.BallStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BallStatsRepository extends CrudRepository<BallStats, Long> {

    List<BallStats> findByBattingTeamAndBowlingTeam(String battingTeam, String bowlingTeam);

    List<BallStats> findByBatsmanRuns(int batsmanRuns);

    List<BallStats> findByIsWicket(int isWicket);

    List<BallStats> findByIsWicketAndOverGreaterThan(int isWicket, int over);

    List<BallStats> findByIsWicketAndOverLessThan(int isWicket, int over);

    List<BallStats> findByDismissalKind(String dismissalKind);

    List<BallStats> findByTotalRunsGreaterThanAndBattingTeamAndBowlingTeam(int totalRuns, String battingTeam, String bowlingTeam);

    List<BallStats> findByTotalRunsGreaterThanAndOverGreaterThan(int totalRuns, int over);

    List<BallStats> findByTotalRunsGreaterThanAndOverLessThan(int totalRuns, int over);

    List<BallStats> findByTotalRunsGreaterThan(int totalRuns);

    long countByBatsmanRunsAndBattingTeamAndBowlingTeam(int batsmanRuns, String battingTeam, String bowlingTeam);

    long countByIsWicketAndBattingTeamAndBowlingTeam(int isWicket, String battingTeam, String bowlingTeam);

    long countByIsWicketAndBattingTeamAndBowlingTeamAndOverGreaterThan(int isWicket, String battingTeam, String bowlingTeam, int over);

    long countByIsWicketAndBattingTeamAndBowlingTeamAndOverLessThan(int isWicket, String battingTeam, String bowlingTeam, int over);

}
