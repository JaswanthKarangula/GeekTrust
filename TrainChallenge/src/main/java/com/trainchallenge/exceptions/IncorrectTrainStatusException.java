package com.trainchallenge.exceptions;

public class IncorrectTrainStatusException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Incorrect train Status";
    }
}