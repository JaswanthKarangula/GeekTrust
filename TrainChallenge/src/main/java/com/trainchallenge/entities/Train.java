package com.trainchallenge.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {
    private final String trainName;
    private final Integer id;
    private List<Bogie> bogies;
    private final TrainPath trainPath;
    private TrainStatus trainStatus;
    private String firstTrain;
    private String secondTrain;
 
    private int stationIndex=0;

    public Train(String trainName, Integer id, TrainPath trainPath) {
        this.trainName = trainName;
        this.id = id;
        this.trainPath = trainPath;
    }


    public Train(String trainName, Integer id, List<Bogie> bogies, TrainPath trainPath, TrainStatus trainStatus) {
        this.trainName = trainName;
        this.id = id;
        this.bogies = bogies;
        this.trainPath = trainPath;
        this.trainStatus = trainStatus;
        //System.out.println(trainPath.getCurreStation());
        
        // for(Bogie bogie:bogies){
        //     System.out.println(this.trainName+"-----"+bogie.getDestinationStationCode()+"---------------"+bogie.getDestinationDistance());
        // }
    }

    public String getTrainName() {
        return this.trainName;
    }


    public Integer getId() {
        return this.id;
    }


    public List<Bogie> getBogies() {
        return this.bogies;
    }

    public void setBogies(List<Bogie> bogies) {
        this.bogies = bogies;
    }

    public TrainPath getTrainPath() {
        return this.trainPath;
    }


    public TrainStatus getTrainStatus() {
        return this.trainStatus;
    }

    public void setTrainStatus(TrainStatus trainStatus) {
        this.trainStatus = trainStatus;
    }

    public void setFirstTrain(String firstTrain){
        this.firstTrain=firstTrain;
    }
    public void setSecondTrain(String secondTrain){
        this.secondTrain=secondTrain;
    }
    public String getFirstTrain(){
        return firstTrain;
    }
    public String getSecondTrain(){
        return secondTrain;
    }

    public void moveToNextStop(List<Station> path){
        stationIndex++;
        Station nextstation;
        if(stationIndex < path.size() && stationIndex>=0 ){
             nextstation= path.get(stationIndex);
        }
        else{
            nextstation=null;
        }
        //System.out.println("Removed      "+trainPath.getCurreStation().getStationCode());
            List<Bogie> newList= new ArrayList<>();
            for(Bogie bogie:bogies){
                if(bogie.getDestinationStationCode().equals(trainPath.getCurreStation().getStationCode())){
                    //continue;
                    //System.out.println("Removed      "+bogie.getDestinationStationCode());
                }
                else{
                    newList.add(bogie);
                }
            }
            bogies=newList;
            trainPath.setCurreStation(nextstation);
            
       
    }

    public void moveUpToStation(String stationCode){
        List<Station> path=trainPath.getPath();
       // System.out.println(path.size());
        
        for(Station station:path){
           // System.out.println(this.trainName+"-------"+station.getStationCode());
            if(!station.getStationCode().equals(stationCode))
            moveToNextStop(path);
            else{
                break;
            }
            
        } 
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Train)) {
            return false;
        }
        Train train = (Train) o;
        return Objects.equals(trainName, train.trainName) && Objects.equals(id, train.id) && Objects.equals(bogies, train.bogies) && Objects.equals(trainPath, train.trainPath) && Objects.equals(trainStatus, train.trainStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainName, id, bogies, trainPath, trainStatus);
    }

    @Override
    public String toString() {
        return "{" +
            " trainName='" + getTrainName() + "'" +
            ", id='" + getId() + "'" +
            ", bogies='" + getBogies() + "'" +
            ", trainPath='" + getTrainPath() + "'" +
            ", trainStatus='" + getTrainStatus() + "'" +
            "}";
    }

    
}