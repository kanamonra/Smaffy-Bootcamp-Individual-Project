package com.ceceg.smaffy.Service;

import com.ceceg.smaffy.Model.TemperatureData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemperatureService {
    private static final String Temperature_API_URL = "YOUR BOARD IP ADDRESS";       // fetches real-time data from E-board server

    private com.ceceg.smaffy.Model.TemperatureRepository temperatureRepository;

    public List<TemperatureData> getRealTimeData(){
        Sort sortByTimestampDesc = Sort.by(Sort.Direction.DESC, "timestamp");
        Pageable pageable = PageRequest.of(0, 10, sortByTimestampDesc);
        return temperatureRepository.findAll(pageable).getContent();
    }

    public void saveTempData(double temperature, LocalDateTime timestamp, String genre){
        TemperatureData temperatureData = new TemperatureData();
        temperatureData.setTemperature(temperature);
        temperatureData.setDate(timestamp);
        temperatureData.setGenre(genre);

        // save the data
        temperatureRepository.save(temperatureData);
    }

    public TemperatureData fetchAndSaveRealTimeData(){
        // http request tp API
        RestTemplate template = new RestTemplate();
        ResponseEntity<TemperatureData> response = template.getForEntity(Temperature_API_URL, TemperatureData.class);

        // extract data from response
        TemperatureData realTimeData = response.getBody();

        // saving
        temperatureRepository.save(realTimeData);
        return realTimeData;
    }
    public List<TemperatureData> getHistoricalData(int daysAgo){
        LocalDate startDate = LocalDate.now().minusDays(daysAgo);

        // page req for limit the number of result
        return temperatureRepository.findByTimestampDesc(startDate.atStartOfDay(), PageRequest.of(0,20));
    }
}
