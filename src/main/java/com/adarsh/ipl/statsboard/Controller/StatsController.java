package com.adarsh.ipl.statsboard.Controller;

import com.adarsh.ipl.statsboard.Service.StatsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/stats_table")
public class StatsController {
    public final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public String getStatsTable(@RequestParam(value="type", required = false)String type, Model model){
        if(type.equals("b0"))
        {
            HashMap<String, Integer> map = statsService.getMostSixesByTeam();
            model.addAttribute("table",map);
            model.addAttribute("head","Most Sixes");
        }
        return "stats_table";
    }

}
