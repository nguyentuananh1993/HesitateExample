package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

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
        ourSong.start();
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openMainActivitiy  = new Intent("main.STARTINGPOINT");
                    startActivity(openMainActivitiy);
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
