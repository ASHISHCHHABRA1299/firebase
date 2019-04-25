package com.example.firebase;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class list extends AppCompatActivity {
     ListView mlistview;
     ArrayList<String> muser=new ArrayList<String>();
     Firebase mrootef;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_list);

        mrootef=new Firebase("https://fir-app-a4702.firebaseio.com/users");
       mlistview=(ListView) findViewById(R.id.list1);
          final ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,muser);
          mlistview.setAdapter(arrayadapter);
          mrootef.addChildEventListener(new ChildEventListener() {
              @Override
              public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    String key= dataSnapshot.getKey();
                    muser.add(key);
                  String value= dataSnapshot.getValue(String.class);
                  muser.add(value);
                    arrayadapter.notifyDataSetChanged();
              }

              @Override
              public void onChildChanged(DataSnapshot dataSnapshot, String s) {

              }

              @Override
              public void onChildRemoved(DataSnapshot dataSnapshot) {

              }

              @Override
              public void onChildMoved(DataSnapshot dataSnapshot, String s) {

              }

              @Override
              public void onCancelled(FirebaseError firebaseError) {

              }
          });
    }
}
