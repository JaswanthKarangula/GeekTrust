package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.services.ITrainPathService;
import com.trainchallenge.services.ITrainService;

public class MoveTrainsTillIntersectionCommand implements ICommand {

    private final ITrainService trainService;
    private  final ITrainPathService trainPathService;
    

    public MoveTrainsTillIntersectionCommand(ITrainService trainService, ITrainPathService trainPathService) {
        this.trainService = trainService;
        this.trainPathService = trainPathService;
    }

    @Override
    public void execute(List<String> tokens) {
        String firstTrainName=tokens.get(0);
        Train firstTrain=trainService.getTrain(firstTrainName);
        String secondTrainName=tokens.get(1);
        Train secondTrain=trainService.getTrain(secondTrainName);
        String intersectingStationCode=trainPathService.getFirstIntersection(firstTrainName, secondTrainName);
        //System.out.println(intersectingStationCode);
        firstTrain.moveUpToStation(intersectingStationCode);
        secondTrain.moveUpToStation(intersectingStationCode);
        firstTrain.setTrainStatus(TrainStatus.ARRIVAL);
        secondTrain.setTrainStatus(TrainStatus.ARRIVAL);
        trainService.updateTrain(firstTrainName, firstTrain);
        trainService.updateTrain(secondTrainName, secondTrain);
        
        //System.out.println(firstTrain.getBogies());
        // for (Bogie bogie : firstTrain.getBogies()) {
        //     System.out.println(bogie.getDestinationStationCode());
        // }
        // System.out.println();
        // for (Bogie bogie : secondTrain.getBogies()) {
        //     System.out.println(bogie.getDestinationStationCode());
        // }
    }
    
}