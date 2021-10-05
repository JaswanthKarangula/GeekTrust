package com.trainchallenge.exceptions;

public class NoSuchTrainPathException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "No such Train Path Found!";
    }
    
}