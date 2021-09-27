package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.services.ITrainService;
import com.trainchallenge.utils.Util;

public class DisplayTrainCommand implements ICommand {

    ITrainService trainService;

    DisplayTrainCommand(ITrainService trainService){
        this.trainService=trainService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String firstTrainName=tokens.get(0);
        Train firstTrain=trainService.getTrain(firstTrainName);
        String secondTrainName=tokens.get(0);
        Train secondTrain=trainService.getTrain(secondTrainName);
        String combinedTrainName=Util.getCombinedTrainName(firstTrainName, secondTrainName);
        Train combinedTrain=trainService.getTrain(combinedTrainName);
        if(firstTrain.getTrainStatus()==TrainStatus.ARRIVAL && secondTrain.getTrainStatus()==TrainStatus.ARRIVAL ){
            displayArrivalMessage(firstTrain);
            displayArrivalMessage(secondTrain);
            displayDepartureMessage(combinedTrain);;
        }
        else if(combinedTrain.getTrainStatus()==TrainStatus.JOURNEY_ENDED){
            displayJourneyEnded();
        }
        else{
            //TODO: throw new exception;
        }

    }

    private void displayJourneyEnded() {
        System.out.println("JOURNEY_ENDED");
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

    private void displayDepartureMessage(Train train){
        if(train.getTrainStatus()==TrainStatus.DEPARTURED){
            System.out.print("DEPARTURE "+train.getTrainName()+" ENGINE ENGINE ");
            for(Bogie bogie:train.getBogies()){
                System.out.print(" "+bogie.getDestinationStationCode());
            }
            System.out.println();
        }
    }
    
}