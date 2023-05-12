package com.example.projswee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class list extends AppCompatActivity {
    ListView lv_StudentList;
    ArrayAdapter toolArrayAdapter;
    com.example.projswee.DataBaseHelper dataBaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        lv_StudentList = findViewById(R.id.lv_ToolList);
        dataBaseHelper = new com.example.projswee.DataBaseHelper(list.this);



        //Toast.makeText(list.this,everyone.toString(),Toast.LENGTH_SHORT).show();
        toolArrayAdapter=new ArrayAdapter<toolModel>(list.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());

        lv_StudentList.setAdapter(toolArrayAdapter);

    }

    }
