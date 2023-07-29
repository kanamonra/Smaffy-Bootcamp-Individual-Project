package com.ceceg.smaffy.Controller;

import com.ceceg.smaffy.Model.TemperatureData;
import com.ceceg.smaffy.Service.TemperatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private TemperatureService temperatureService;


    @GetMapping("/dashboard")
    public String showdashboard(Model model){
        // Fetching real time temperature data from service part
        TemperatureData realTimeData = temperatureService.fetchAndSaveRealTimeData();
        model.addAttribute("realTimeData");

        return "dashboard";
    }


}
