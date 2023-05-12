package com.example.projswee;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TOOL_TABLE = "TOOL_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME ";
    public static final String COLUMN_RATE = "RATE ";
    public static final String COLUMN_MODEL = "MODEL ";
    public static final String COLUMN_OVERVIEW = "TOOL_OVERVIEW ";
    public static final String COLUMN_USAGE = "TOOL_USAGE ";
    public static final String COLUMN_PRODUCTION = "PRODUCTION";
    public static final String COLUMN_RATENUM = "RATENUM ";



    public DataBaseHelper(@Nullable Context context) {
        super(context, "tool.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement="CREATE TABLE " +TOOL_TABLE+ "(" +COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+ " TEXT,"+COLUMN_RATE+" INT, "+COLUMN_MODEL+ " TEXT, "+COLUMN_OVERVIEW+ " TEXT, "+COLUMN_USAGE+ " TEXT, "+COLUMN_PRODUCTION+ " TEXT, "+COLUMN_RATENUM+ " INTEGER);";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(toolModel toolModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(COLUMN_RATE,0);
        cv.put(COLUMN_NAME,toolModel.getName());
        cv.put(COLUMN_MODEL,toolModel.getModel());
        cv.put(COLUMN_OVERVIEW,toolModel.getOverview());
        cv.put(COLUMN_USAGE,toolModel.getUsage());
        cv.put(COLUMN_PRODUCTION,toolModel.getProdYear());
        cv.put(COLUMN_RATENUM,0);
        long insert = db.insert(TOOL_TABLE, null, cv);
        return insert != -1;
    }

    public List<toolModel> getEveryone(){

        List<toolModel> returnList=new ArrayList<>();
        String quString="SELECT * FROM "+ TOOL_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(quString,null);
        if (cursor.moveToFirst()){
            do{
                int toolID=cursor.getInt(0);
                int toolRate=cursor.getInt(1);
                String toolName=cursor.getString(2);
                String toolModel=cursor.getString(3);
                String tooloverview=cursor.getString(4);
                String toolUsage=cursor.getString(5);
                String toolProd=cursor.getString(6);
                int toolRateNum=cursor.getInt(7);

                toolModel newTool=new toolModel(toolID,toolRate,toolName,toolModel,tooloverview,toolUsage,toolProd,toolRateNum);
                returnList.add(newTool);

            }while (cursor.moveToNext());
        }else {

        }
        cursor.close();
        db.close();

        return returnList;
    }
}
