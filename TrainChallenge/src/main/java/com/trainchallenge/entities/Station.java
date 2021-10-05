package com.trainchallenge.entities;

import java.util.Objects;

public class Station {
    
    private final String  stationName;
    private Double  lattitude;
    private Double longitude;
    private final Double stationDistance;
    private final String stationCode;

    public Station(String stationName,String stationCode,Double stationDistance) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.stationDistance=stationDistance;
        
    }

    public String getStationName() {
        return this.stationName;
    }


    public Double getLattitude() {
        return this.lattitude;
    }
   
    public Double getStationDistanc(){
        return stationDistance;
    }
    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStationCode() {
        return this.stationCode;
    }

    

   

    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Station)) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(stationName, station.stationName) && Objects.equals(lattitude, station.lattitude) && Objects.equals(longitude, station.longitude) && Objects.equals(stationCode, station.stationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName, lattitude, longitude, stationCode);
    }

    @Override
    public String toString() {
        return "{" +
            " stationName='" + getStationName() + "'" +
            ", lattitude='" + getLattitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", stationCode='" + getStationCode() + "'" +
            "}";
    }
   
}