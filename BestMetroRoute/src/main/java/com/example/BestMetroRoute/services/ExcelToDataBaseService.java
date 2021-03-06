package com.example.BestMetroRoute.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BestMetroRoute.model.MetroStations;
import com.example.BestMetroRoute.model.TrainTiming;
import com.example.BestMetroRoute.repositories.MetroStationsRepository;
import com.example.BestMetroRoute.repositories.TrainTimingRepository;

@Service
public class ExcelToDataBaseService {
	
	@Autowired
	private MetroStationsRepository metroStationsRepository;
	@Autowired
	private TrainTimingRepository trainTimingRepository;
	
	public void insert_data() {			
		
		String excelFilePath = "Metro Stations.xlsx";
		try {
            long start = System.currentTimeMillis();             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            int noOfSheet = workbook.getNumberOfSheets();
            int stationId = 1;
            int trainSeq = 1;
            for(int i = 0; i < noOfSheet; i++) {
            	Sheet sheet = workbook.getSheetAt(i);
            	int stationSeq = 1;            	
                Iterator<Row> rowIterator = sheet.iterator();
                rowIterator.next();
                while (rowIterator.hasNext()) {
                	MetroStations ms = new MetroStations();
                    Row nextRow = rowIterator.next();
                    Iterator<Cell> cellIterator = nextRow.cellIterator();
                    int train = 1;
                    while (cellIterator.hasNext()) {
                        Cell nextCell = cellIterator.next();
                        int columnIndex = nextCell.getColumnIndex();
                        switch (columnIndex) {
                        case 0:
                        	ms.setStationId(stationId);
                        	ms.setStationSeq(stationSeq++);
                        	
                        	String stationName = nextCell.getStringCellValue();
                        	ms.setStationName(stationName);
                        	
                        	String lineNum = sheet.getSheetName();
                        	ms.setLineNum(lineNum);
                            break;
                        case 1:
                        	String loc = nextCell.getRichStringCellValue().toString();
                        	double latitude = Double.parseDouble(loc.split(", ",2)[0]);
                    		double longitude = Double.parseDouble(loc.split(", ",2)[1]);
                    		ms.setLatitude(latitude);
                    		ms.setLongitude(longitude);
                            break;
                        default:
                        	String time = "";
                        	if(nextCell.getCellType() == CellType.STRING) {
                        		time = nextCell.getStringCellValue();
                        	}else if(nextCell.getCellType() == CellType.FORMULA || nextCell.getCellType() == CellType.NUMERIC) {
                            	Date date = (Date) nextCell.getDateCellValue();
                            	SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");
                            	time = formatTime.format(date);                            	
                        	}
                        	String trainId = "train"+ i + "-"+ train++;
                        	TrainTiming tt = new TrainTiming();
                        	tt.setSerialNo(trainSeq++);
                        	tt.setStationId(stationId);
                        	tt.setTrainId(trainId);
                        	tt.setTime(time);
                        	trainTimingRepository.save(tt);
                        }
                    }
                    stationId++;
                    metroStationsRepository.save(ms);
                }
            }            
            workbook.close();             
            long end = System.currentTimeMillis();
            System.out.printf("Excel data import done in %d ms\n", (end - start));             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        }
	}
}
