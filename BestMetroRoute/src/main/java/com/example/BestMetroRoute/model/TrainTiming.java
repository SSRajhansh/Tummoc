package com.example.BestMetroRoute.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TrainTiming {

	@Id
	int serialNo;
	int stationId;
	String trainId;
	String time;
		
	public TrainTiming() {
	}

	public TrainTiming(int serialNo, int stationId, String trainId, String time) {
		this.serialNo = serialNo;
		this.stationId = stationId;
		this.trainId = trainId;
		this.time = time;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
		
}
