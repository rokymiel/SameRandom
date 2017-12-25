package com.example.student2.samerandom;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public static Sensor accel;
    public  static SensorManager sm;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDraw myDraw=(MyDraw)findViewById(R.id.myDraw1);
        sm =(SensorManager) getSystemService(SENSOR_SERVICE);
        accel=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        textView=(TextView) findViewById(R.id.textView);
        sm.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText("v1:"+sensorEvent.values[0]+"\nv2:"+sensorEvent.values[1]+
                             "\nv3:"+sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
