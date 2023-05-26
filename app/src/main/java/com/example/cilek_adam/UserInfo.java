package com.example.cilek_adam;

public class UserInfo {
    public static String name,sex;
    public static int years,weight,height, calorie_taken = 0, calorie_burn = 0;

    UserInfo(String n, String s, int y,int w, int h){
        name = n;
        sex = s;
        years = y;
        weight = w;
        height = h;
    }
    UserInfo(){}
    public String getName(){
        return name;
    }
    public String getSex(){
        return sex;
    }
    public int getYears(){
        return years;
    }
    public String getYearsString(){
        return String.valueOf(years);
    }
    public int getWeight(){
        return weight;
    }
    public String getWeightString(){
        return String.valueOf(weight);
    }
    public int getHeight(){
        return height;
    }
    public String getHeightString(){
        return String.valueOf(height);
    }

    public void addCalorieTaken(int cal) {
        calorie_taken += cal;
    }

    public void addCalorieBurn(int cal) {
        calorie_burn += cal;
    }

    public int getCalorie_taken(){
        return calorie_taken;
    }

    public int getCalorie_burn(){
        return calorie_burn;
    }

}
