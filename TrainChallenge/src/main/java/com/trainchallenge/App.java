package com.trainchallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.trainchallenge.command.CommandInvoker;
import com.trainchallenge.config.ApplicationConfig;
import com.trainchallenge.exceptions.NoSuchCommandException;
import com.trainchallenge.exceptions.NoSuchDataException;
import com.trainchallenge.repositories.data.DataLoader;

public class App {

    public static void run(List<String> commandLineArgs){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        DataLoader dataLoader = applicationConfig.getDataLoader();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        BufferedReader reader;

        String inputFile = commandLineArgs.get(0);
        
            
            try {
                dataLoader.executeData("TRAIN_A","src/main/resources/TrainAPath");
                dataLoader.executeData("TRAIN_B","src/main/resources/TrainBPath");
            } catch (NoSuchDataException exception) {
                exception.printStackTrace();
            }
        

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
                // read next line
                line = reader.readLine();
            }
            reader.close();
            List<String> trainList= new ArrayList<>();
            trainList.add("TRAIN_A");
            trainList.add("TRAIN_B");
            commandInvoker.executeCommand("MOVE-UPTO-INTERSECTION", trainList);
            commandInvoker.executeCommand("DISPLAY-TRAINS",trainList);
            commandInvoker.executeCommand("MERGE-TRAINS", trainList);
            commandInvoker.executeCommand("DISPLAY_COMBINED_TRAIN",trainList);
            
        } catch (IOException | NoSuchCommandException exception) {
            exception.printStackTrace();
        }
    }



   public static void main(String[] args) {

    List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
    run(commandLineArgs);
       

   }

}