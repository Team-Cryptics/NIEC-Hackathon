package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;
import com.samarthgupta.niec_hackathon.POJO.UserAd;

/**
 * Created by samarthgupta on 22/03/17.
 */

public class FinalActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
    DatabaseReference ref;
    FirebaseUser user;

    TextView tv1,tv2,tv3,prop1,prop2;
    ImageView product_Image;
    Button proceed_btn;

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
        proceed_btn= (Button) findViewById(R.id.proceed_button);

        ref = firebaseDatabase.getReference();

        tv1.setText(GlobalVariables.productName);
        tv2.setText(GlobalVariables.productMRP);
        tv3.setText(GlobalVariables.productOfferPrice);
        product_Image.setImageBitmap(GlobalVariables.m_Image);
        prop1.setText(GlobalVariables.productDescription);
        prop2.setText(GlobalVariables.productReasonSale);

        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserAd userAd = new UserAd();
                userAd.setPhoto(GlobalVariables.imageString);
                userAd.setCondition(GlobalVariables.productDescription);
                userAd.setDescrip(GlobalVariables.productDescription);
                userAd.setCostsp(Float.parseFloat(GlobalVariables.productOfferPrice));
                ref.child("ADVERTISEMENTS").child(user.getUid()).setValue(userAd);
                startActivity(new Intent(FinalActivity.this,HomeActivity.class));
            }
        });

    }


}
