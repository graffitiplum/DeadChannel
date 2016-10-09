package org.hacktivity.deadchannel;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    DeadChannelSurfaceView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mView = new DeadChannelSurfaceView(this);

        setContentView(new DeadChannelSurfaceView(this));


        /*
        final Handler handler = new Handler();
        Runnable task = new Runnable() {
            @Override
            public void run() {

                {

                    mView.postInvalidate();

                }
                handler.postDelayed(this, 210);
            }
        };
        handler.removeCallbacks(task);
        handler.post(task);
        */

        /*
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mView.postInvalidate();
            }
        }, 1000);
        */

    }

}
