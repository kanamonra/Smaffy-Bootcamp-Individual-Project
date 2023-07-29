package com.ceceg.smaffy.Controller;

import com.ceceg.smaffy.Model.TemperatureData;
import com.ceceg.smaffy.Service.AnalysisService;
import com.ceceg.smaffy.Service.TemperatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AnalysisController {
    private AnalysisService analysisService;
    private TemperatureService temperatureService;

//    public AnalysisController(AnalysisService temperatureAnalysisService) {
//        this.analysisService = temperatureAnalysisService;
//    }

    @RequestMapping("/analysis")
    public String analysisPage(Model model) {
        // Fetch temperature analysis data from the service
        List<TemperatureData> realTimeData = temperatureService.getRealTimeData();
        // analyse part
        for(TemperatureData data : realTimeData){
            String analysisResult = analysisService.getTemperatureFeedback(data.getTemperature());
            data.setAnalysisResult(analysisResult);
        }
        model.addAttribute("realTimeData", realTimeData);
        return "analysis";
    }
}
