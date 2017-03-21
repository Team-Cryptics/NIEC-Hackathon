package com.samarthgupta.niec_hackathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.samarthgupta.niec_hackathon.ImageConverter;
import com.samarthgupta.niec_hackathon.POJO.GlobalVariables;

public class Camera_Activity extends AppCompatActivity {
    static int IMAGE_CAPTURE_CODE = 7;
    ImageView iv_camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_);
        iv_camera = (ImageView)findViewById(R.id.iv_camera);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent , IMAGE_CAPTURE_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            iv_camera.setImageBitmap(imageBitmap);
            GlobalVariables.m_Image = imageBitmap;
            GlobalVariables.imageString = ImageConverter.BitMapToString(imageBitmap);

            Log.i("TAG",GlobalVariables.productName);

        }
    }
}

