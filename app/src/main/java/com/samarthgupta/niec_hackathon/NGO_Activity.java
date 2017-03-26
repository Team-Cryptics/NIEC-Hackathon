package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;
import com.samarthgupta.niec_hackathon.R;

public class NGO_Activity extends AppCompatActivity implements View.OnClickListener {

    CardView cv1,cv2,cv3,cv4,cv5;
    TextView tv1,tv2,tv3,tv4,tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_);

        cv1 = (CardView)findViewById(R.id.cv_NGO1); cv1.setOnClickListener(this);
        cv2 = (CardView)findViewById(R.id.cv_NGO2); cv2.setOnClickListener(this);
        cv3 = (CardView)findViewById(R.id.cv_NGO3); cv3.setOnClickListener(this);
        cv4 = (CardView)findViewById(R.id.cv_NGO4); cv4.setOnClickListener(this);
        cv5 = (CardView)findViewById(R.id.cv_NGO5); cv5.setOnClickListener(this);

        tv1 = (TextView)findViewById(R.id.tv_NGO1);
        tv2 = (TextView)findViewById(R.id.tv_NGO2);
        tv3 = (TextView)findViewById(R.id.tv_NGO3);
        tv4 = (TextView)findViewById(R.id.tv_NGO4);
        tv5 = (TextView)findViewById(R.id.tv_NGO5);



    }

    @Override
    public void onClick(View v) {

        GlobalVariables.productOfferPrice = "0";
        GlobalVariables.productDescription= "Donation";
        GlobalVariables.productReasonSale= " ";

        Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
        startActivity(intent);
        finish();




    }
}
