package com.trainchallenge.exceptions;


public class NoSuchCommandException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "No such Command Found!";
    }
}
