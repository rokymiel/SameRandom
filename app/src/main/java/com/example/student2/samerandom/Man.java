package com.example.student2.samerandom;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by student2 on 22.12.17.
 */

public class Man {
float x,y,r=5,vx=-5,vy=-5;
    Paint paint= new Paint();
    Bitmap sprites;

    int nFrame=0;

    public  void  draw (Canvas canvas){
        Rect to = new Rect((int) x-50,(int) y-50,(int) x+50,(int) y+50);
        Rect frame =new Rect (nFrame*100,100,nFrame*100+100,200);
        nFrame++;
        nFrame %=6;


        //paint.setColor(Color.BLACK);
        //canvas.drawCircle(x,y,r,paint);
        canvas.drawBitmap(sprites,frame,to,paint);
    }
    public Man (float x, float y,Bitmap sprites){
        this.x=x;
        this.y=y;
        this.sprites=sprites;
    }
    void move(){
        if (x==10|| x==1000){
        this.vx=-this.vx;
        }

        this.x += this.vx;

    }
}
