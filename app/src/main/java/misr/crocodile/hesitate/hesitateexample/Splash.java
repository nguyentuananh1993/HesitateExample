package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by misrc_000 on 1/11/15.
 */
public class Splash extends Activity {
    private MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSong = MediaPlayer.create(Splash.this,R.raw.splash_sound);
        setContentView(R.layout.splash);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean check = prefs.getBoolean("checkbox",false);
        if(check){
            ourSong.start();
        }
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openMainAct  = new Intent("main.MENU");
                    startActivity(openMainAct);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.stop();
        finish();
    }
}
