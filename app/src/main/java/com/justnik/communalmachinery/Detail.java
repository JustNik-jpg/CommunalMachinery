package com.justnik.communalmachinery;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends Activity {

  private Button ordering;
  private TextView nameVehicle;
  private TextView number;
  private TextView technicalChar;
  private ImageView image;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.detail_activity);

        ordering = findViewById(R.id.btOrdering);
        nameVehicle = findViewById(R.id.nameVehicle);
        number = findViewById(R.id.number);
        number.setOnClickListener(event->startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "123456789", null)))
);
        technicalChar = findViewById(R.id.definition);
        image = findViewById(R.id.image);
        image.setImageResource(R.drawable.traktor);
    }

}
