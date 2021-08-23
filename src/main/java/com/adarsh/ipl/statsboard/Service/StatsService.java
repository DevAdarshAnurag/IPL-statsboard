package com.adarsh.ipl.statsboard.Service;

import com.adarsh.ipl.statsboard.Model.BallStats;
import com.adarsh.ipl.statsboard.Repository.BallStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StatsService {

    private final BallStatsRepository ballStatsRepository;

    @Autowired
    public StatsService(BallStatsRepository ballStatsRepository) {
        this.ballStatsRepository = ballStatsRepository;
    }

    public HashMap<String, Integer> getMostSixesByTeam() {
        Iterable<BallStats> ballStats = ballStatsRepository.findAll();
        HashMap<String, Integer> map = new HashMap<>();
        for(BallStats b : ballStats)
        {
            if(b.getBatsmanRuns() == 6)
            {
                int count = map.getOrDefault(b.getBattingTeam(), 0);
                map.put(b.getBattingTeam(), count + 1);
            }
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostFoursByTeam() {
        Iterable<BallStats> ballStats = ballStatsRepository.findAll();
        HashMap<String, Integer> map = new HashMap<>();
        for(BallStats b : ballStats)
        {
            if(b.getBatsmanRuns() == 4)
            {
                int count = map.getOrDefault(b.getBattingTeam(), 0);
                map.put(b.getBattingTeam(), count + 1);
            }
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    public HashMap<String, Integer> getMostWicketsTakenByTeam() {
        Iterable<BallStats> ballStats = ballStatsRepository.findAll();
        HashMap<String, Integer> map = new HashMap<>();
        for(BallStats b : ballStats)
        {
            if(b.getIsWicket() == 1)
            {
                int count = map.getOrDefault(b.getBowlingTeam(), 0);
                map.put(b.getBowlingTeam(), count + 1);
            }
        }
        map = map.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }
}
