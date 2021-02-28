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
    public int photoLink;
    public String contactNumber;
    public String technicalChar;
    public String owner;


    public CommunalMachinery(String name,int price, String forEach, int photoLink,
                             String contactNumber,String owner,String technicalChar){
        this.name = name;
        this.price = price;
        this.forEach = forEach;
        this.photoLink = photoLink;
        this.contactNumber = contactNumber;
        this.technicalChar = technicalChar;
        this.owner = owner;
    }


    @NonNull
    @Override
    public String toString() {
        return typeOfMachineID+" "+ name + " " + price + " " +
                forEach + " " + photoLink + " " + contactNumber;
    }
}
