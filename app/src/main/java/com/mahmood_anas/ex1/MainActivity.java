package com.mahmood_anas.ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button StartPlay;
    Switch Music;
    SharedPreferences sp;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartPlay = findViewById(R.id.start_play);

        Music = (Switch)findViewById(R.id.music_switch);

        sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        Log.d("sp:" ,sp.toString());
        Music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                 // this when the music switch is on
                SharedPreferences.Editor editor =sp.edit();
                editor.putBoolean("Music",isChecked);
                editor.commit();

            }
        });
        context = this;



        StartPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(context,GameActivity.class);
                startActivity(start);
            }
        });



    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.about_menu:   // when about clicked in menu
                openAboutDialog();
                return true;
            case R.id.exit_menu:    // when exit clicked in menu
                openExitDialog();


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void openExitDialog() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setIcon(R.drawable.puzzle_icone);
        alertDialog.setTitle("Exit Puzzle 15");
        alertDialog.setMessage("Are you sure that you want to exit?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    private void openAboutDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setIcon(R.drawable.puzzle_icone);
        alertDialog.setTitle("About Puzzle 15");
        alertDialog.setMessage("This app implements the Game of Fifteen.\nBy Mahmood and Anas (c).");
        alertDialog.setCancelable(true);
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.ring);
        if(mediaPlayer.isPlaying() == true)
            mediaPlayer.reset();
        super.onResume();
    }
}
