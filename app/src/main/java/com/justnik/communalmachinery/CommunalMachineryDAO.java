package com.justnik.communalmachinery;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CommunalMachineryDAO {
    @Query("SELECT * FROM CommunalMachinery")
    List<CommunalMachinery> getAll();

    @Query("SELECT * FROM CommunalMachinery WHERE :typeOfMachineID = typeOfMachineID")
    CommunalMachinery getMachineByID(int typeOfMachineID);

    @Query("SELECT COUNT(typeOfMachineID) FROM CommunalMachinery")
    int getRowCount();

    @Insert
    void insertAll(CommunalMachinery... communalMachineries);

    @Delete
    void delete(CommunalMachinery communalMachinery);

}
