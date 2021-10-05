package com.trainchallenge.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TrainPath {

    private Station curreStation;
    private  List<Station> path;
    private Map<String,Station> pathMap;
    private Map<String,Double> distanceMap;
    
    

    public TrainPath(List<Station> path) {
        this.path=path;
        curreStation=path.get(0);
        createDistanceMap(path);
        addPathToMap(path);
        // for(Station station:path){
        //     System.out.println(station.getStationCode()+"------------"+station.getStationDistanc());
        // }
    }
    
    public TrainPath(Station curreStation, List<Station> path, Map<String,Station> pathMap) {
        this.curreStation = curreStation;
        this.path = path;
        this.pathMap = pathMap;
        addPathToMap(path);
    }

    private void createDistanceMap(List<Station> path){
        distanceMap= new HashMap<>();
        for(Station station:path){
            distanceMap.put(station.getStationCode(), station.getStationDistanc());
        }
         
    }
    void addPathToMap(List<Station> path){
        pathMap= new HashMap<>();
        for(Station station:path){
            pathMap.put(station.getStationCode(), station);
        }
    }

    public Double getDistance(String stationCode){
        
        return distanceMap.get(stationCode);
    }


    public Station getCurreStation() {
        return this.curreStation;
    }

    public void setCurreStation(Station curreStation) {
        this.curreStation = curreStation;
    }

    public List<Station> getPath() {
        return this.path;
    }

    public void setPath(List<Station> path){
        this.path=path;
        addPathToMap(path);
    }


    public Map<String,Station> getPathMap() {
        return this.pathMap;
    }

    public void setPathMap(Map<String,Station> pathMap) {
        this.pathMap = pathMap;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TrainPath)) {
            return false;
        }
        TrainPath trainPath = (TrainPath) o;
        return Objects.equals(curreStation, trainPath.curreStation) && Objects.equals(path, trainPath.path) && Objects.equals(pathMap, trainPath.pathMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curreStation, path, pathMap);
    }

    @Override
    public String toString() {
        return "{" +
            " curreStation='" + getCurreStation() + "'" +
            ", path='" + getPath() + "'" +
            ", pathMap='" + getPathMap() + "'" +
            "}";
    }
     


}