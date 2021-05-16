package com.demo.springboot.hibernatejpademo;

import java.util.EnumSet;

public class SwitchTest {

    public static void main(String args[]) throws Exception {
        //String formatted = String.format("%03d", num);
        System.out.println(String.format("%03d", 1));
        System.out.println(String.format("%03d", 11));
        int a =1;
        for (int i=0; i<10; i++){

            switch(i){
                case 0 : continue;
                case 1 : continue;
                case 2 : System.out.println("aaaa2="+i);break;
                case 3 : System.out.println("aaaa3="+i);break;
            }

            switch(PositionCheckTyp.from(2)){
                case SKIP_RECORD: continue;
                case SET_DEFAULT_VALUE: continue;
                default : System.out.println("aaaa2="+i);break;
            }
        }
    }
}



