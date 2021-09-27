package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.entities.Train;
import com.trainchallenge.services.ITrainService;

public class CombineTrainsCommand implements ICommand {

    ITrainService trainService;
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        // Train firstTrain=trainService.getTrain(tokens.get(0));
        // Train secondTrain=trainService.getTrain(tokens.get(1));
        trainService.combineTrains(tokens.get(0), tokens.get(1));

    }
    
}