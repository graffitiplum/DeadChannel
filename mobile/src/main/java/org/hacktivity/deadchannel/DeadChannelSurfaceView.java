package org.hacktivity.deadchannel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.security.SecureRandom;

public class DeadChannelSurfaceView extends SurfaceView {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private SurfaceHolder sh;
    SecureRandom sr;

    public DeadChannelSurfaceView(Context context) {
        super(context);
        sr = new SecureRandom();

        sh = getHolder();

        sh.addCallback(new SurfaceHolder.Callback() {



            @Override

            public void surfaceDestroyed(SurfaceHolder holder) {

            }



            @Override

            public void surfaceCreated(SurfaceHolder holder) {

                final SurfaceHolder sh = holder;

                final Canvas c = holder.lockCanvas(null);
                //c.drawColor(Color.BLACK);
                draw(c);

                holder.unlockCanvasAndPost(c);

                /*
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Canvas c = sh.lockCanvas(null);
                        onDraw(c);
                        sh.unlockCanvasAndPost(c);
                    }
                }, 1000);
                */

                final Handler handler = new Handler();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {

                        {

                            Canvas c = sh.lockCanvas(null);
                            draw(c);
                            sh.unlockCanvasAndPost(c);

                        }
                        handler.postDelayed(this, 10);
                    }
                };
                handler.removeCallbacks(task);
                handler.post(task);

            }



            @Override

            public void surfaceChanged(SurfaceHolder holder, int format,

                                       int width, int height) {

            }

        });

    }

    @Override
    public void draw(Canvas canvas) {

        //canvas.drawColor(Color.BLACK);

        //canvas = sh.lockCanvas();


        //canvas.drawColor(Color.BLACK);
        paint.setColor(Color.WHITE);
        //paint.setStyle(Paint.Style.FILL);
        //canvas.drawCircle(sr.nextFloat() * canvas.getWidth(), sr.nextFloat() * canvas.getHeight(), 61.8f, paint);


        canvas.drawPoint(sr.nextFloat() * canvas.getWidth(), sr.nextFloat() * canvas.getHeight(), paint);
        //sh.unlockCanvasAndPost(canvas);

    }
}
