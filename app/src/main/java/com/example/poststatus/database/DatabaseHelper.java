package com.example.poststatus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.poststatus.R;
import com.example.poststatus.constaint.Const;
import com.example.poststatus.model.Status;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, Const.DB_NAME, null, Const.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Const.TABLE_NAME + " ("
                + Const.STATUS_ID + " INTEGER PRIMARY KEY," + Const.AVARTAR + " INTEGER, "
                + Const.NAME + "TEXT, " + Const.POST + " INTEGER, " + Const.NO_OF_COMMENTS
                + " INTEGR )";
        db.execSQL(create);

        String insert = "INSERT INTO status_table VALUES ( 101, " + R.drawable.cartman_cop + ",' Shubham Kumar Singh' , " + R.drawable.cartman_cop + ", 15)";
        db.execSQL(insert);
        Log.d("insert", insert );
        db.execSQL("INSERT INTO status_table VALUES ( 102, " + R.drawable.chef + ",' Shilpa Bhansali' , " + R.drawable.chef + ", 10)");
        db.execSQL("INSERT INTO status_table VALUES ( 103, " + R.drawable.cwm_logo + ",' Riya Rathore' , " + R.drawable.cwm_logo + ", 9)");
        db.execSQL("INSERT INTO status_table VALUES ( 104, " + R.drawable.eric_cartman + ",' Piyush Goyal' , " + R.drawable.eric_cartman + ", 13)");
        db.execSQL("INSERT INTO status_table VALUES ( 105, " + R.drawable.ike + ",' Wajahat Rizvi' , " + R.drawable.ike + ", 5)");
        db.execSQL("INSERT INTO status_table VALUES ( 106, " + R.drawable.kyle + ",' Aseem Chauhan' , " + R.drawable.kyle + ", 8)");
        db.execSQL("INSERT INTO status_table VALUES ( 107, " + R.drawable.satan + ",' Hemant Kumar' , " + R.drawable.satan + ", 13)");
        db.execSQL("INSERT INTO status_table VALUES ( 108, " + R.drawable.tweek + ",' Shivam' , " + R.drawable.tweek + ", 15)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Const.TABLE_NAME);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from status_table", null);
        return cursor;
    }


    public void addStatus(Status status){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Const.STATUS_ID, status.getStatusId());
        values.put(Const.AVARTAR, status.getAvartar());
        values.put(Const.NAME, status.getName());
        values.put(Const.POST, status.getPost());
        values.put(Const.NO_OF_COMMENTS, status.getNoOfComments());

        db.insert(Const.TABLE_NAME, null, values);
        db.close();
    }

    public List<Status> getAllStatus(){
        List<Status> statusList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + Const.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()){
            do{
                Status status = new Status();
                status.setStatusId(Integer.parseInt(cursor.getString(0)));
                status.setAvartar(Integer.parseInt(cursor.getString(1)));
                status.setName(cursor.getString(2));
                status.setPost(Integer.parseInt(cursor.getString(3)));
                status.setNoOfComments(Integer.parseInt(cursor.getString(4)));
                statusList.add(status);
            }while (cursor.moveToNext());
        }
        return statusList;
    }
}
