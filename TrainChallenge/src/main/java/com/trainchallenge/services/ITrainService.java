package com.trainchallenge.services;

import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;

public interface ITrainService {
    Train combineTrains(String firstTrainName, String secondTrainName);
    List<Train> splitTrain(String trainName);
    Train moveTrainToNextStation(Train train);
    Train getTrain(String trainName);
    Train saveTrain(String trainName,List<Bogie> bogies, TrainStatus trainStatus, TrainPath trainPath);
}