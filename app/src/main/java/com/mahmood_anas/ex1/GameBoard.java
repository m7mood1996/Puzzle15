package com.mahmood_anas.ex1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
public class GameBoard {
    TextView array[];
    Context context;

    public GameBoard(TextView[] ides, GameActivity gameActivity) {
        this.array = ides;
        this.context = gameActivity;
    }

   public void shuffle(){

        for(int i = 0;i< 16 ;i++){
            int s = i + (int)(Math.random() * (16-i));

            String ss = "";

            ss = array[s].getText().toString();
            Drawable d =array[s].getBackground();


            array[s].setText( array[i].getText().toString());
            array[s].setBackground(array[i].getBackground());

            array[i].setText(ss);
            array[i].setBackground(d);
        }


   }

   public void swap(){
        this.array[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
   }

}
