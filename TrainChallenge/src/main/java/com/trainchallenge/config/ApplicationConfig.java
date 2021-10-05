package com.trainchallenge.config;

import com.trainchallenge.command.CombineTrainsCommand;
import com.trainchallenge.command.CommandInvoker;
import com.trainchallenge.command.DisplayCombinedTrainsCommand;
import com.trainchallenge.command.DisplayTrainsCommand;
import com.trainchallenge.command.ICommand;
import com.trainchallenge.command.MoveTrainsTillIntersectionCommand;
import com.trainchallenge.command.TrainACommand;
import com.trainchallenge.command.TrainBCommand;
import com.trainchallenge.repositories.IPathRepository;

import com.trainchallenge.repositories.ITrainRepository;
import com.trainchallenge.repositories.PathRepository;
import com.trainchallenge.repositories.TrainRepository;
import com.trainchallenge.repositories.data.DataLoader;

import com.trainchallenge.repositories.data.TrainAPathData;
import com.trainchallenge.repositories.data.TrainBPathData;
import com.trainchallenge.services.BogieService;
import com.trainchallenge.services.IBogieService;
import com.trainchallenge.services.IStationService;
import com.trainchallenge.services.ITrainPathService;
import com.trainchallenge.services.ITrainService;
import com.trainchallenge.services.StationService;
import com.trainchallenge.services.TrainPathService;
import com.trainchallenge.services.TrainService;

public class ApplicationConfig {
    IPathRepository iPathRepository = new PathRepository();
    ITrainRepository iTrainRepository = new TrainRepository();
    //IStationRepository iStationRepository = new StationRepository();
    

    IBogieService iBogieService = new BogieService();
    IStationService iStationService = new StationService();
    ITrainPathService iTrainPathService = new TrainPathService(iPathRepository);
    ITrainService iTrainService = new TrainService(iTrainPathService, iBogieService, iTrainRepository);

    ICommand trainACommand = new TrainACommand(iTrainService, iTrainPathService);
    ICommand trainBCommand = new TrainBCommand(iTrainService, iTrainPathService);
    ICommand moveTrainsTillIntersectionCommand = new MoveTrainsTillIntersectionCommand(iTrainService,
            iTrainPathService);
    ICommand mergeTrainsCommand = new CombineTrainsCommand(iTrainService);
    ICommand displayTrainCommand = new DisplayTrainsCommand(iTrainService);
    ICommand displayCombinedTrainsCommand = new DisplayCombinedTrainsCommand(iTrainService);



    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final DataLoader dataLoader = new DataLoader();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("TRAIN_A",trainACommand);
        commandInvoker.register("TRAIN_B",trainBCommand);
        commandInvoker.register("MOVE-UPTO-INTERSECTION",moveTrainsTillIntersectionCommand);
        commandInvoker.register("MERGE-TRAINS",mergeTrainsCommand);
        commandInvoker.register("DISPLAY-TRAINS",displayTrainCommand);
        commandInvoker.register("DISPLAY_COMBINED_TRAIN", displayCombinedTrainsCommand);
        return commandInvoker;
    }

    public DataLoader getDataLoader(){
         dataLoader.register("TRAIN_A",new TrainAPathData(iPathRepository));
         dataLoader.register("TRAIN_B",new TrainBPathData(iPathRepository));
        
        return dataLoader;
    }


    
    
}