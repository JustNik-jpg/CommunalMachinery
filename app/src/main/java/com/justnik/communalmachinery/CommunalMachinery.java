package com.justnik.communalmachinery;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CommunalMachinery {

    @PrimaryKey(autoGenerate = true)
    public int typeOfMachineID;

    public String name;
    public int price;
    public String forEach;
    public String photoLink;
    public String contactNumber;


    public CommunalMachinery(String name,int price, String forEach, String photoLink,
                             String contactNumber){
        this.name = name;
        this.price = price;
        this.forEach = forEach;
        this.photoLink = photoLink;
        this.contactNumber = contactNumber;

    }


    @NonNull
    @Override
    public String toString() {
        return typeOfMachineID+" "+ name + " " + price + " " +
                forEach + " " + photoLink + " " + contactNumber;
    }
}
