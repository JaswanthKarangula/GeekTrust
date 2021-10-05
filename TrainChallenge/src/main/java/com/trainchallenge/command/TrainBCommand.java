package com.trainchallenge.command;

import java.util.ArrayList;
import java.util.List;
import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.services.ITrainPathService;
import com.trainchallenge.services.ITrainService;

public class TrainBCommand implements ICommand {

    private final ITrainService trainService;
    //IStationService stationService;
    private final ITrainPathService trainPathService;

    public TrainBCommand(ITrainService trainService, ITrainPathService trainPathService) {
        this.trainService = trainService;
        this.trainPathService = trainPathService;
    }
    
    @Override
    public void execute(List<String> tokens) {
        
        String trainName=tokens.get(0);
        List<Bogie> bogies = new ArrayList<>();
        //Station currentStation= stationService.getStation("CHN");
        TrainPath trainPath=trainPathService.getTrainPath(trainName);
       // System.out.println("----------------------"+trainName+"-------------------------------");
        for(int i=2;i<tokens.size();++i){
            String destinationStationCode=tokens.get(i);
            Double destinationDistance=trainPath.getDistance(destinationStationCode);
            Bogie bogie= new Bogie(destinationStationCode,null,trainName,destinationDistance);
            bogies.add(bogie);
        }
        TrainStatus trainStatus=TrainStatus.RUNNING;
        //Train train=
        trainService.saveTrain(trainName, bogies, trainStatus, trainPath);
        //System.out.println(train.getTrainName()+"      "+bogies.size()+"    ");

    }
    
}