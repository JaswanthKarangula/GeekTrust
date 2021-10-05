package com.trainchallenge.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.trainchallenge.entities.Bogie;

import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.entities.TrainStatus;
import com.trainchallenge.exceptions.NoSuchTrainFoundException;
import com.trainchallenge.exceptions.NoSuchTrainPathException;
import com.trainchallenge.exceptions.StationMissmatchException;
import com.trainchallenge.repositories.ITrainRepository;
import com.trainchallenge.utils.Util;

public class TrainService implements ITrainService {

    ITrainRepository trainRepository;
    ITrainPathService trainPathService;
    IBogieService bogieservice;

    public TrainService(ITrainPathService trainPathService, IBogieService bogieService,
            ITrainRepository trainRepository) {
        this.trainRepository = trainRepository;
        this.bogieservice = bogieService;
        this.trainPathService = trainPathService;

    }

    @Override
    public Train combineTrains(String firstTrainName, String secondTrainName) throws NoSuchTrainFoundException,
            StationMissmatchException {
        Train firstTrain = trainRepository.getTrainByName(firstTrainName);
        Train secondTrain = trainRepository.getTrainByName(secondTrainName);
        // if (firstTrain.getTrainPath().getCurreStation().getStationCode().equals(secondTrain.getTrainPath().getCurreStation().getStationCode())) {

        //     throw new StationMissmatchException();
        // }
        firstTrain.moveToNextStop(firstTrain.getTrainPath().getPath());
        secondTrain.moveToNextStop(secondTrain.getTrainPath().getPath());
        String trainName = Util.getCombinedTrainName(firstTrainName, secondTrainName);
        TrainPath trainPath = trainPathService.combinePaths(firstTrainName, secondTrainName);
        List<Bogie> bogies = combineBogies(firstTrainName, secondTrainName);
        TrainStatus trainStatus = firstTrain.getTrainStatus();
        Train combinedTrain = trainRepository.saveTrain(trainName, bogies, trainStatus, trainPath);
        combinedTrain.setFirstTrain(firstTrainName);
        combinedTrain.setSecondTrain(secondTrainName);
        updateStatus(combinedTrain);
        trainRepository.updateTrain(combinedTrain.getTrainName(), combinedTrain);
        return combinedTrain;
    }

    public List<Bogie> combineBogies(String firstTrainName, String secondTrainName) {
        Train firstTrain = trainRepository.getTrainByName(firstTrainName);
        Train secondTrain = trainRepository.getTrainByName(secondTrainName);
        List<Bogie> bogies1 = firstTrain.getBogies();
        List<Bogie> bogies2 = secondTrain.getBogies();
        List<Bogie> commbinedBogies = new ArrayList<>(bogies1);
        commbinedBogies.addAll(bogies2);
        for (Bogie bogie : commbinedBogies) {
            // System.out.println(bogie.getDestinationStationCode()+"---------------"+bogie.getDestinationDistance());
            if (firstTrain.getTrainPath().getPathMap().containsKey(bogie.getDestinationStationCode())) {
                updateBogieDistance(bogie, firstTrain.getTrainPath(), "HYB");
            } else {
                updateBogieDistance(bogie, secondTrain.getTrainPath(), "HYB");
            }
        }
        Collections.sort(commbinedBogies, BogieComparator);
        return commbinedBogies;
    }

    void updateBogieDistance(Bogie bogie, TrainPath trainPath, String from) {
        Double distance = trainPath.getPathMap().get(bogie.getDestinationStationCode()).getStationDistanc()
                - trainPath.getPathMap().get(from).getStationDistanc();
        bogie.setDestinationDistance(distance);
    }

    private void updateStatus(Train train) {
        if (train.getBogies().size() == 0) {
            train.setTrainStatus(TrainStatus.JOURNEY_ENDED);
        } else {
            train.setTrainStatus(TrainStatus.DEPARTURED);
        }
    }

    @Override
    public List<Train> splitTrain(String trainName) throws NoSuchTrainPathException {
        Train train=trainRepository.getTrainByName(trainName);
        Train firstTrain=trainRepository.getTrainByName( train.getFirstTrain());
        Train secondTrain=trainRepository.getTrainByName(train.getSecondTrain());
        List<Bogie> combinedBogies=train.getBogies();
        List<List<Bogie>> bogies=bogieservice.splitBogies(combinedBogies, firstTrain.getTrainPath(), secondTrain.getTrainPath());
        firstTrain.setBogies(bogies.get(0));
        firstTrain.setTrainStatus(train.getTrainStatus());
        secondTrain.setBogies(bogies.get(1));
        secondTrain.setTrainStatus(train.getTrainStatus());
        trainRepository.updateTrain(firstTrain.getTrainName(),firstTrain);
        trainRepository.updateTrain(secondTrain.getTrainName(),firstTrain);
        return Arrays.asList(firstTrain,secondTrain);
    }

    

    
    public Train getTrain(String trainName){
        return trainRepository.getTrainByName(trainName);
    }

    public Train saveTrain(String trainName,List<Bogie> bogies, TrainStatus trainStatus, TrainPath trainPath){

        return trainRepository.saveTrain(trainName, bogies, trainStatus, trainPath);
    }

    public void updateTrain(String trainName,Train train){
         trainRepository.updateTrain(trainName, train);
    }

    public static Comparator<Bogie> BogieComparator= new Comparator<Bogie>(){
        public int compare(Bogie bogie1 , Bogie bogie2){
            Double distance1=bogie1.getDestinationDistance();
            Double distance2=bogie2.getDestinationDistance();
            return distance2.compareTo(distance1);
        }
    };
    
}