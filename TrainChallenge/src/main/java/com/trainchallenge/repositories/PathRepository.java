package com.trainchallenge.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.TrainPath;

public class PathRepository implements IPathRepository {

    private final Map<String,TrainPath> trainPathMap;
    public PathRepository(){
        trainPathMap= new HashMap<>();
    }
    public PathRepository(Map<String,TrainPath> trainPathMap) {
        this.trainPathMap = trainPathMap;
    }
    @Override
    public TrainPath addTrainPath(String trainName, List<Station> path) {
        TrainPath trainPath= new TrainPath(path);
        trainPathMap.put(trainName, trainPath);
        return trainPath;
    }

    @Override
    public TrainPath getTrainPath(String trainName) {
        
        return trainPathMap.get(trainName);
    }
    
}