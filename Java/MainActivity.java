package com.example.paramedics.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button mAdd,mGet,mDel;
    DB base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdd = findViewById(R.id.mAdd);
        mGet = findViewById(R.id.mGet);
        mDel = findViewById(R.id.mDel);
        mDel.setOnClickListener(this);
        mAdd.setOnClickListener(this);
        mGet.setOnClickListener(this);

        base = new DB("client");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mAdd){
            startActivity(new Intent(this,AddActivity.class));
        }else if (v.getId() == R.id.mGet){
            startActivity(new Intent(this,GetActivity.class));
        }else if (v.getId() == R.id.mDel){
            startActivity(new Intent(this,DeleteActivity.class));
        }

    }

    public DB getBase() {
        return base;
    }

    public void setBase(DB base) {
        this.base = base;
    }


}
