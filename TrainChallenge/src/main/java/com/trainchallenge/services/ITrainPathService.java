package com.trainchallenge.services;

import com.trainchallenge.entities.TrainPath;

public interface ITrainPathService {
    TrainPath combinePaths(TrainPath firstTrainPath,TrainPath secondTrainPath);
    TrainPath getTrainPath(String trainName);
    
}