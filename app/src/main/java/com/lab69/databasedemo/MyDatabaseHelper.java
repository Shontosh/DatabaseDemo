package com.lab69.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME="book_store.db";
    private static  final String TABLE_NAME="cse_book_list";
    private static  final int Version = 4 ;
    private static  final String ID = "_id";
    private static  final String NAME="Name";
    private static  final String WRITER="Writer_Name";
    private static  final String PRICE="Price";
    private static  final String CREATE_TABLE= "CREATE TABLE  " +TABLE_NAME+ " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," + NAME +" VARCHAR(100), "+WRITER+"VARCHAR,"+PRICE+"INTEGER);";
    private Context context;




    public MyDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, Version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{

            Toast.makeText(context, "DATABASE IS CREATED", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

            sqLiteDatabase = this.getWritableDatabase();
        }

        catch(Exception e){
            Toast.makeText(context, "EXCEPTION"+e, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}


