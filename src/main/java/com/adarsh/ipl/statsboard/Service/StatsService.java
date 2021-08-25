package com.adarsh.ipl.statsboard.Service;

import com.adarsh.ipl.statsboard.Model.BallStats;
import com.adarsh.ipl.statsboard.Model.Triple;
import com.adarsh.ipl.statsboard.Repository.BallStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatsService {

    private final BallStatsRepository ballStatsRepository;

    @Autowired
    public StatsService(BallStatsRepository ballStatsRepository) {
        this.ballStatsRepository = ballStatsRepository;
    }

    public HashMap<String, Integer> getMostSixesByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByBatsmanRuns(6);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBattingTeam(), 0);
            map.put(b.getBattingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostFoursByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByBatsmanRuns(4);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBattingTeam(), 0);
            map.put(b.getBattingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostRunsByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByTotalRunsGreaterThan(0);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBattingTeam(), 0);
            map.put(b.getBattingTeam(), count + b.getTotalRuns());
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostRunsInPowerPlayByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByTotalRunsGreaterThanAndOverLessThan(0, 6);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBattingTeam(), 0);
            map.put(b.getBattingTeam(), count + b.getTotalRuns());
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostRunsInDeathByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByTotalRunsGreaterThanAndOverGreaterThan(0, 15);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBattingTeam(), 0);
            map.put(b.getBattingTeam(), count + b.getTotalRuns());
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostWicketsTakenByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByIsWicket(1);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBowlingTeam(), 0);
            map.put(b.getBowlingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostCaughtByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByDismissalKind("caught");
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBowlingTeam(), 0);
            map.put(b.getBowlingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostRunOutsByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByDismissalKind("run out");
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBowlingTeam(), 0);
            map.put(b.getBowlingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostWicketsTakenInPowerPlayByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByIsWicketAndOverLessThan(1, 6);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBowlingTeam(), 0);
            map.put(b.getBowlingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostWicketsTakenInDeathByTeam() {
        List<BallStats> ballStats = ballStatsRepository.findByIsWicketAndOverGreaterThan(1, 15);
        HashMap<String, Integer> map = new HashMap<>();
        for (BallStats b : ballStats) {
            int count = map.getOrDefault(b.getBowlingTeam(), 0);
            map.put(b.getBowlingTeam(), count + 1);
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public List<Triple<Integer, String, Integer>> getTeamVSTeamStats(String teamName1, String teamName2) {
        String[] statsName = {"6s", "4s", "Runs Scored", "Runs in PowerPlay", "Runs in Death",
                "Wickets Taken", "Wickets in PowerPlay", "Wickets in Death"};
        Long[] stats1 = {ballStatsRepository.countByBatsmanRunsAndBattingTeamAndBowlingTeam(6,teamName1, teamName2),
                ballStatsRepository.countByBatsmanRunsAndBattingTeamAndBowlingTeam(4,teamName1, teamName2),
                0l,
                0l, 0l,
                ballStatsRepository.countByIsWicketAndBattingTeamAndBowlingTeam(1, teamName2, teamName1),
                ballStatsRepository.countByIsWicketAndBattingTeamAndBowlingTeamAndOverLessThan(1, teamName2, teamName1, 6),
                ballStatsRepository.countByIsWicketAndBattingTeamAndBowlingTeamAndOverGreaterThan(1, teamName2, teamName1, 15)};
        Long[] stats2 = {ballStatsRepository.countByBatsmanRunsAndBattingTeamAndBowlingTeam(6,teamName2, teamName1),
                ballStatsRepository.countByBatsmanRunsAndBattingTeamAndBowlingTeam(4,teamName2, teamName1),
                0l,
                0l, 0l,
                ballStatsRepository.countByIsWicketAndBattingTeamAndBowlingTeam(1, teamName1, teamName2),
                ballStatsRepository.countByIsWicketAndBattingTeamAndBowlingTeamAndOverLessThan(1, teamName1, teamName2, 6),
                ballStatsRepository.countByIsWicketAndBattingTeamAndBowlingTeamAndOverGreaterThan(1, teamName1, teamName2, 15)};

        List<BallStats> ballStats = ballStatsRepository.findByTotalRunsGreaterThanAndBattingTeamAndBowlingTeam(0, teamName1, teamName2);
        for(BallStats b:ballStats)
        {
            stats1[2] += b.getTotalRuns();
            if(b.getOver() < 6)
                stats1[3] += b.getTotalRuns();
            if(b.getOver() > 15)
                stats1[4] += b.getTotalRuns();
        }
        ballStats = ballStatsRepository.findByTotalRunsGreaterThanAndBattingTeamAndBowlingTeam(0, teamName2, teamName1);
        for(BallStats b:ballStats)
        {
            stats2[2] += b.getTotalRuns();
            if(b.getOver() < 6)
                stats2[3] += b.getTotalRuns();
            if(b.getOver() > 15)
                stats2[4] += b.getTotalRuns();
        }

        List<Triple<Integer, String, Integer>> statsList = new ArrayList<>();
        for(int i=0; i< statsName.length; i++)
        {
            statsList.add(new Triple(stats1[i], statsName[i],stats2[i]));
        }

        return statsList;
    }
}
