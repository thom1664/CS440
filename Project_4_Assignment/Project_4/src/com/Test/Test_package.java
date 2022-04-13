package com.Test;

public class Test_package {

    private int minute;
    private int second;


    public Test_package(){
        this.minute = (int)((System.currentTimeMillis() / 1000) /60 ) % 60;
        this.second =(int)(System.currentTimeMillis() /1000) % 60;      
    }

    public void getTime(){
        System.out.println("minute(s): " +this.minute + " second(s):"+ this.second);
    }
}