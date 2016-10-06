package com.padc.beauty.activities;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.padc.beauty.BeautyApp;
import com.padc.beauty.data.vos.DressingVO;
import com.padc.beauty.views.holders.DressingViewHolder;

/**
 * Created by windows on 10/5/2016.
 */
public class BaseActivity extends AppCompatActivity  {
    public void sharemsg(String msg){
//        Toast.makeText(BeautyApp.getContext(), "share", Toast.LENGTH_SHORT).show();
//        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//        Uri screenshotUri = Uri.parse(MediaStore.Images.Media.EXTERNAL_CONTENT_URI + "/" + msg);
//
//        sharingIntent.setType("image/jpeg");
//        sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
//
//        startActivity(Intent.createChooser(sharingIntent, "Share image using"));
        Toast.makeText(BeautyApp.getContext(), "get activiyt", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT,msg);

        startActivity(Intent.createChooser(intent, "Share Image"));
    }


}
