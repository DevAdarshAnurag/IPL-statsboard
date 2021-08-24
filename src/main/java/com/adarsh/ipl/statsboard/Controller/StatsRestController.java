package com.adarsh.ipl.statsboard.Controller;

import com.adarsh.ipl.statsboard.Service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class StatsRestController {

    public final StatsService statsService;

    @Autowired
    public StatsRestController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/most-sixes-by-team")
    public HashMap<String, Integer> getMostSixesByTeam()
    {
        return statsService.getMostSixesByTeam();
    }

    @GetMapping("/most-fours-by-team")
    public HashMap<String, Integer> getMostFoursByTeam()
    {
        return statsService.getMostFoursByTeam();
    }

    @GetMapping("/most-wickets-taken-by-team")
    public HashMap<String, Integer> getMostWicketsTakenByTeam()
    {
        return statsService.getMostWicketsTakenByTeam();
    }

}
