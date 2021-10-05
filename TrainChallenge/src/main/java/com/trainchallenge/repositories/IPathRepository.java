package com.trainchallenge.repositories;

import java.util.List;

import com.trainchallenge.entities.Station;
import com.trainchallenge.entities.TrainPath;

public interface IPathRepository {
    TrainPath addTrainPath(String trainName, List<Station> path);
    TrainPath getTrainPath(String trainName);
}