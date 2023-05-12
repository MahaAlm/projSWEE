package com.example.projswee;

public class toolModel {

    private int id;
    private int rate;
    private int rateNum;
    private String name;
    private String model;
    private String overview;
    private String usage;
    private String prodYear;

    public toolModel(int id, int rate, String name, String model, String overview, String usage, String prodYear,int rateNum) {
        this.id = id;
        this.rate = rate;
        this.name = name;
        this.model = model;
        this.overview = overview;
        this.usage = usage;
        this.prodYear = prodYear;
        this.rateNum = rateNum;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate/rateNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getProdYear() {
        return prodYear;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    public int getRateNum() {
        return rateNum;
    }

    public void setRateNum(int rateNum) {
        this.rateNum = rateNum;
    }

    @Override
    public String toString() {
        return  "id:    " + id +
                "\nrate:    " + rate +"("+""+")"+
                "\nname:    " + name +
                "\nmodel:   " + model +
                "\n \noverview:    " + overview +
                "\nusage:   " + usage +
                "\nprodYear:    " + prodYear;
    }
    public String abstracttoString() {
        return  "\nrate:    " + rate +
                "\nname:    " + name +
                "\nmodel:   " + model;
    }
}

