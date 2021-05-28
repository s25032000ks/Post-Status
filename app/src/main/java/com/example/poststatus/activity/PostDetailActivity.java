package com.example.poststatus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poststatus.R;

public class PostDetailActivity extends AppCompatActivity {

    TextView txtUserName, txtComments;
    ImageView imgStatus;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtUserName = findViewById(R.id.txtUserName);
        imgStatus = findViewById(R.id.imgStatus);
        txtComments = findViewById(R.id.txtComments);

        intent = getIntent();
        int avartar = intent.getIntExtra("avartar", 0);
        //int avartar = Integer.parseInt(intent.getStringExtra("avartar"));
        String name = intent.getStringExtra("name");
        int post = intent.getIntExtra("post", 0);
        int noOfComment = intent.getIntExtra("noOfComment", 12);
        //int post = Integer.parseInt(intent.getStringExtra("post"));
        //int noOfComment = Integer.parseInt(intent.getStringExtra("noOfComment"));

        txtUserName.setText(name);
        imgStatus.setImageResource(post);
        txtComments.setText("No of Comment: "+String.valueOf(noOfComment));
    }
}