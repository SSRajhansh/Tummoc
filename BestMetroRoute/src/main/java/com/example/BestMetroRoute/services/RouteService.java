package com.example.BestMetroRoute.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BestMetroRoute.model.TrainTiming;

@Service
public class RouteService {
	
	private List<TrainTiming> routeList = null;

	/*
	 * @Autowired private MetroStationsRepository metroStationsRepository;
	 * 
	 * @Autowired private MetroLinesRepository metroLinesRepository;
	 * 
	 * @Autowired private TrainTimingRepository trainTimingRepository;
	 */
	public String method(String sourceLocation, String destinationLocation, LocalTime currentTime) {
		float sourceLat = Float.parseFloat(sourceLocation.split(",",2)[0]);
		float sourceLon = Float.parseFloat(sourceLocation.split(",",2)[1]);
		float destLat = Float.parseFloat(destinationLocation.split(",",2)[0]);
		float destLon = Float.parseFloat(destinationLocation.split(",",2)[1]);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm");

		
		return "sourceLocation = " + sourceLat + "N " + sourceLon + "E "
				+"\ndestinationLocation = " + destLat + "N " + destLon + "E " 
				+"\ncurrentTime = "+ currentTime.format(format) ;
	}
	/*
	private void mainLogic() {
		float sourceLat = 2.1f;
		float sourceLon = 2.1f;
		float destLat = 2.1f;
		float destLon = 2.1f;
		LocalTime currentTime = LocalTime.now();

		int sourceStationId = getMetroStation(sourceLat, sourceLon).getStationID();
		int destStationId = getMetroStation(destLat, destLon).getStationID();		
		
		List<MetroLines> sourceLines= getMetroLines(sourceStationId); 
		List<MetroLines> destLines= getMetroLines(destStationId);
		String[] mertroLines = null;
		if(sourceLines.size() > 0 && destLines.size() > 0) {
			mertroLines = getMetroLines(sourceLines, destLines);
		}
		
		if(mertroLines.length == 1) {
			getTrainTimes(sourceStationId, destStationId, currentTime);
		}		
	}
	
	private MetroStations getMetroStation(float latitude, float longitude) {		
		return metroStationsRepository.findByLatitudeAndLongitude(latitude, longitude);
	}
	
	private List<MetroLines> getMetroLines(int stationId) {		
		return metroLinesRepository.findByStationId(stationId);
	}
	
	private List<List<TrainTiming>> getTrainTimes(int sourceStationId, int destStationId, LocalTime currentTime) {
		int sourceStationSeq = metroStationsRepository.findById(sourceStationId).get().getStationSeq();
		int destStationSeq = metroStationsRepository.findById(destStationId).get().getStationSeq();
		List<List<TrainTiming>> trainTimings = new ArrayList<List<TrainTiming>>();
		if(sourceStationSeq < destStationSeq) {
			for(int i = sourceStationSeq; i <= destStationSeq; i++) {
				trainTimings.add(trainTimingRepository.findByStationID(i));
			}
		}else {
			for(int i = destStationSeq; i <= sourceStationSeq; i++) {
				trainTimings.add(trainTimingRepository.findByStationID(i));
			}
		}		
		return trainTimings;		
		
	}
	
	private String[] getMetroLines (List<MetroLines> sourceLines, List<MetroLines> destLines) {
		
		int srcLinesSize = sourceLines.size();
		int destLinesSize = destLines.size();
		int arrSize = (srcLinesSize >= destLinesSize) ? srcLinesSize : destLinesSize;
		String[] lines = new String[arrSize];
		int k = 0;
		for(int i = 0; i < srcLinesSize; i++) {
			for(int j = 0; j < destLinesSize; j++) {
				if(sourceLines.get(i).getLineNum().equals(destLines.get(j).getLineNum())) {
					return new String[] {sourceLines.get(i).getLineNum()};
				}
				if(srcLinesSize >= destLinesSize) {
					lines[k++] = sourceLines.get(i).getLineNum();
				}else {
					lines[k++] = sourceLines.get(j).getLineNum();
				}				
			}
		}		
		return lines;
	}
	*/
}
