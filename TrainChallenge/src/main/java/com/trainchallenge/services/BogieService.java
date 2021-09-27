package com.trainchallenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.TrainPath;

public class BogieService implements IBogieService {

    @Override
    public List<Bogie> combineBogies(List<Bogie> bogies1, List<Bogie> bogies2) {
        
    List<Bogie> commbinedBogies= new ArrayList<>(bogies1);
    commbinedBogies.addAll(bogies2);
    //TODO: sortbogies
    return commbinedBogies;
    }

    @Override
    public List<List<Bogie>> splitBogies(List<Bogie> bogies, TrainPath firstTrainPath, TrainPath secondTrainPath) {
        Map<String,Station> firstTrainPathMap=firstTrainPath.getPathMap(); 
        Map<String,Station> secondTrainPathMap=secondTrainPath.getPathMap(); 
        List<Bogie> firstTrainBogies=new ArrayList<>();
        List<Bogie> secondTrainBogies=new ArrayList<>();
        for(Bogie bogie:bogies){
            if(firstTrainPathMap.containsKey(bogie.getDestinationStationCode())){
                firstTrainBogies.add(bogie);
            }
            else if(secondTrainPathMap.containsKey(bogie.getDestinationStationCode())){
                secondTrainBogies.add(bogie);
            }
            else{
                //TODO: Throw new Exception;
            }
        }
        List<List<Bogie>> result =new ArrayList<List<Bogie>>();
        result.add(firstTrainBogies);
        result.add(secondTrainBogies);
        return result;
    }
    
}