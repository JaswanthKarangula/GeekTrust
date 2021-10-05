package com.trainchallenge.services;

import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.exceptions.NoSuchTrainFoundException;
import com.trainchallenge.exceptions.NoSuchTrainPathException;
import com.trainchallenge.exceptions.StationMissmatchException;

public interface ITrainService {
    Train combineTrains(String firstTrainName, String secondTrainName) throws NoSuchTrainFoundException, StationMissmatchException;
    List<Train> splitTrain(String trainName) throws NoSuchTrainPathException;
    //Train moveTrainToNextStation(Train train);
    Train getTrain(String trainName);
    Train saveTrain(String trainName,List<Bogie> bogies, TrainStatus trainStatus, TrainPath trainPath);
    void updateTrain(String trainName, Train train);
}