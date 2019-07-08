package com.example.naman.ridedoctor;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;
    Button rreg;
    Button rReset;
    EditText rname;
    EditText remail;
    EditText rphone;
    EditText rpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqLiteOpenHelper=new DatabaseHelper(this);
        rreg=(Button)findViewById(R.id.button);
        rReset=(Button)findViewById(R.id.button2);
        rname=(EditText)findViewById(R.id.editText);
        remail=(EditText)findViewById(R.id.editText2);
        rphone=(EditText)findViewById(R.id.editText3);
        rpass=(EditText)findViewById(R.id.editText4);
        rreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
                String Dname=rname.getText().toString();
                String Demail=remail.getText().toString();
                String Dphone=rphone.getText().toString();
                String Dpass=rpass.getText().toString();
                if(validate(Dphone)){
                    insertData(Dname,Demail,Dphone,Dpass);
                    Toast.makeText(getApplicationContext(),"Registeration Successfull!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Information!",Toast.LENGTH_LONG).show();
            }
        });
        rReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rname.setText("");
                remail.setText("");
                rphone.setText("");
                rpass.setText("");
                Toast.makeText(getApplicationContext(),"Enter Credentials Again!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public boolean validate(String rphone){
        if(rphone.length()==10){
            return true;
        }
        else
            return false;
    }
    public void insertData(String Dname,String Demail,String Dphone,String Dpass){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,Dname);
        contentValues.put(DatabaseHelper.COL_3,Demail);
        contentValues.put(DatabaseHelper.COL_4,Dphone);
        contentValues.put(DatabaseHelper.COL_5,Dpass);
        long id=sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }
}
