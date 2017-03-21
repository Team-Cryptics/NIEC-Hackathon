package com.samarthgupta.niec_hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class CostEval extends AppCompatActivity {

    Spinner spin1,spin2,spin3;
    float warr; int age; int cond; float perc;
    Button btProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_eval);

        spin1 = (Spinner)findViewById(R.id.spinner);
        spin2 = (Spinner)findViewById(R.id.spinner1);
        spin3 = (Spinner)findViewById(R.id.spinner2);
        btProceed = (Button)findViewById(R.id.bt_proceed);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i) {
                    case 0 : warr = 4; break;
                    case 1 : warr = 20; break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i) {
                    case 0 : age = 1; break;
                    case 1 : age = 2; break;
                    case 2 : age = 3; break;
                    case 3 : age = 5; break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i) {
                    case 0 : cond =1  ; break;
                    case 1 : cond =3  ; break;
                    case 2 : cond =16  ; break;
                    case 3 : cond =20 ; break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                perc = cond + warr + (6*age);
                Log.i("TAG",Float.toString(perc));

            }
        });







    }
}
