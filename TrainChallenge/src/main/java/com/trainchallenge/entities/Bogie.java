package com.trainchallenge.entities;

import java.util.Objects;

public class Bogie {
    
    String destinationStationCode;
    Station currentStation;
    String trainName;
    int numOfPeople;
    Double destinationDistance;

    
    public Bogie(String destinationStationCode,String trainName) {

    }



    public Bogie(String destinationStation, Station currentStation, String trainName, Double destinationDistance) {
        this.destinationStationCode = destinationStation;
        this.currentStation = currentStation;
        this.trainName = trainName;
        
        this.destinationDistance = destinationDistance;
    }

    public String getDestinationStationCode() {
        return this.destinationStationCode;
    }

    public void setDestinationStationCode(String destinationStation) {
        this.destinationStationCode = destinationStation;
    }

    public Station getCurrentStation() {
        return this.currentStation;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getNumOfPeople() {
        return this.numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public Double getDestinationDistance() {
        return this.destinationDistance;
    }

    public void setDestinationDistance(Double destinationDistance) {
        this.destinationDistance = destinationDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Bogie)) {
            return false;
        }
        Bogie bogie = (Bogie) o;
        return Objects.equals(destinationStationCode, bogie.destinationStationCode) && Objects.equals(currentStation, bogie.currentStation) && Objects.equals(trainName, bogie.trainName) && numOfPeople == bogie.numOfPeople && Objects.equals(destinationDistance, bogie.destinationDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationStationCode, currentStation, trainName, numOfPeople, destinationDistance);
    }

    @Override
    public String toString() {
        return "{" +
            " destinationStation='" + getDestinationStationCode() + "'" +
            ", currentStation='" + getCurrentStation() + "'" +
            ", trainName='" + getTrainName() + "'" +
            ", numOfPeople='" + getNumOfPeople() + "'" +
            ", destinationDistance='" + getDestinationDistance() + "'" +
            "}";
    }
    
}