package com.example.projswee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // make a reference to buttons
    Button btn_add;
    EditText et_name, et_age, et_overview, et_usage,et_prod;
    //ListView lv_StudentList;
    ArrayAdapter toolArrayAdapter;
    com.example.projswee.DataBaseHelper dataBaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on create, give value
        btn_add = findViewById(R.id.btn_add);
        //btn_view = findViewById(R.id.btn_view);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        et_overview = findViewById(R.id.et_overview);
        et_usage = findViewById(R.id.et_usage);
        et_prod = findViewById(R.id.et_Production);
        //lv_StudentList = findViewById(R.id.lv_StudentList);

        dataBaseHelper = new com.example.projswee.DataBaseHelper(MainActivity.this);
        //ShowStudentsOnListView(dataBaseHelper);



        findViewById(R.id.btn_add2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, list.class));
            }
        });


        //Listeners:
/**
 *
 *         btn_view.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View v) {
 *                 dataBaseHelper = new com.example.projswee.DataBaseHelper(MainActivity.this);
 *                 ShowStudentsOnListView(dataBaseHelper);
 *
 *                 //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
 *             }
 *         });*/

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create model
                toolModel toolmod;
                try {
                    toolmod = new toolModel(-1,0,et_name.getText().toString(), et_age.getText().toString(),et_overview.getText().toString(),et_usage.getText().toString(), et_prod.getText().toString(),0);
                    Toast.makeText(MainActivity.this, toolmod.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    toolmod = new toolModel(-1, 0, "","","","",null,0);
                }

                com.example.projswee.DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean b = dataBaseHelper.addOne(toolmod);
                Toast.makeText(MainActivity.this, "SUCCESS= " + b, Toast.LENGTH_SHORT).show();

                //ShowStudentsOnListView(dataBaseHelper);

            }
        });

        /**lv_StudentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        toolModel ClickedStudent = (toolModel) adapterView.getItemAtPosition(i);
        dataBaseHelper.DeleteOne(ClickedStudent);
        ShowStudentsOnListView(dataBaseHelper);
        Toast.makeText(MainActivity.this, "Deleted" + ClickedStudent.toString(), Toast.LENGTH_SHORT).show();
        }
        });*/


    }

    /**
     *
     *     @Override
     *     public boolean onCreateOptionsMenu(Menu menu) {
     *         MenuInflater inflater = getMenuInflater();
     *         inflater.inflate(R.menu.options_menu, menu);
     *         MenuItem menuItem = menu.findItem(R.id.search);
     *         SearchView searchView = (SearchView) menuItem.getActionView();
     *         searchView.setQueryHint("Type here to search");
     *         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
     *
     *             @Override
     *             public boolean onQueryTextSubmit(String s) {
     *                 List<toolModel> searchResult = dataBaseHelper.searchStudent(s);
     *                 if(searchResult.isEmpty())
     *                 {
     *                     Toast.makeText(MainActivity.this, "Student not found!",
     *                             Toast.LENGTH_SHORT).show();
     *                 }
     *                 else
     *                 {
     *                     toolArrayAdapter = new
     *                             ArrayAdapter<toolModel>(MainActivity.this,
     *                             android.R.layout.simple_list_item_1, searchResult);
     *                     lv_StudentList.setAdapter(toolArrayAdapter);
     *                 }
     *                 return false;
     *             }
     *             // onQueryTextChange method will be called once user types a character
     *             @Override
     *             public boolean onQueryTextChange(String s) {
     *                 return false;
     *             }
     *         });
     *
     *         return true;
     *
     *
     *
     *
     *
     *     }
     *     private void ShowStudentsOnListView(com.example.projswee.DataBaseHelper dataBaseHelper) {
     *         toolArrayAdapter = new ArrayAdapter<toolModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
     *         lv_StudentList.setAdapter(toolArrayAdapter);
     *     }*/


}