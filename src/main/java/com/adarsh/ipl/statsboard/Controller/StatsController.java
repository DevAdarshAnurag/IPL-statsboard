package com.adarsh.ipl.statsboard.Controller;

import com.adarsh.ipl.statsboard.Service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class StatsController {
    public final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats_table")
    public String getStatsTable(@RequestParam(value = "type", required = false) String type, Model model) {
        HashMap<String, Integer> map;
        switch (type) {
            case "b0":
                map = statsService.getMostSixesByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Sixes");
                break;
            case "b1":
                map = statsService.getMostFoursByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Fours");
                break;
            case "b2":
                map = statsService.getMostRunsByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Runs");
                break;
            case "b3":
                map = statsService.getMostRunsInPowerPlayByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Runs in PowerPlay");
                break;
            case "b4":
                map = statsService.getMostRunsInDeathByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Runs in Death");
                break;
            case "f0":
                map = statsService.getMostWicketsTakenByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Wickets");
                break;
            case "f1":
                map = statsService.getMostCaughtByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Caught Out");
                break;
            case "f2":
                map = statsService.getMostRunOutsByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Run Outs");
                break;
            case "f3":
                map = statsService.getMostWicketsTakenInPowerPlayByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Wickets in PowerPlay");
                break;
            case "f4":
                map = statsService.getMostWicketsTakenInDeathByTeam();
                model.addAttribute("table", map);
                model.addAttribute("head", "Wickets in Death");
                break;
        }
        return "stats_table";
    }

}
