package com.justnik.communalmachinery;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CommunalMachinery.class}, version = 2)
public abstract class ComMachDB extends RoomDatabase {
    public abstract CommunalMachineryDAO CommunalMachineryDAO();
}
