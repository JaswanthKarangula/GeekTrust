package com.trainchallenge.exceptions;

public class NoSuchTrainFoundException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "No such Train Found!";
    }
}