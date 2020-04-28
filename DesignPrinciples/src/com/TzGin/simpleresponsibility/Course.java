package com.TzGin.simpleresponsibility;

public class Course {

    public void study(String courseName){
        //一个方法中包含多种职责
        if ("网课".equals(courseName)){
            System.out.println("不能快进");
        }else {
            System.out.println("可以来回播放");
        }
    }
}
