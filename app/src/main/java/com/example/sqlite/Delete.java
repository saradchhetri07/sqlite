package com.example.sqlite;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {
    EditText uname;
    Button btn;
    DBHelper dbHelper;
    private static final String dbName="studentdb";
    private static final String tableName="student";
    private static final int dbVersion=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        uname=findViewById(R.id.uname);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper=new DBHelper(Delete.this,dbName,null,dbVersion);
                dbHelper.delete(uname.getText().toString());
                Intent it = new Intent(Delete.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}