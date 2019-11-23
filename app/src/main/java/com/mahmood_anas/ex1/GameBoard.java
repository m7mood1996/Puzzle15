package com.mahmood_anas.ex1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class GameBoard {
    TextView array[];
    Context context;
    TextView moves;
    TextView timer;
    public GameBoard(TextView[] ides, GameActivity gameActivity,TextView moves,TextView timer) {
        this.array = ides;
        this.context = gameActivity;
        this.moves = moves;
        this.timer=timer;
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
   public void swap(TextView tv){
        if(tv.getText().toString().isEmpty()== true)
            return;


        int pos =0;
        int emptyPos = 0;
        for(int i=0;i<16;i++){
            if(tv.getId() == this.array[i].getId())
                pos = i;
            if(this.array[i].getText().toString().isEmpty())
                emptyPos=i;
        }
       Log.d("pos\tEmptyPos",pos + "\t" + emptyPos);


        if(pos < 4){
            if(pos%4 == 0 &&(pos == emptyPos-1 || pos == emptyPos-4)) { // swap
                swap_ele(this.array[pos], this.array[emptyPos]);
                Log.d("pos\tEmptyPos",pos + "\t" + emptyPos);
            }

            else if(pos%4 ==3 &&(pos == emptyPos+1 || pos == emptyPos-4)) {//swap
                swap_ele(this.array[pos], this.array[emptyPos]);
                Log.d("pos\tEmptyPos",pos + "\t" + emptyPos);
            }

            else if ((pos%4 == 2 || pos%4==1 ) &&(pos == emptyPos + 1 || pos == emptyPos - 1 || pos == emptyPos - 4)) {//swap
                    swap_ele(this.array[pos], this.array[emptyPos]);
                    Log.d("pos\tEmptyPos", pos + "\t" + emptyPos);
                }
        }
        else if(pos > 11){
            if(pos%4 == 0 && (pos == emptyPos -1 || pos == emptyPos +4)) {
                swap_ele(this.array[pos], this.array[emptyPos]);
                Log.d("pos\tEmptyPos", pos + "\t" + emptyPos);
            }
            else if(pos%4 == 3 && (pos == emptyPos+1 || pos == emptyPos+4)) {
                swap_ele(this.array[pos], this.array[emptyPos]);
                System.out.println("I'm hereee! ");
                Log.d("pos\tEmptyPos", pos + "\t" + emptyPos);
            }
            else if((pos%4 == 2 || pos%4==1 ) &&(pos == emptyPos+1 || pos == emptyPos- 1 || pos == emptyPos+4)) { //swap
                swap_ele(this.array[pos], this.array[emptyPos]);
                System.out.println("I'm hereee hhhhhh ");
                Log.d("pos\tEmptyPos", pos + "\t" + emptyPos);
            }
        }

        else{
            if(pos%4 == 0 &&(pos == emptyPos-1 || pos == emptyPos+4 || pos == emptyPos-4 )){
                swap_ele(this.array[pos],this.array[emptyPos]);
                System.out.println("Ana d5alt hon ! ");
                Log.d("pos\tEmptyPos",pos + "\t" + emptyPos);
            }
            else if(pos%4 == 3 &&(pos == emptyPos+1 || pos == emptyPos+4 || pos == emptyPos-4 )){
                swap_ele(this.array[pos],this.array[emptyPos]);
                System.out.println("Ya kbeer! ");
                Log.d("pos\tEmptyPos",pos + "\t" + emptyPos);
            }
            else if((pos%4 == 2 || pos%4==1 ) &&(pos == emptyPos-1 || pos == emptyPos+1 || pos == emptyPos+4 || pos == emptyPos-4 )){
                swap_ele(this.array[pos],this.array[emptyPos]);
                System.out.println("zeft! ");
                Log.d("pos\tEmptyPos",pos + "\t" + emptyPos);
            }


        }

   }

   public void swap_ele(TextView first,TextView sec){

       String ss = first.getText().toString();
       Drawable d =first.getBackground();


       first.setText( sec.getText().toString());
       first.setBackground(sec.getBackground());

       sec.setText(ss);
       sec.setBackground(d);

       int mo = Integer.parseInt(this.moves.getText().toString());
       mo++;
       String num =String.format("%04d", mo);
       Log.d("num_moves", num);
       this.moves.setText(num);
   }
    public boolean isSolved(){
        int parity =0;
        int gridWidth = (int) Math.sqrt(this.array.length);
        int row =0;
        int blankrow = 0;
        int i =0;
        while (i < 16){
            String for_i =this.array[i].getText().toString();
            int for_i_int;
            if(for_i.isEmpty() == true)
                for_i_int = 0;
            else
                for_i_int = Integer.parseInt(for_i);
            if (i % gridWidth == 0){
                row++;
            }
            if (for_i_int == 0){
                blankrow = row;
                break;
            }
            for (int j = i + 1;j < this.array.length;j++){


                    int for_j_int;
                    String for_j =this.array[j].getText().toString();
                    if(for_j.isEmpty() == true)
                        for_j_int = 0;
                    else
                        for_j_int = Integer.parseInt(for_i);



                if (for_i_int > for_j_int && for_i_int != 0){

                    parity++;
                }
            }
            i++;
        }
        if(gridWidth%2 == 0){
            if(blankrow%2 == 0){
                return parity%2 == 0;
            }
            else{
                return parity%2 != 0;
            }
        }
        else{
            return parity %2 ==0;
        }

    }
    public String updateTime(){
        String Time = timer.getText().toString();
        String minute = Time.substring(0,2);
        String seconde = Time.substring(3);
        int min_int = Integer.parseInt(minute);
        int sec_int = Integer.parseInt(seconde);
        sec_int++;
        try {
            sleep(1000);


            if (sec_int == 60) {
                min_int++;
                sec_int = 0;
            }

            Log.d("min =",minute);
            Log.d("sec =",seconde);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return String.format("%02d", min_int) + ":" + String.format("%02d", sec_int);
    }
}
