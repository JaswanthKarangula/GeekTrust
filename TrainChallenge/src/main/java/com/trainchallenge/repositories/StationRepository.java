package com.trainchallenge.repositories;

import java.util.HashMap;
import java.util.Map;

import com.trainchallenge.entities.Station;


public class StationRepository implements IStationRepository {

    private static Integer counter=0;
    private final Map<String,Station> stationCodeMap;
    private final Map<Integer,Station> stationIdMap;


    public StationRepository(){
        stationIdMap=new HashMap<>();
        stationCodeMap=new HashMap<>();
    }
    public StationRepository(Map<String,Station> stationCodeMap, Map<Integer,Station> stationIdMap,Integer counter) {
        this.stationCodeMap = stationCodeMap;
        this.stationIdMap = stationIdMap;
        this.counter=counter;
    }


    @Override
    public Station getStationByCode(String stationCode) {
        
        return stationCodeMap.get(stationCode) ;
    }

    @Override
    public Station getStationById(Integer id) {
        
        return stationIdMap.get(id);
    }

    @Override
    public Station saveStation(String stationName, String stationCode) {
       
        counter++;
        Station station= new Station(counter, stationName, stationCode);
        stationCodeMap.put(stationCode, station);
        stationIdMap.put(counter, station);
        return station;

    }
    
}