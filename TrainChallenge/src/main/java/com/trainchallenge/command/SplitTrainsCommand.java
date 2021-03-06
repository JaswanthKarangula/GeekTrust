package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.services.ITrainService;

public class SplitTrainsCommand implements ICommand {

    ITrainService trainService;

    SplitTrainsCommand(ITrainService trainService){
        this.trainService=trainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
        trainService.splitTrain(tokens.get(0));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
}