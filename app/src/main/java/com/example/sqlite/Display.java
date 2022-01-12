package com.example.sqlite;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {
    TextView txt;
    DBHelper dbHelper;
    private static final String dbName="studentdb";
    private static final String tableName="student";
    private static final int dbVersion=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        txt=findViewById(R.id.mytext);
        dbHelper=new DBHelper(Display.this,dbName,null,dbVersion);
        String res=dbHelper.display();
        txt.setText(res);
    }
}