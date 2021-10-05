package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.exceptions.NoSuchTrainFoundException;
import com.trainchallenge.exceptions.StationMissmatchException;
import com.trainchallenge.services.ITrainService;

public class CombineTrainsCommand implements ICommand {

    private final ITrainService trainService;

    public CombineTrainsCommand(ITrainService trainService) {
        this.trainService = trainService;
    }
    @Override
    public void execute(List<String> tokens) {
        try{
        trainService.combineTrains(tokens.get(0), tokens.get(1));
        }
        catch(NoSuchTrainFoundException | StationMissmatchException e ){
            e.printStackTrace();
        }

    }
    
}