package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.services.ITrainService;

public class DisplayTrainsCommand implements ICommand {

    private final ITrainService trainService;

    public DisplayTrainsCommand(ITrainService trainService){
        this.trainService=trainService;
    }

    @Override
    public void execute(List<String> tokens) {
        
        String firstTrainName=tokens.get(0);
        Train firstTrain=trainService.getTrain(firstTrainName);
        String secondTrainName=tokens.get(1);
        Train secondTrain=trainService.getTrain(secondTrainName);
        if(firstTrain.getTrainStatus()==TrainStatus.ARRIVAL && secondTrain.getTrainStatus()==TrainStatus.ARRIVAL ){
            displayArrivalMessage(firstTrain);
            displayArrivalMessage(secondTrain);
        }
        

    }

    

    private void displayArrivalMessage(Train train) {
        if(train.getTrainStatus()==TrainStatus.ARRIVAL){
            System.out.print("ARRIVAL "+train.getTrainName()+" ENGINE");
            for(Bogie bogie:train.getBogies()){
                System.out.print(" "+bogie.getDestinationStationCode());;
            }
            System.out.println();
        }
    }
    
}