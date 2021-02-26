package com.justnik.communalmachinery;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CommunalMachinery.class}, version = 1)
public abstract class ComMachDB extends RoomDatabase {
    public abstract CommunalMachineryDAO CommunalMachineryDAO();
}
