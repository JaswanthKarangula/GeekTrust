package com.trainchallenge.repositories;

import com.trainchallenge.entities.Station;


public interface IStationRepository {
    Station getStationByCode(String stationCode);
    Station getStationById(Integer id);
    Station saveStation(String stationName,String stationCode);
}