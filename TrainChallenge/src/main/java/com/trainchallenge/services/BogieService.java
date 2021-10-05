package com.trainchallenge.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.exceptions.NoSuchTrainPathException;

public class BogieService implements IBogieService {

    @Override
    public List<Bogie> combineBogies(List<Bogie> bogies1, List<Bogie> bogies2) {
       // System.out.println("-----------------------------------------------------------------------");
    List<Bogie> commbinedBogies= new ArrayList<>(bogies1);
    commbinedBogies.addAll(bogies2);
    // for(Bogie bogie:commbinedBogies){
    //    // System.out.println(bogie.getDestinationStationCode()+"---------------"+bogie.getDestinationDistance());
    // }
    Collections.sort(commbinedBogies,BogieComparator);
    return commbinedBogies;
    }

    @Override
    public List<List<Bogie>> splitBogies(List<Bogie> bogies, TrainPath firstTrainPath, TrainPath secondTrainPath)
            throws NoSuchTrainPathException {
        Map<String,Station> firstTrainPathMap=firstTrainPath.getPathMap(); 
        Map<String,Station> secondTrainPathMap=secondTrainPath.getPathMap(); 
        List<Bogie> firstTrainBogies=new ArrayList<>();
        List<Bogie> secondTrainBogies=new ArrayList<>();

        for(Bogie bogie:bogies){
            if(bogie.getDestinationStationCode().equals(firstTrainPath.getCurreStation().getStationCode())){
                //remove or not add that bogie
                continue;
            }
            else if(firstTrainPathMap.containsKey(bogie.getDestinationStationCode())
               ){
                firstTrainBogies.add(bogie);
            }
            else if(secondTrainPathMap.containsKey(bogie.getDestinationStationCode())){
                secondTrainBogies.add(bogie);
            }
            else{
                throw new NoSuchTrainPathException();
            }
        }
        List<List<Bogie>> result =new ArrayList<List<Bogie>>();
        result.add(firstTrainBogies);
        result.add(secondTrainBogies);
        return result;
    }

    public static Comparator<Bogie> BogieComparator= new Comparator<Bogie>(){
        public int compare(Bogie bogie1 , Bogie bogie2){
            Double distance1=bogie1.getDestinationDistance();
            Double distance2=bogie2.getDestinationDistance();
            return distance2.compareTo(distance1);
        }
    };
    
}