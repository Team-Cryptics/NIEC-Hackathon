package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;

public class SelectDeviceType extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device_type);

        //START ACT SELECT DEVICE AND SEND TYPE OF DEVICE SELECTED. PS - COMPARE WITH STRINGS IN THE NEXT ACT

        tv1= (TextView) findViewById(R.id.mob);
        tv2= (TextView) findViewById(R.id.tv);
        tv3= (TextView) findViewById(R.id.tab);
        tv4= (TextView) findViewById(R.id.lap);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.deviceType = "Mobiles";
                startActivity(new Intent(SelectDeviceType.this,SelectDevice.class));
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.deviceType = "TV";
                startActivity(new Intent(SelectDeviceType.this,SelectDevice.class));
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.deviceType = "Tablets";
                startActivity(new Intent(SelectDeviceType.this,SelectDevice.class));
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.deviceType = "Laptops";
                startActivity(new Intent(SelectDeviceType.this,SelectDevice.class));
            }
        });




    }
}
