package com.adarsh.ipl.statsboard.Controller;

import com.adarsh.ipl.statsboard.Model.BallStats;
import com.adarsh.ipl.statsboard.Repository.BallStatsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class StatsController {

    private BallStatsRepository ballStatsRepository;

    public StatsController(BallStatsRepository ballStatsRepository) {
        this.ballStatsRepository = ballStatsRepository;
    }

    @GetMapping("/stat6")
    public HashMap<String, Integer> get6() {
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
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    @GetMapping("/stat4")
    public HashMap<String, Integer> get4() {
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
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }

    @GetMapping("/statW")
    public HashMap<String, Integer> getWicket() {
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
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return map;
    }
}
