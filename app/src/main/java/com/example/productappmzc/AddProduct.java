package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;
    String getPName,getPcode,getPrice;
    DatabaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        DBHelper=new DatabaseHelper(this);
        DBHelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.pcode);
        ed2=(EditText) findViewById(R.id.pname);
        ed3=(EditText) findViewById(R.id.price);
        b1=(AppCompatButton) findViewById(R.id.sub);
        b2=(AppCompatButton) findViewById(R.id.bckm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPcode=ed1.getText().toString();
                getPName=ed2.getText().toString();
                getPrice=ed3.getText().toString();
                boolean result=DBHelper.insertValues(getPcode,getPName,getPrice);
                if(result==true)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "insertion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}