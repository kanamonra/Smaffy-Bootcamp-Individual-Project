package com.ceceg.smaffy.Controller;

import com.ceceg.smaffy.Model.TemperatureData;
import com.ceceg.smaffy.Service.TemperatureService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DataHistoryController {

    private final TemperatureService temperatureService;

    public DataHistoryController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/datahistory")
    public String dataHistory(Model model){
        // Show data history default 1 day
        List<TemperatureData> history = temperatureService.getHistoricalData(1);
        // front-end
        model.addAttribute("history", history);

        return "datahistory";
    }

    @GetMapping("/api/getHistoricalData")
    public List<TemperatureData> getHistoricalData(@RequestParam(name = "daysAgo", defaultValue = "1") int daysAgo){
        return temperatureService.getHistoricalData(daysAgo);
    }

}
