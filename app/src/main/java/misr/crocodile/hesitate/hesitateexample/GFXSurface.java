package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by misrc_000 on 1/29/15.
 */
public class GFXSurface extends Activity implements View.OnTouchListener {
    private static int CIRCLE_SIZE = 100;
    MyBringBackSurface ourSurfaceView;
    float x, y, sX, sY, fX, fY;
    Bitmap blueIcon;
    Bitmap twitterIcon;
    @Override
    protected void onResume() {
        super.onResume();
        ourSurfaceView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSurfaceView.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView = new MyBringBackSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        x = 0;
        y = 0;
        sX = 0;
        sY = 0;
        fX = 0;
        fY = 0;
        Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.blue_icon);
        Bitmap twittertest = BitmapFactory.decodeResource(getResources(),R.drawable.twitter_icon);
        twitterIcon = Bitmap.createScaledBitmap(twittertest,CIRCLE_SIZE,CIRCLE_SIZE,false);
        blueIcon = Bitmap.createScaledBitmap(test, CIRCLE_SIZE, CIRCLE_SIZE, false);
        setContentView(ourSurfaceView);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("here my code", "here");
                sX = event.getX();
                sY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                fX = event.getX();
                fY = event.getY();
                break;
        }
        return false;
    }

    class MyBringBackSurface extends SurfaceView implements Runnable {

        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = false;

        public MyBringBackSurface(Context context) {
            super(context);
            ourHolder = getHolder();
        }

        public void pause() {
            isRunning = false;
            while (true) {
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            ourThread = null;
        }

        public void resume() {
            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        @Override
        public void run() {
            while (isRunning) {
                if (!ourHolder.getSurface().isValid())
                    continue;
                Canvas canvas = ourHolder.lockCanvas();
                canvas.drawRGB(02, 02, 150);
                if (x != 0 && y != 0)
                    canvas.drawBitmap(blueIcon, x - blueIcon.getWidth() / 2, y - blueIcon.getHeight() / 2, null);
                if (sX != 0 && sY != 0)
                    canvas.drawBitmap(twitterIcon, sX - twitterIcon.getWidth() / 2, sY - twitterIcon.getHeight() / 2, null);
                if (fX != 0 && fY != 0)
                    canvas.drawBitmap(twitterIcon, fX - twitterIcon.getWidth() / 2, fY - twitterIcon.getHeight() / 2, null);
                ourHolder.unlockCanvasAndPost(canvas);

            }
        }
    }
}

