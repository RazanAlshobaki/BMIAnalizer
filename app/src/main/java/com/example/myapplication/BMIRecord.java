package com.example.myapplication;

public class BMIRecord {
    private static class Constants{
        final static String Underweight= "Underweight";
        final static String Healthy= "Healthy";
        final static String Overweight= "Overweight";
        final static String Obesity= "Obesity";
        final static String LC= "Little Cjanges";
        final static String SG= "Still Good";
        final static String GA= "Go Ahead";
        final static String BC= "Be Careful";
        final static String SB= "So Bad";
    }
    private String date;
    private double weight;
    private int length;
    private String id;
    private String status;

    public BMIRecord(String date, double weight, int length, String status){
        this.date= date;
        this.weight= weight;
        this.length= length;
        this.status=status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

   // public String getId() {
        //return id;
   // }
    //public double getAgePercent(){
      //  return v;
    //}
    //public void setAgePercent(double v){}

    //public void setId(String id) {
      //  this.id = id;
    //}
    //public double getBmi(){
      //  return (weight/Math.pow((length/100.0),2))*this.getAgePercent();
    //}

    //public void setBmi(double v){

    //}
    //public String getBmiMessage(){
      //  double bmi= this.getBmi();
        //if(bmi<18.5){
          //  return Constants.Underweight;
        //}else if(18.5<=bmi && bmi<25){
          //  return Constants.Healthy;
        //}else if(25<=bmi && bmi<30){
          //  return Constants.Overweight;
        //}else if(bmi>30)
          //  return Obesity;
    }

