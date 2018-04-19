package com.example.paramedics.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static com.example.paramedics.test.DB.myRef;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {


    Button bDelete,bRemove;
    EditText editTextDel,editTextData,editTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        bDelete = findViewById(R.id.bDelete);
        bRemove = findViewById(R.id.bRemove);
        bDelete.setOnClickListener(this);
        bRemove.setOnClickListener(this);

        editTextDel = findViewById(R.id.editTextDel);
        editTextData = findViewById(R.id.editTextData);
        editTextField = findViewById(R.id.editTextField);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bDelete) {
            myRef.child(editTextDel.getText().toString()).removeValue();
        }else if (v.getId() == R.id.bRemove) {
            //deleteByNom(editTextData.getText().toString());
            deleteByFieldData(editTextField.getText().toString(), editTextData.getText().toString());
        }
    }

    public void deleteByNom(final String data){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("data : ",dataSnapshot.toString());
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Log.d("post : ", postSnapshot.toString());
                    //getting client

                    Log.d("key : ", postSnapshot.getKey());
                    Log.d("children : ", postSnapshot.getChildren().toString());

                    if (postSnapshot.getValue(Client.class).getNom().equals(data)){
                        postSnapshot.getRef().removeValue();
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void deleteByFieldData(String field, String data){
        Query query = myRef.orderByChild(field).equalTo(data);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("data : ",dataSnapshot.toString());

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Log.d("post : ", postSnapshot.toString());
                    //getting client

                    Log.d("key : ", postSnapshot.getKey());
                    Log.d("children : ", postSnapshot.getChildren().toString());
                    postSnapshot.getRef().removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d( "onCancelled", String.valueOf(databaseError.toException()));
            }
        });
    }

}