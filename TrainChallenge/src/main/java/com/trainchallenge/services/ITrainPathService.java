package com.trainchallenge.services;

import com.trainchallenge.entities.TrainPath;

public interface ITrainPathService {
    TrainPath combinePaths(String  firstTrainName,String secondTrainName);
    TrainPath getTrainPath(String trainName);
    String getFirstIntersection(String firstTrain,String secondTrain);
    
}