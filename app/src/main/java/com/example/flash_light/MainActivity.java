package com.example.flash_light;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    TextView tv_result;
    CameraManager CameraManager;
    String cameraid, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch= findViewById(R.id.myswitchid);
        tv_result= findViewById(R.id.mytextviewid);



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){



         torch(isChecked);

            }




        });
    }

    private void torch(boolean isChecked) {
        try {


            CameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

            cameraid = CameraManager.getCameraIdList()[0];

            CameraManager.setTorchMode(cameraid, isChecked);

            result = isChecked ? "ON" : "OFF";

            tv_result.setText(result);

        } catch (CameraAccessException e) {

        }
    }
}
