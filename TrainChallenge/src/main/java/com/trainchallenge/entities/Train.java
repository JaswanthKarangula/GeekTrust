package com.trainchallenge.entities;


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