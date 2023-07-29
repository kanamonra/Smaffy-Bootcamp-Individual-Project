package com.ceceg.smaffy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collation = "temp_sensor")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TemperatureData {
    @Id
    private ObjectId id;
    private LocalDateTime timestamp;
    private double temperature;
    private String genre;


    // setter for new data
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setDate(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }

    public void getTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setAnalysisResult(String analysisResult) {
    }
}
