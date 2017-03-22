package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;
import com.samarthgupta.niec_hackathon.POJO.PlaceOrder;
import com.samarthgupta.niec_hackathon.POJO.UserAd;

/**
 * Created by samarthgupta on 22/03/17.
 */

public class FinalActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
    DatabaseReference ref;
    FirebaseUser user;
    FirebaseAuth auth;

    TextView tv1,tv2,tv3,prop1,prop2;
    ImageView product_Image;
    Button proceed_btn;
    Integer count=0;

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
        auth = FirebaseAuth.getInstance();
       // user=auth.getCurrentUser();


        tv1.setText(GlobalVariables.productName);
        tv2.setText("MRP Rs."+GlobalVariables.productMRP);
        tv3.setText("Price Rs."+GlobalVariables.productOfferPrice);
        product_Image.setImageBitmap(GlobalVariables.m_Image);
        prop1.setText("Description"+GlobalVariables.productDescription);
        prop2.setText("Reason for sale"+GlobalVariables.productReasonSale);


       ref.child("COUNT").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
                count = dataSnapshot.getValue(Integer.class);
               Log.i("TAG",Integer.toString(count));
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });


        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long time = System.currentTimeMillis();
                PlaceOrder userAd = new PlaceOrder();
                userAd.setPhoto(GlobalVariables.imageString);
                userAd.setCondition(GlobalVariables.productDescription);
                userAd.setDescrip(GlobalVariables.productDescription);
                userAd.setCostsp(Float.parseFloat(GlobalVariables.productOfferPrice));
                userAd.setUserID(FirebaseAuth.getInstance().getCurrentUser().getUid());
                userAd.setUniqueID(String.valueOf(time));

                count++;
               ref.child("ADVERTISEMENTS").child(Integer.toString(count)).setValue(userAd);
                ref.child("COUNT").setValue(count);
              // ref.child("ADVERTISEMENTS").child().setValue(userAd);
                startActivity(new Intent(FinalActivity.this,HomeActivity.class));
            }
        });

    }


}
