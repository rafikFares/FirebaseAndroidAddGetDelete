package com.example.paramedics.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {


    Button bAdd;
    EditText editTextCid,editTextNom,editTextPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        bAdd = findViewById(R.id.bAdd);
        bAdd.setOnClickListener(this);

        editTextCid = findViewById(R.id.editTextCid);
        editTextNom = findViewById(R.id.editTextNom);
        editTextPrenom = findViewById(R.id.editTextPrenom);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bAdd){
            Client client = new Client(editTextCid.getText().toString(),
                    editTextNom.getText().toString(),
                    editTextPrenom.getText().toString());

            DB.ajouterClient(client);
        }
    }


}
