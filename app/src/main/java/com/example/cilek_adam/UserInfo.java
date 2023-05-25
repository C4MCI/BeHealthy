package com.example.cilek_adam;

public class UserInfo {
    String name,sex;
    int years,weight,height;

    UserInfo(String n, String s, int y,int w, int h){
        name = n;
        sex = s;
        years = y;
        weight = w;
        height = h;
    }
    public String getName(){
        return name;
    }
    public String getSex(){
        return sex;
    }
    public int getYears(){
        return years;
    }
    public int getWeight(){
        return weight;
    }
    public int getHeight(){
        return height;
    }
}
