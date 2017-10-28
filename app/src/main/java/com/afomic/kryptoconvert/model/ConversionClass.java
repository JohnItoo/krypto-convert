package com.afomic.kryptoconvert.model;

/**
 * Created by rechael on 10/25/2017.
 */

public class ConversionClass {
    //initialise variables
    private String currencyStringTo;
    private String  cryptoStringFrom;
    private double value;


    //create constructor that takes in parameters for model Converter class
    public ConversionClass(String currencyStringTo, String cryptoStringFrom, double value){
        this.currencyStringTo = currencyStringTo;
        this.cryptoStringFrom = cryptoStringFrom;
        this.value = value;
    }
    //getters and setters

    public String getFrom() {
        return   cryptoStringFrom;
    }
    public void setFrom (String from){
        this.  cryptoStringFrom = from;
    }

    public String getTo() {
        return currencyStringTo;
    }

    public void setTo(String to) {
        this.currencyStringTo = to;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

