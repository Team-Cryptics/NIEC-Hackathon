package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;

public class SelectDevice extends AppCompatActivity implements View.OnClickListener {


    String device_type;
    CardView cv1,cv2,cv3,cv4;
    ImageView iv1,iv2,iv3,iv4;
    TextView tv_dev1, tv_dev2, tv_dev3, tv_dev4,tv_pri1,tv_pri2,tv_pri3,tv_pri4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device);
        device_type=GlobalVariables.deviceType;

        cv1= (CardView) findViewById(R.id.cv_1); cv1.setOnClickListener(this);
        cv2= (CardView) findViewById(R.id.cv_2); cv2.setOnClickListener(this);
        cv3= (CardView) findViewById(R.id.cv_3); cv3.setOnClickListener(this);
        cv4= (CardView) findViewById(R.id.cv_4); cv4.setOnClickListener(this);

        iv1= (ImageView) findViewById(R.id.iv_Product1);
        iv2= (ImageView) findViewById(R.id.iv_Product2);
        iv3= (ImageView) findViewById(R.id.iv_Product3);
        iv4= (ImageView) findViewById(R.id.iv_Product4);

        tv_dev1 = (TextView) findViewById(R.id.tv_Device1);
        tv_dev2 = (TextView) findViewById(R.id.tv_Device2);
        tv_dev3 = (TextView) findViewById(R.id.tv_Device3);
        tv_dev4 = (TextView) findViewById(R.id.tv_Device4);

        tv_pri1 = (TextView) findViewById(R.id.tv_Price1);
        tv_pri2 = (TextView) findViewById(R.id.tv_Price2);
        tv_pri3 = (TextView) findViewById(R.id.tv_Price3);
        tv_pri4 = (TextView) findViewById(R.id.tv_Price4);

       if(device_type.equals("Mobiles")){


           setCardViewValue("iPhone 5S 16 GB","19500","iPhone 6S 32 GB","56000",
                   "Samsung Galaxy S4","20000","Samsung Galaxy S5","42000",
                   R.drawable.appmob,R.drawable.appmobi,R.drawable.sammob,R.drawable.sammobi);

       }
        else if(device_type.equals("Laptops")){

           setCardViewValue("Apple Macbook Air 13' ","55000","Apple Macbook Pro 10' ","80000",
                   "Lenovo Ideapad","25000","Lenovo Yoga Laptop 13'","36000",
                   R.drawable.macpro,R.drawable.macpro,R.drawable.lenidea,R.drawable.lenyoga);

       }
       else if(device_type.equals("TV")){

           setCardViewValue("Micromax TV A1 55'","20000","Micromax TV A2 36' ","32000",
                   "Samsung Smart TV 55'","78000","Sony Bravia A550 35' ","35000",
                   R.drawable.mictel,R.drawable.micteli,R.drawable.samsmart,R.drawable.sambra);

       }
        else if(device_type.equals("Tablets")){

           setCardViewValue("Lenovo Tab A6","6500","Lenovo Yoga Tab D233","15000","Samsung Tab 2 10'"
                   ,"18000","Samsung Galaxy Tab 3","24000",R.drawable.lentab,
                   R.drawable.lentabi,R.drawable.samtabi,R.drawable.samtabs);

       }
    }

    void setCardViewValue( String tvd1, String tvp1,String tvd2, String tvp2,String tvd3,
              String tvp3,String tvd4, String tvp4,int setiv1,int setiv2, int setiv3, int setiv4)
    {
        tv_dev1.setText(tvd1);
        tv_pri1.setText(tvp1);
        iv1.setImageResource(setiv1);
        tv_dev2.setText(tvd2);
        tv_pri2.setText(tvp2);
        iv2.setImageResource(setiv2);
        tv_dev3.setText(tvd3);
        tv_pri3.setText(tvp3);
        iv3.setImageResource(setiv3);
        tv_dev4.setText(tvd4);
        tv_pri4.setText(tvp4);
        iv4.setImageResource(setiv4);
    }


    @Override
    public void onClick(View view) {

        GlobalVariables.productCategory = device_type;
        switch (view.getId()) {
            case R.id.cv_1 :
                GlobalVariables.productName = tv_dev1.getText().toString();
                GlobalVariables.productMRP = tv_pri1.getText().toString();
                break;
            case R.id.cv_2 :
                GlobalVariables.productName = tv_dev2.getText().toString();
                GlobalVariables.productMRP = tv_pri2.getText().toString();

                break;
            case R.id.cv_3 :
                GlobalVariables.productName = tv_dev3.getText().toString();
                GlobalVariables.productMRP = tv_pri3.getText().toString();
                break;
            case R.id.cv_4 :
                GlobalVariables.productName = tv_dev4.getText().toString();
                GlobalVariables.productMRP = tv_pri4.getText().toString();
                break;
        }

        Log.i("TAG",GlobalVariables.productName);
        startActivity(new Intent(SelectDevice.this,Camera_Activity.class));
        finish();
    }
}
