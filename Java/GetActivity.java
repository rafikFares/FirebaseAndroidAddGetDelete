package com.example.paramedics.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.paramedics.test.DB.myRef;


public class GetActivity extends AppCompatActivity {

    TextView textView;
    ArrayList<Client> uneListe = new ArrayList<>();
    String desChoses = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        myListener();

        textView = findViewById(R.id.textView);
        textView.setText("");

    }

    public void myListener(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                clear();
                Log.d("data : ",dataSnapshot.toString());
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Log.d("post : ", postSnapshot.toString());
                    //getting client

                    Log.d("key : ", postSnapshot.getKey());
                    Log.d("children : ", postSnapshot.getChildren().toString());

                    Client client = postSnapshot.getValue(Client.class);
                    //adding client to the list
                    uneListe.add(client);

                }
                update();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void clear(){
        textView.setText("");
        desChoses = "";
        uneListe.clear();
    }

    public void update(){
        for (Client client : uneListe){
            desChoses += " cid : "+client.getCid()+" nom : "+client.getNom()+" prenom : "+client.getPrenom();
        }
        Log.d("des choses : ",desChoses);
        textView.setText(desChoses);
    }

}
