package com.justnik.communalmachinery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

ComMachDB machDB = Room.databaseBuilder(getApplicationContext(), ComMachDB.class, "ComMatchDB").build();

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<CommunalMachinery> machineArrayList = (ArrayList<CommunalMachinery>) machDB.CommunalMachineryDAO().getAll();

        AdapterMachine adapterMachine = new AdapterMachine(machineArrayList);
        recyclerView.setAdapter(adapterMachine);
    }
}