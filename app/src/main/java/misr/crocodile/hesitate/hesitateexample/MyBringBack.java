package misr.crocodile.hesitate.hesitateexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by misrc_000 on 1/29/15.
 */
public class MyBringBack extends View {
    private static int BALL_SIZE = 150;
    private static int FONT_SIZE = 150;
    Bitmap gBall;
    int changeY;
    int changeX;
    int dX = 1;
    int dY = 1;
    Typeface font;

    public MyBringBack(Context context) {
        super(context);
        changeY = 0;
        Bitmap gBallTemp;
        gBallTemp = BitmapFactory.decodeResource(getResources(), R.drawable.blue_icon);
        gBall = Bitmap.createScaledBitmap(gBallTemp, BALL_SIZE, BALL_SIZE, false);
        font = Typeface.createFromAsset(context.getAssets(),"segoeuil.ttf");
        changeX = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        Paint textPaint = new Paint();
        textPaint.setARGB(50,254,10,50);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(FONT_SIZE);
        canvas.drawText("My Bring Back",canvas.getWidth()/2,200, textPaint);
        canvas.drawBitmap(gBall, changeX,changeY,null);
        if (changeY == 0)
            dY = 5;
        if (changeY == canvas.getHeight()-gBall.getHeight())
            dY = -5;
        if (changeX == 0)
            dX = 5;
        if (changeX == canvas.getWidth()-gBall.getHeight())
            dX = -5;
        changeX += dX;
        changeY += dY;
        Rect middleRect = new Rect();
        middleRect.set(0, 400, canvas.getWidth(), 550);
        Paint ourBlue = new Paint();
        ourBlue.setColor(Color.BLUE);
        canvas.drawRect(middleRect, ourBlue);
        invalidate();
    }
}
