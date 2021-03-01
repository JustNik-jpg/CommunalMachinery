package com.justnik.communalmachinery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Detail extends Activity {

  private Button ordering;
  private TextView nameVehicle;
  private TextView number;
  private TextView technicalChar;
  private TextView owner;
  private ImageView image;
  private List<CommunalMachinery> list;
  private TextView idMachine;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.detail_activity);

        init();

        Bundle arguments = getIntent().getExtras();
        CommunalMachinery communalMachinery = list.get(arguments.getInt("index"));
        nameVehicle.setText(communalMachinery.name);
        number.setText(communalMachinery.contactNumber);
        number.setPaintFlags(number.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        number.setOnClickListener(event->startActivity(new Intent(Intent.ACTION_DIAL,
                Uri.fromParts("tel", communalMachinery.contactNumber, null)))
        );

        technicalChar.setText(communalMachinery.technicalChar);
        owner.setText(communalMachinery.owner);
       // idMachine.setText(communalMachinery.typeOfMachineID);
        image.setImageResource(communalMachinery.photoLink);
    }

    private void init(){
        list = CommunalMachineryAdapter.machineList;
        ordering = findViewById(R.id.btOrdering);
        nameVehicle = findViewById(R.id.nameVehicle);
        number = findViewById(R.id.number);
        image = findViewById(R.id.image);
        technicalChar = findViewById(R.id.definition);
        owner = findViewById(R.id.owner);
        idMachine = findViewById(R.id.idMachine);
    }

}
