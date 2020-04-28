package com.TzGin.dependencyinversion.v2;

import com.TzGin.dependencyinversion.ICourse;

public class Student {

   public void study(ICourse iCourse){
       iCourse.study();
   }

}
