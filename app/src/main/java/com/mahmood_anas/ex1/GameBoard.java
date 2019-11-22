package com.mahmood_anas.ex1;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
public class GameBoard {
    int array[];

    private void setArray(){
        array = new int[16];
        array[0] = R.id.m1x1;
        array[1] = R.id.m1x2;
        array[2] = R.id.m1x3;
        array[3] = R.id.m1x4;
        array[4] = R.id.m2x1;
        array[5] = R.id.m2x2;
        array[6] = R.id.m2x3;
        array[7] = R.id.m2x4;
        array[8] = R.id.m3x1;
        array[9] = R.id.m3x2;
        array[10] = R.id.m3x3;
        array[11] = R.id.m3x4;
        array[12] = R.id.m4x1;
        array[13] = R.id.m4x2;
        array[14] = R.id.m4x3;
        array[15] = R.id.m4x3;

    }
    public void changeArray(){
        setArray();
        System.out.println("Walaaaaaa");
        for(int i=0;i < array.length;i++){
            System.out.print("Anas !!  " + array[i]);
        }
    }
}
