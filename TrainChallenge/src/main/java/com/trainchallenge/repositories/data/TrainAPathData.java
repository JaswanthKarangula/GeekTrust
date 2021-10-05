package com.trainchallenge.repositories.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.trainchallenge.entities.Station;
import com.trainchallenge.repositories.IPathRepository;

public class TrainAPathData implements IData {

    //IStationRepository stationRepository;
    IPathRepository pathRepository;
    public TrainAPathData(IPathRepository pathRepository) {
        this.pathRepository=pathRepository;
	}

	public void loadData(String dataPath, String delimiter) {
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(dataPath));
            String line = reader.readLine();
            List<Station> path= new ArrayList<>();
            //System.out.println("------------------------TRain-- A Pathh  --------------------");
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(delimiter));
     
                Station station= createStation(tokens);
                //System.out.println(station.getStationCode());
                path.add(station);
                line = reader.readLine();
            }
            pathRepository.addTrainPath("TRAIN_A", path);
           
            //System.out.println(path);
           
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Station createStation(List<String> tokens){
        String stationName=tokens.get(0);
                String stationCode=tokens.get(1);
                Double stationDistance=Double.parseDouble(tokens.get(3));
                return  new Station(stationName, stationCode, stationDistance);
    }
    
}