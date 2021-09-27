package com.trainchallenge.dto;

import java.util.List;
import java.util.Objects;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.Train;
import com.trainchallenge.entities.TrainPath;
public class CombinedTrain {

    private final String trainName;
    private List<Bogie> bogies;
    private Station currentStation;
    private  TrainPath trainPath;
    private final Train firstTrain;
    private final Train secondTrain;
  

    public CombinedTrain(String trainName,Train firstTrain,Train secondTrain) {
        this.trainName=trainName;
        this.firstTrain=firstTrain;
        this.secondTrain=secondTrain;
    }

    public CombinedTrain(String trainName, List<Bogie> bogies, Station currentStation, TrainPath trainPath, Train firstTrain, Train secondTrain) {
        this.trainName = trainName;
        this.bogies = bogies;
        this.currentStation = currentStation;
        this.trainPath = trainPath;
        this.firstTrain = firstTrain;
        this.secondTrain = secondTrain;
    }

    public String getTrainName() {
        return this.trainName;
    }


    public List<Bogie> getBogies() {
        return this.bogies;
    }

    public void setBogies(List<Bogie> bogies) {
        this.bogies = bogies;
    }

    public Station getCurrentStation() {
        return this.currentStation;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }

    public TrainPath getTrainPath() {
        return this.trainPath;
    }

    public void setTrainPath(TrainPath trainPath) {
        this.trainPath = trainPath;
    }

    public Train getFirstTrain() {
        return this.firstTrain;
    }


    public Train getSecondTrain() {
        return this.secondTrain;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CombinedTrain)) {
            return false;
        }
        CombinedTrain combinedTrain = (CombinedTrain) o;
        return Objects.equals(trainName, combinedTrain.trainName) && Objects.equals(bogies, combinedTrain.bogies) && Objects.equals(currentStation, combinedTrain.currentStation) && Objects.equals(trainPath, combinedTrain.trainPath) && Objects.equals(firstTrain, combinedTrain.firstTrain) && Objects.equals(secondTrain, combinedTrain.secondTrain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainName, bogies, currentStation, trainPath, firstTrain, secondTrain);
    }

    @Override
    public String toString() {
        return "{" +
            " trainName='" + getTrainName() + "'" +
            ", bogies='" + getBogies() + "'" +
            ", currentStation='" + getCurrentStation() + "'" +
            ", trainPath='" + getTrainPath() + "'" +
            ", firstTrain='" + getFirstTrain() + "'" +
            ", secondTrain='" + getSecondTrain() + "'" +
            "}";
    }


    

    
    

}