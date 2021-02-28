package com.justnik.communalmachinery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private MainActivity instance;
    private ComMachDB database;
    private CommunalMachineryDAO machineryDAO;
    RecyclerView rvListOfMachines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        database = Room.databaseBuilder(this, ComMachDB.class, "database").build();
        machineryDAO = database.CommunalMachineryDAO();

        /* If you want insert some data please uncomment this rows and change objects */

        CommunalMachinery communalMachinery1 = new CommunalMachinery("Tracktor",1,  "perHour", "photo1.png", "+380685487510");
        CommunalMachinery communalMachinery2 = new CommunalMachinery("Excavator",2,  "perHour", "photo2.png", "+380451254785");
        CommunalMachinery communalMachinery3 = new CommunalMachinery("Shovel",3,  "perHour", "photo3.png", "+380574813559");

        new InsertAsyncTask().execute(communalMachinery1);
        new InsertAsyncTask().execute(communalMachinery2);
        new InsertAsyncTask().execute(communalMachinery3);

        /* End of insert data */

        rvListOfMachines = findViewById(R.id.rvListOfMachines);
        rvListOfMachines.setLayoutManager(new LinearLayoutManager(this));
        new GetDataTask().execute();


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miRefresh:

                break;
            case R.id.miInitialize :


        }
        return super.onOptionsItemSelected(item);
    }

    private class RowCountTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return machineryDAO.getRowCount();
        }
    }

    // Inserting data in db in AsyncTask
    private class InsertAsyncTask extends AsyncTask<CommunalMachinery, Void, Void> {
        CommunalMachinery machinery;

        @Override
        protected Void doInBackground(CommunalMachinery... communalMachineries) {
            if (machineryDAO.getRowCount()<3) {
                machinery = communalMachineries[0];
                machineryDAO.insertAll(machinery);
            }
            return null;
        }
    }

    // Async task designed to get data from db amd set it as a source for RecyclerView
    private class GetDataTask extends AsyncTask<Void, Void, List<CommunalMachinery>> {
        @Override
        protected List<CommunalMachinery> doInBackground(Void... voids) {
            // Getting data from db in background
            List<CommunalMachinery> machineryList =  machineryDAO.getAll();
            Log.d("RecyclerView", "Got all machines "+machineryList);

            return machineryList;
        }

        @Override
        protected void onPostExecute(List<CommunalMachinery> list) {
            super.onPostExecute(list);

            // On post execute set RecyclerView adapter with data from db
            Log.d("RecyclerView", "Setting list to rv "+list);

            CommunalMachineryAdapter machineryAdapter = new CommunalMachineryAdapter(list, (cm) -> {
                //TODO: implement second activity call
                //Intent intent = new Intent();
                Log.d("Adapter", "Clicked object " + cm);
            });
            rvListOfMachines.setAdapter(machineryAdapter);

        }
    }
}