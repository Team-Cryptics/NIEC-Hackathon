package com.samarthgupta.niec_hackathon;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;

/**
 * Created by samarthgupta on 22/03/17.
 */

public class FinalActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,prop1,prop2;
    ImageView product_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        tv1=(TextView)findViewById(R.id.tv_ProductName);
        tv2=(TextView)findViewById(R.id.tv_Price_MRP);
        tv3=(TextView)findViewById(R.id.tv_Price_Offer);
        prop1= (TextView) findViewById(R.id.product_property1);
        prop2= (TextView) findViewById(R.id.product_property2);
        product_Image= (ImageView) findViewById(R.id.product_image);

        tv1.setText(GlobalVariables.productName);
        tv2.setText(GlobalVariables.productMRP);
        tv3.setText(GlobalVariables.productOfferPrice);
        product_Image.setImageBitmap(GlobalVariables.m_Image);
        prop1.setText(GlobalVariables.productDescription);
        prop2.setText(GlobalVariables.productReasonSale);


    }


}
