package com.trainchallenge.services;


import java.util.List;
import java.util.Map;


import com.trainchallenge.entities.Station;

import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.repositories.IPathRepository;
import com.trainchallenge.utils.Util;

public class TrainPathService implements ITrainPathService {

    IPathRepository pathRepository;

    public TrainPathService(IPathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    @Override
    public TrainPath combinePaths(String firstTrainName, String secondTrainName) {
        TrainPath firstTrainPath = pathRepository.getTrainPath(firstTrainName);
        TrainPath secondTrainPath = pathRepository.getTrainPath(secondTrainName);
        List<Station> newPathList = firstTrainPath.getPath();
        newPathList.addAll(secondTrainPath.getPath());
        String combinedTrainName =Util.getCombinedTrainName(firstTrainName, secondTrainName);
        return pathRepository.addTrainPath(combinedTrainName, newPathList);
    }

    @Override
    public TrainPath getTrainPath(String trainName) {

        return pathRepository.getTrainPath(trainName);
    }

    @Override
    public String getFirstIntersection(String firstTrainName, String secondTrainName) {
        
        TrainPath firstTrainPath = pathRepository.getTrainPath(firstTrainName);
        TrainPath secondTrainPath = pathRepository.getTrainPath(secondTrainName);
        List<Station> path = firstTrainPath.getPath();
        // for (Station station : path) {
        //     System.out.println(station.getStationCode());
        // }
        // System.out.println();
        // System.out.println();
        Map<String, Station> pathMap = secondTrainPath.getPathMap();
        //System.out.println(pathMap.keySet());
        for(Station station : path){
            if(pathMap.containsKey(station.getStationCode())){
                return station.getStationCode();
            }
        }

        return null;
    }
    
}