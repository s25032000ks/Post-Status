package com.example.poststatus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.poststatus.R;
import com.example.poststatus.adapter.StatusListAdapter;
import com.example.poststatus.database.DatabaseHelper;
import com.example.poststatus.model.Status;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.poststatus.R.*;

public class MainActivity extends AppCompatActivity {

    ArrayList<Status> statusArrayList;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    StatusListAdapter adapter;
    int status_id;

    private ArrayAdapter<String> arrayAdapter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //showData();

        /*Status shubham = new Status();
        shubham.setStatusId(101);
        shubham.setAvartar(drawable.cartman_cop);
        shubham.setName("Shubham Kumar Singh");
        shubham.setPost(drawable.cartman_cop);
        shubham.setNoOfComments(20);

        db.addStatus(shubham);*/
        statusArrayList = new ArrayList<>();

        List<Status> statusList = new ArrayList<>();
        statusList.clear();
        statusList = db.getAllStatus();
        for (Status status: statusList){
            Log.d("values", "Id: " + status.getStatusId() +"\n"+
                    "Avartar: "+status.getAvartar()+"\n"+
                    "Name:" + status.getName() + "\n" +
                    "Post: " + status.getPost() + "\n" +
                    "No. of Comments:" + status.getNoOfComments());

            statusArrayList.add(status);
        }
        adapter = new StatusListAdapter(MainActivity.this, statusArrayList);
        mRecyclerView.setAdapter(adapter);
        //statusList.add(shubham);
    }

    /*
    private void showData() {
        //statusList.clear();
        Cursor cursor = new DatabaseHelper(this).readalldata();
        while(cursor.moveToNext())
        {
            Status status = new Status(cursor.getInt(0), cursor.getInt(1), cursor.getString(2));
            statusList.add(status);
            Log.d("values", status.toString());
        }

        adapter = new StatusListAdapter(MainActivity.this, statusList);
        mRecyclerView.setAdapter(adapter);



    }

    public void nextActivity(int position) {
        status_id = statusList.get(position).getStatusId();
        Intent intent = new Intent(MainActivity.this, Details.class);
        intent.putExtra("status_id", status_id);
        startActivity(intent);
    }
    */
}