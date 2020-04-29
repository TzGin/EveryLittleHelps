package priv.TzGin.dependencyinversion.v2;

import priv.TzGin.dependencyinversion.ICourse;

public class Student {

   public void study(ICourse iCourse){
       iCourse.study();
   }

}
