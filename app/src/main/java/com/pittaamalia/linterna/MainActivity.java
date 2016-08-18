package com.pittaamalia.linterna;


import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Camera camera;
    Button encenderButton;
   // Parameters parameters;
    Boolean apagado = true;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encenderButton = (Button) findViewById(R.id.btn_linterna);
        camera = Camera.open();

        encenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Parameters parameters = camera.getParameters();

                if(apagado){
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    apagado=false;
                }else{
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    apagado = true;
                }
                camera.setParameters(parameters);
                //camera.startPreview();



            }
        });


    }
}
