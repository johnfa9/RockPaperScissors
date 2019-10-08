package com.company;
import java.util.Random;
public class Computer {

    //private String gesture;
    private Random rand=new Random();

    public String getGesture() {
      String gesture="";
      int rand_int=rand.nextInt(3);
        //System.out.println("Random Number Generated " + rand_int);
        if (rand_int==0) {
            gesture = "PAPER";
        }
        else if (rand_int==1) {
            gesture = "ROCK";
        }
        else if (rand_int==2) {
            gesture="SCISSORS";

        }
        //System.out.println("gesture= " + gesture);
      return gesture;
    }

}
