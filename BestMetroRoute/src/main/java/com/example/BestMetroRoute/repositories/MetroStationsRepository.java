package com.example.BestMetroRoute.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.BestMetroRoute.model.MetroStations;

public interface MetroStationsRepository extends CrudRepository<MetroStations, Integer>  {

	MetroStations findByLatitudeAndLongitude(float latitude, float longitude);
}
