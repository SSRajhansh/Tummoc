package com.example.BestMetroRoute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metro_stations")
public class MetroStations {	
	
	@Id
	int stationId;
	int stationSeq;	
	String stationName;
	double latitude;
	double longitude;
	String lineNum;
	
	public MetroStations() {
	}

	public MetroStations(int stationId, int stationSeq, String stationName, double latitude, double longitude, String lineNum) {
		this.stationId = stationId;
		this.stationSeq = stationSeq;
		this.stationName = stationName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.lineNum = lineNum;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public int getStationSeq() {
		return stationSeq;
	}

	public void setStationSeq(int stationSeq) {
		this.stationSeq = stationSeq;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	
	
}
