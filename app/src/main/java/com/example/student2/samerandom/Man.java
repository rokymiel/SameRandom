package com.example.student2.samerandom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by student2 on 22.12.17.
 */

public class Man implements SensorEventListener{
float x,y,r=5,vx=-5,vy=-5;
    Paint paint= new Paint();
    Bitmap sprites;

    int nFrame=0;
    float turn=0;
    private  float prevX;
    float dx=15;
    int spriteY=100;

    public  void  draw (Canvas canvas){
        if (vx>0){
            spriteY=100;
        }
        else if (vx<0){spriteY=300;}
        Rect to = new Rect((int) x-50,(int) y-50,(int) x+50,(int) y+50);
        Rect frame =new Rect (nFrame*100,spriteY,nFrame*100+100,spriteY+100);
        if (Math.abs(x-prevX)> dx){
        nFrame++;
        nFrame %=6;
        prevX=x;}


        //paint.setColor(Color.BLACK);
        //canvas.drawCircle(x,y,r,paint);
        canvas.drawBitmap(sprites,frame,to,paint);
    }

    public Man (float x, float y,Bitmap sprites){
        this.x=x;
        this.y=y;
        this.sprites=sprites;
        this.prevX=x;

    }
    boolean connected;
    void move(){
        if (!connected) {
            MainActivity.sm.registerListener(this, MainActivity.accel, SensorManager.SENSOR_DELAY_NORMAL);
            connected=true;
        }
        if (x==10|| x==1000){
        this.vx=-this.vx;
            turn++;
            turn%=2;

        }

        this.x += this.vx;

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        final float threshold=2;
        if (sensorEvent.values[0]>threshold){
            vx=-5;

        }
        else if (sensorEvent.values[0]<-threshold){
            vx=5;
        }
        else vx=0;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
