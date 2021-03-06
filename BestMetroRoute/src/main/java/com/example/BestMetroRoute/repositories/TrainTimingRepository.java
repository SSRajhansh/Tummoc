package com.example.BestMetroRoute.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.BestMetroRoute.model.TrainTiming;

public interface TrainTimingRepository extends CrudRepository<TrainTiming, String> {

	List<TrainTiming> findByStationId(int stationId);
}
