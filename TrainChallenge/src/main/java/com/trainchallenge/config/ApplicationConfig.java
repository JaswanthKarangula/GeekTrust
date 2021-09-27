package com.trainchallenge.config;

import com.trainchallenge.command.CommandInvoker;
import com.trainchallenge.command.ICommand;
import com.trainchallenge.repositories.IPathRepository;
import com.trainchallenge.repositories.IStationRepository;
import com.trainchallenge.repositories.ITrainRepository;
import com.trainchallenge.repositories.data.IData;
import com.trainchallenge.services.IBogieService;
import com.trainchallenge.services.IStationService;
import com.trainchallenge.services.ITrainPathService;
import com.trainchallenge.services.ITrainService;

public class ApplicationConfig {
    IPathRepository iPathRepository;
    ITrainRepository iTrainRepository;
    IStationRepository iStationRepository;
    

    IBogieService IBogieService;
    IStationService iStationService;
    ITrainPathService iTrainPathService;
    ITrainService iTrainService;

    ICommand trainACommand;
    ICommand trainBCommand;
    ICommand moveTrainsTillIntersectionCommand;
    ICommand displayTrainCommand;

    CommandInvoker commandInvoker;

    
    
}