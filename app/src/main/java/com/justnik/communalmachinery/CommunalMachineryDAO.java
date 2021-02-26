package com.justnik.communalmachinery;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommunalMachineryDAO {
    @Query("SELECT * FROM CommunalMachinery")
    List<CommunalMachinery> getAll();

    @Insert
    void insertAll(CommunalMachinery... communalMachineries);

    @Delete
    void delete(CommunalMachinery communalMachinery);
}
