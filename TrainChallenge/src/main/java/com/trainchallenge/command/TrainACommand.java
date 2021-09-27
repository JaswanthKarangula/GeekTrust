package com.trainchallenge.command;

import java.util.ArrayList;
import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.services.IStationService;
import com.trainchallenge.services.ITrainPathService;
import com.trainchallenge.services.ITrainService;

public class TrainACommand implements ICommand {

    ITrainService trainService;
    IStationService stationService;
    ITrainPathService trainPathService;
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String trainName=tokens.get(0);
        List<Bogie> bogies = new ArrayList<>();
        Station currentStation= stationService.getStation("CHN");
        TrainPath trainPath=trainPathService.getTrainPath(trainName);
        for(int i=3;i<tokens.size();++i){
            String destinationStationCode=tokens.get(i);
            Double destinationDistance=trainPath.getDistance(destinationStationCode);
            Bogie bogie= new Bogie(destinationStationCode,currentStation,trainName,destinationDistance);
            bogies.add(bogie);
        }
        TrainStatus trainStatus=TrainStatus.RUNNING;
        trainService.saveTrain(trainName, bogies, trainStatus, trainPath);

    }
    
}