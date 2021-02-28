package com.justnik.communalmachinery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;
    private ComMachDB database;
    private CommunalMachineryDAO machineryDAO;
    ArrayList<CommunalMachinery> machineryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Purchase()).commit(); // <---- :)
        //удаліть коли зробите
        //RecycleView

        instance = this;
        database = Room.databaseBuilder(this, ComMachDB.class, "database").build();

        ComMachDB db = MainActivity.getInstance().getDatabase();
        machineryDAO = db.CommunalMachineryDAO();

        /* If you want insert some data please uncomment this rows and change objects */

//        CommunalMachinery communalMachinery1 = new CommunalMachinery(1, 200, "perHour", "photo1.png", "+380685487510");
//        CommunalMachinery communalMachinery2 = new CommunalMachinery(2, 300, "perHour", "photo2.png", "+380451254785");
//        CommunalMachinery communalMachinery3 = new CommunalMachinery(3, 150, "perHour", "photo3.png", "+380574813559");
//
//        new InsertAsyncTask().execute(communalMachinery1);
//        new InsertAsyncTask().execute(communalMachinery2);
//        new InsertAsyncTask().execute(communalMachinery3);

        /* End of insert data */

        new QueryAsyncTask().execute();

    }

    private static MainActivity getInstance() {
        return instance;
    }

    public ComMachDB getDatabase() {
        return database;
    }

    private class InsertAsyncTask extends AsyncTask<CommunalMachinery, Void, Void> {
        CommunalMachinery machinery;

        @Override
        protected Void doInBackground(CommunalMachinery... communalMachineries) {
            machinery = communalMachineries[0];
            machineryDAO.add(machinery);
            return null;
        }
    }

    private class QueryAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            machineryList = (ArrayList<CommunalMachinery>) machineryDAO.getAll();
            return null;
        }
    }
}