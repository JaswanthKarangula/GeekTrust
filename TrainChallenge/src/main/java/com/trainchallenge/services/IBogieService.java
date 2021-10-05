package com.trainchallenge.services;


import java.util.List;

import com.trainchallenge.entities.Bogie;
import com.trainchallenge.entities.TrainPath;
import com.trainchallenge.exceptions.NoSuchTrainPathException;

public interface IBogieService {
    List<Bogie> combineBogies(List<Bogie> bogies1, List<Bogie> bogies2);
    List<List<Bogie>> splitBogies(List<Bogie> bogies, TrainPath firstTrainPath,TrainPath secondTrainPath) throws NoSuchTrainPathException;
}