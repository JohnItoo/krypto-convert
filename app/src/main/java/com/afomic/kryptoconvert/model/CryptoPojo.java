package com.afomic.kryptoconvert.model;

/**
 * Created by rechael on 10/21/2017.
 */import com.google.gson.annotations.SerializedName;

public class CryptoPojo {

    @SerializedName("ETH")
    private double eretheum;
    @SerializedName("BTC")
    private double bitcoin;
    @SerializedName("USD")
    private double usDollars;
    @SerializedName("GBP")
    private double pounds;
    @SerializedName("EUR")
    private double euros;
    @SerializedName("NGR")
    private double naira;
    @SerializedName("JPY")
    private double japanYen;
    @SerializedName("CAD")
    private double canadaDolls;
    @SerializedName("AUD")
    private double austrlDolls;
    @SerializedName("HKD")
    private double hkd;
    @SerializedName("CHF")
    private double chf;
    @SerializedName("BHD")
    private double bhd;
    @SerializedName("KYD")
    private double kyd;
    @SerializedName("GIP")
    private double gip;
    @SerializedName("JOD")
    private double jod;
    @SerializedName("OMR")
    private double omr;
    @SerializedName("KWD")
    private double kwd;


    public CryptoPojo(double eretheum, double bitcoin, double usDollars, double pounds, double euros, double naira) {
        this.eretheum = eretheum;
        this.bitcoin = bitcoin;
        this.usDollars = usDollars;
        this.pounds = pounds;
        this.euros = euros;
        this.naira = naira;
    }

    public double getJapanYen() {
        return japanYen;
    }

    public void setJapanYen(double japanYen) {
        this.japanYen = japanYen;
    }

    public double getCanadaDolls() {
        return canadaDolls;
    }

    public void setCanadaDolls(double canadaDolls) {
        this.canadaDolls = canadaDolls;
    }

    public double getAustrlDolls() {
        return austrlDolls;
    }

    public void setAustrlDolls(double austrlDolls) {
        this.austrlDolls = austrlDolls;
    }

    public double getHkd() {
        return hkd;
    }

    public void setHkd(double hkd) {
        this.hkd = hkd;
    }

    public double getChf() {
        return chf;
    }

    public void setChf(double chf) {
        this.chf = chf;
    }

    public double getBhd() {
        return bhd;
    }

    public void setBhd(double bhd) {
        this.bhd = bhd;
    }

    public double getKyd() {
        return kyd;
    }

    public void setKyd(double kyd) {
        this.kyd = kyd;
    }

    public double getGip() {
        return gip;
    }

    public void setGip(double gip) {
        this.gip = gip;
    }

    public double getJod() {
        return jod;
    }

    public void setJod(double jod) {
        this.jod = jod;
    }

    public double getOmr() {
        return omr;
    }

    public void setOmr(double omr) {
        this.omr = omr;
    }

    public double getKwd() {
        return kwd;
    }

    public void setKwd(double kwd) {
        this.kwd = kwd;
    }


    public double getBitcoin() {
        return bitcoin;
    }

    public double getEretheum() {
        return eretheum;
    }

    public void setEretheum(double eretheum) {
        this.eretheum = eretheum;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;

    }

    public double getEuros() {
        return euros;
    }

    public void setEuros(double euros) {
        this.euros = euros;
    }

    public double getNaira() {
        return naira;
    }

    public void setNaira(double naira) {
        this.naira = naira;
    }

    public double getPounds() {
        return pounds;
    }

    public void setPounds(double pounds) {
        this.pounds = pounds;
    }

    public double getUsDollars() {
        return usDollars;
    }

    public void setUsDollars(double usDollars) {
        this.usDollars = usDollars;
    }


}
