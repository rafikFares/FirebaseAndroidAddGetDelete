package com.example.paramedics.test;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DB {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef;

    public DB(String db) {
        myRef = database.getReference(db);

    }

    public static void ajouterClient(Client client){
        myRef.child(client.getCid()).setValue(client);
    }



}
