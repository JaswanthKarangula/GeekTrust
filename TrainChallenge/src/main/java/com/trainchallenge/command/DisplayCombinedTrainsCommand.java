package com.trainchallenge.command;

import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.services.ITrainService;
import com.trainchallenge.utils.Util;

public class DisplayCombinedTrainsCommand  implements ICommand{

    private final ITrainService trainService;

    public DisplayCombinedTrainsCommand(ITrainService trainService){
        this.trainService=trainService;
    }
    @Override
    public void execute(List<String> tokens) {
        
        String firstTrainName=tokens.get(0);
        String secondTrainName=tokens.get(1);
        String combinedTrainName=Util.getCombinedTrainName(firstTrainName, secondTrainName);
        Train combinedTrain=trainService.getTrain(combinedTrainName);
    
        if(combinedTrain.getTrainStatus()==TrainStatus.JOURNEY_ENDED){
            displayJourneyEnded();
        }
        else{
            
            displayDepartureMessage(combinedTrain);
        }

    }

    private void displayJourneyEnded() {
        System.out.println("JOURNEY_ENDED");
    }

    private void displayDepartureMessage(Train train){
        if(train.getTrainStatus()==TrainStatus.DEPARTURED){
            System.out.print("DEPARTURE "+train.getTrainName()+" ENGINE ENGINE");
            for(Bogie bogie:train.getBogies()){
                System.out.print(" "+bogie.getDestinationStationCode());
            }
            System.out.println();
        }
    }
    
}