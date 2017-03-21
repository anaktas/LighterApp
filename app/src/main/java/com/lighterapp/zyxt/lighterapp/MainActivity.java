package com.lighterapp.zyxt.lighterapp;

import  android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cam = Camera.open();
    }

    public void toggleChecked(View view) {
        boolean isOn = ((ToggleButton) view).isChecked();

        if (isOn) {
            if (cam == null) {
                cam = Camera.open();
            }
            Parameters p = cam.getParameters();
            p.setFlashMode(Parameters.FLASH_MODE_TORCH);
            cam.setParameters(p);
            cam.startPreview();
        } else {
            cam.stopPreview();
            cam.release();
            cam = null;
        }
    }
}
