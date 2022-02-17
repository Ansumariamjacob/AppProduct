package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchProduct extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;
    String getPcode,getPName,getPrice;
    DatabaseHelper dBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        dBHelper=new DatabaseHelper(this);
        dBHelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.pc);
        ed2=(EditText) findViewById(R.id.pn);
        ed3=(EditText) findViewById(R.id.price);
        b1=(AppCompatButton) findViewById(R.id.search);
        b2=(AppCompatButton) findViewById(R.id.bckm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPcode=ed1.getText().toString();
                Cursor c=dBHelper.Search(getPcode);
                if(c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid code", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   while (c.moveToNext())
                   {
                       getPName=c.getString(2);
                       getPrice=c.getString(3);
                   }
                   ed2.setText(getPName);
                   ed3.setText(getPrice);
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