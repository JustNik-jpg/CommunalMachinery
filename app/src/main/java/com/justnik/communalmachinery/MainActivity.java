package com.justnik.communalmachinery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;
    private ComMachDB database;
    private CommunalMachineryDAO machineryDAO;
    public static ArrayList<CommunalMachinery> machineryList;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navFragment);
        navController = host.getNavController();

        navController.navigate(R.id.home_fragment);

        instance = this;
        database = Room.databaseBuilder(this, ComMachDB.class, "ComMatchDB").build();

        ComMachDB db = MainActivity.getInstance().getDatabase();
        machineryDAO = db.CommunalMachineryDAO();

        /* If you want insert some data please uncomment this rows and change objects */

        CommunalMachinery communalMachinery1 = new CommunalMachinery("АВТОБУС МАЗ 251062", 200, "perHour", "https://avtek.ua/storage/product-image/220x155/1555067152_PZxpDn.png", "+380685487510");
        CommunalMachinery communalMachinery2 = new CommunalMachinery("ТРАКТОР БЕЛАРУС-80.1", 300, "perHour", "https://avtek.ua/storage/product-image/220x155/1529413264_erTp1q.png", "+380451254785");
        CommunalMachinery communalMachinery3 = new CommunalMachinery("ЭКСКАВАТОР-ПОГРУЗЧИК БАМ-2014", 150, "perHour", "https://avtek.ua/storage/product-image/220x155/1570711191_xSatkP.png", "+380574813559");

        new InsertAsyncTask().execute(communalMachinery1);
        new InsertAsyncTask().execute(communalMachinery2);
        new InsertAsyncTask().execute(communalMachinery3);

        /* End of insert data */

        new QueryAsyncTask().execute();

    }

    private static MainActivity getInstance() {
        return instance;
    }

    public ComMachDB getDatabase() {
        return database;
    }

    public static ArrayList<CommunalMachinery> getList(){
        return machineryList;
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