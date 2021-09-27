package com.trainchallenge.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;

public class TrainRepository implements ITrainRepository {

    private static int counter=0;
    private final Map<String,Train> trainNameMap;
    private final Map<Integer,Train> trainIdMap;

    
    TrainRepository(){
        trainIdMap=new HashMap<>();
        trainNameMap=new HashMap<>();
    }
    TrainRepository(Map<String,Train> trainNameMap,Map<Integer,Train> trainIdMap,int counter){
        this.trainNameMap=trainNameMap;
        this.trainIdMap=trainIdMap;
        TrainRepository.counter=counter;
    }
    
    @Override
    public Train getTrainByName(String trainName) {
        
        return trainNameMap.get(trainName);
    }

    @Override
    public Train getTrainById(Integer id) {
        
        return trainIdMap.get(id);
    }

    @Override
    public Train saveTrain(String trainName,List<Bogie> bogies, TrainStatus trainStatus, TrainPath trainPath) {
        
        TrainRepository.counter++;
        Train train=new Train(trainName, counter, bogies, trainPath, trainStatus);
        trainNameMap.put(trainName, train);
        trainIdMap.put(counter,train);
        return train;
    }

    @Override
    public void updateTrain(Integer id, Train train) {
        trainIdMap.put(id, train);
        trainNameMap.put(train.getTrainName(), train);

    }
    
}