package com.example.student2.samerandom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by student2 on 22.12.17.
 */

public class MyDraw extends View {
    Bitmap pic;
    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        pic= BitmapFactory.decodeResource(getResources(),R.drawable.spritesheet);
        man= new Man(10,200,pic);

    }
    Man man;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        man.draw(canvas);
        man.move();
        invalidate();
    }
}
