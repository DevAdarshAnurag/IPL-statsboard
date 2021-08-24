package com.adarsh.ipl.statsboard.Service;

import com.adarsh.ipl.statsboard.Model.BallStats;
import com.adarsh.ipl.statsboard.Repository.BallStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        List<BallStats> ballStats = ballStatsRepository.findByIsWicketAndOverLessThan(1, 7);
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

    public String getTeamVSTeamStats(String teamName1, String teamName2) {
        List<BallStats> team1 = ballStatsRepository.findByBattingTeamAndBowlingTeam(teamName1, teamName2);
        List<BallStats> team2 = ballStatsRepository.findByBattingTeamAndBowlingTeam(teamName2, teamName1);
        System.out.println(team1.size() + " " + team2.size());
        return null;
    }
}
