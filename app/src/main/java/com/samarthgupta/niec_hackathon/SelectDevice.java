package com.samarthgupta.niec_hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectDevice extends AppCompatActivity {

    //GET FROM INTENT
    String device_type="Laptops";

    CardView cv1,cv2,cv3,cv4;
    ImageView iv1,iv2,iv3,iv4;
    TextView tv_dev1, tv_dev2, tv_dev3, tv_dev4,tv_pri1,tv_pri2,tv_pri3,tv_pri4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device);

        cv1= (CardView) findViewById(R.id.cv_1);
        cv2= (CardView) findViewById(R.id.cv_2);
        cv3= (CardView) findViewById(R.id.cv_3);
        cv4= (CardView) findViewById(R.id.cv_4);

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


           setCardViewValue("iPhone 5S 16 GB","MRP Rs.19500","iPhone 6S 32 GB","MRP Rs.56000",
                   "Samsung Galaxy S4","MRP Rs.20000","Samsung Galaxy S5","MRP Rs.42000");

       }
        else if(device_type.equals("Laptops")){

           setCardViewValue("Apple Macbook Air 13 inch","MRP Rs.55000","Apple Macbook Pro 10 inch","MRP Rs.80000",
                   "Lenovo Ideapad","MRP Rs.25000","Lenovo Yoga Laptop 13 inch","MRP Rs.36000");

       }
       else if(device_type.equals("TV")){

           setCardViewValue("Micromax TV A1 55 inch","MRP Rs.20000","Micromax TV A2 36 inch","MRP Rs.32000",
                   "Samsung Smart TV 55 inch","MRP Rs.78000","Sony Bravia A550 35 inch","MRP Rs.35000");

       }
        else if(device_type.equals("Tablets")){

           setCardViewValue("Lenovo Tab A6","MRP Rs.6500","Lenovo Yoga Tab D233","MRP Rs.15000","Samsung Galaxy Tab 2 10 inches"
                   ,"MRP Rs.18000","Samsung Galaxy Tab 3","MRP Rs.24000");

       }
    }

    void setCardViewValue( String tvd1, String tvp1,String tvd2, String tvp2,String tvd3,
              String tvp3,String tvd4, String tvp4)
    {
        tv_dev1.setText(tvd1);
        tv_pri1.setText(tvp1);
        tv_dev2.setText(tvd2);
        tv_pri2.setText(tvp2);
        tv_dev3.setText(tvd3);
        tv_pri3.setText(tvp3);
        tv_dev4.setText(tvd4);
        tv_pri4.setText(tvp4);
    }


}
