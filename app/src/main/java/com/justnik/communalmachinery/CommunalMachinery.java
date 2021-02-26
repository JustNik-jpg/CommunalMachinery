package com.justnik.communalmachinery;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CommunalMachinery {

    @PrimaryKey(autoGenerate = true)
    public int typeOfMachineID;

    public int price;
    public String forEach;
    public String photoLink;
    public String contactNumber;


    public CommunalMachinery(int typeOfMachineID, int price, String forEach, String photoLink,
                             String contactNumber){
        this.typeOfMachineID = typeOfMachineID;
        this.price = price;
        this.forEach = forEach;
        this.photoLink = photoLink;
        this.contactNumber = contactNumber;

    }


    @NonNull
    @Override
    public String toString() {
        return typeOfMachineID + " " + price + " " +
                forEach + " " + photoLink + " " + contactNumber;
    }
}
