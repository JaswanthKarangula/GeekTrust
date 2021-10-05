package com.trainchallenge.repositories;

import java.util.List;

import com.trainchallenge.entities.Bogie;

import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;

public interface ITrainRepository {
    Train getTrainByName(String trainName);
    Train getTrainById(Integer id);
    Train saveTrain(String trainName,List<Bogie> bogies,TrainStatus trainStatus,TrainPath trainPath);
	void updateTrain(String trainName, Train firstTrain);
}