package com.ceceg.smaffy.Model;

import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

// temperature collection
@Repository
public interface TemperatureRepository extends MongoRepository<TemperatureData, ObjectId> {
    List<TemperatureData> findByTimestampDesc(LocalDateTime localDateTime, PageRequest of);
}