package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText uname,password;
    Button btn;
    DBHelper dbHelper;
    private static final String dbName="studentdb";
    private static final String tableName="student";
    private static final int dbVersion=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        uname=findViewById(R.id.uname);
        password=findViewById(R.id.password);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper=new DBHelper(Register.this,dbName,null,dbVersion);
                long val=dbHelper.addUser(uname.getText().toString(),password.getText().toString());
                if(val==-1)
                {
                    Toast.makeText(Register.this, "Error cannot be added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Register.this, "USER REGISTERED",
                            Toast.LENGTH_SHORT).show();
                    Intent it=new Intent(Register.this,MainActivity.class);
                    startActivity(it);
                }
            }
        });
    }
}