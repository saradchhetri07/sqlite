package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {
    EditText uname,password;
    Button btn;
    DBHelper dbHelper;
    private static final String dbName="studentdb";
    private static final String tableName="student";
    private static final int dbVersion=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        uname=findViewById(R.id.uname);
        password=findViewById(R.id.password);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper=new DBHelper(Update.this,dbName,null,dbVersion);
                dbHelper.update(uname.getText().toString(),password.getText().toString());
                Intent it = new Intent(Update.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}