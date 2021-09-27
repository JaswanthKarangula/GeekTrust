package com.trainchallenge.services;

import java.util.Arrays;
import java.util.List;
import com.trainchallenge.entities.Bogie;

import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.repositories.ITrainRepository;
import com.trainchallenge.utils.Util;


public class TrainService implements ITrainService {

    ITrainRepository trainRepository;
    ITrainPathService trainPathService;
    IBogieService bogieservice;


    @Override
    public Train combineTrains(String firstTrainName, String secondTrainName) {
        Train firstTrain=trainRepository.getTrainByName(firstTrainName);
        Train secondTrain=trainRepository.getTrainByName(secondTrainName);
        if(firstTrain.getTrainPath().getCurreStation() !=secondTrain.getTrainPath().getCurreStation()){
            //TODO : Throw new exception 
            ;
        }
        String trainName=Util.getCombinedTrainName(firstTrainName, secondTrainName);
        TrainPath trainPath=trainPathService.combinePaths(firstTrain.getTrainPath(),secondTrain.getTrainPath());
        List<Bogie> bogies=bogieservice.combineBogies(firstTrain.getBogies(),secondTrain.getBogies());
        TrainStatus trainStatus=firstTrain.getTrainStatus();
        Train combinedTrain= trainRepository.saveTrain(trainName, bogies, trainStatus, trainPath);
        combinedTrain.setFirstTrain(firstTrainName);
        combinedTrain.setSecondTrain(secondTrainName);
        trainRepository.updateTrain(combinedTrain.getId(), combinedTrain);
        return combinedTrain;
    }

    @Override
    public List<Train> splitTrain(String trainName) {
        Train train=trainRepository.getTrainByName(trainName);
        Train firstTrain=trainRepository.getTrainByName( train.getFirstTrain());
        Train secondTrain=trainRepository.getTrainByName(train.getSecondTrain());
        List<Bogie> combinedBogies=train.getBogies();
        List<List<Bogie>> bogies=bogieservice.splitBogies(combinedBogies, firstTrain.getTrainPath(), secondTrain.getTrainPath());
        firstTrain.setBogies(bogies.get(0));
        firstTrain.setTrainStatus(train.getTrainStatus());
        secondTrain.setBogies(bogies.get(1));
        secondTrain.setTrainStatus(train.getTrainStatus());
        trainRepository.updateTrain(firstTrain.getId(),firstTrain);
        trainRepository.updateTrain(secondTrain.getId(),firstTrain);
        return Arrays.asList(firstTrain,secondTrain);
    }

    @Override
    public Train moveTrainToNextStation(Train train) {
        //TODO if()
        return null;
    }

    
    public Train getTrain(String trainName){
        return trainRepository.getTrainByName(trainName);
    }

    public Train saveTrain(String trainName,List<Bogie> bogies, TrainStatus trainStatus, TrainPath trainPath){

        return trainRepository.saveTrain(trainName, bogies, trainStatus, trainPath);
    }
    
}