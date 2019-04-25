package com.example.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

       Button b1,b2;
       EditText e1,e2;
       private Firebase mrootef;


    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        e1=(EditText) findViewById(R.id.text1);
        e2=(EditText) findViewById(R.id.text2);

    }
    void buttonclicked(View v)
    {
        mrootef=new Firebase("https://fir-app-a4702.firebaseio.com/users");
        String value=e1.getText().toString();
        String key=e2.getText().toString();
        if(value.length()==0||key.length()==0)
        {
            Toast.makeText(
                    MainActivity.this,
                    "EMPTY FIELDS",
                    Toast.LENGTH_SHORT
            ).show();
        }
        else {
            Firebase mrefchild = mrootef.child(value);
            mrefchild.setValue(key);
        }

    }
    void buttonpressed(View v)
    {
        Intent i= new Intent(MainActivity.this,list.class);
        startActivity(i);

    }
}
