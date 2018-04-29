package com.example.terry.q_code;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity activity = this;


        show_scanner(activity);
    }

    void show_scanner(Activity activity)
    {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("QR Code");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {



        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {

                //Toast.makeText(this, result.getContents().toString(),Toast.LENGTH_LONG).show();

                if(result.getContents().toString().equalsIgnoreCase("a")){
                    Toast.makeText(this, "find A!!!",Toast.LENGTH_LONG).show();
                    show_scanner(this);
                }
                else if(result.getContents().toString().equalsIgnoreCase("vedio")) {
                    Toast.makeText(this, "find others!!!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,vedioActivity.class));

                }

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}
