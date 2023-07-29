package com.ceceg.smaffy.Service;

import org.springframework.stereotype.Service;

@Service
public class AnalysisService {

    public String getTemperatureFeedback(double temperature) {
        // Perform analysis and provide feedback based on the temperature value + can modify by client(on next ver)
        if (temperature > 27) {
            return "Temperature is hot.";
        } else if (temperature < 10) {
            return "Temperature is cold.";
        } else  {
            return "Temperature is in normal range";
        }
    }
}


