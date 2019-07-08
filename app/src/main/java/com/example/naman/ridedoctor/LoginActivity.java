package com.example.naman.ridedoctor;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;
    Button Lsubmit;
    Button Lreset;
    EditText Lemail;
    EditText Lpass;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqLiteOpenHelper=new DatabaseHelper(this);
        sqLiteDatabase=sqLiteOpenHelper.getReadableDatabase();
        Lsubmit=(Button)findViewById(R.id.button3);
        Lreset=(Button)findViewById(R.id.button4);
        Lemail=(EditText)findViewById(R.id.editText6);
        Lpass=(EditText)findViewById(R.id.editText7);
        Lsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Cemail=Lemail.getText().toString();
                String Cpass=Lpass.getText().toString();
                cursor=sqLiteDatabase.rawQuery(" SELECT * FROM "+DatabaseHelper.TABLE_NAME+" WHERE "+DatabaseHelper.COL_3+"=? AND "+DatabaseHelper.COL_5+"=?",new String[]{Cemail,Cpass});
                if(cursor!=null){
                    if(cursor.getCount()>0){
                        Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(LoginActivity.this,AskingQuestions.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Invalid Credentials!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
