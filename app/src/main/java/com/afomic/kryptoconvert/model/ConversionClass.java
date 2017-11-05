package com.afomic.kryptoconvert.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rechael on 10/25/2017.
 */

public class ConversionClass implements Parcelable {
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

    protected ConversionClass(Parcel in) {
        currencyStringTo = in.readString();
        cryptoStringFrom = in.readString();
        value = in.readDouble();
    }

    public static final Creator<ConversionClass> CREATOR = new Creator<ConversionClass>() {
        @Override
        public ConversionClass createFromParcel(Parcel in) {
            return new ConversionClass(in);
        }

        @Override
        public ConversionClass[] newArray(int size) {
            return new ConversionClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currencyStringTo);
        dest.writeString(cryptoStringFrom);
        dest.writeDouble(value);
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

