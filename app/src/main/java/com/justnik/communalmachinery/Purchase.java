package com.justnik.communalmachinery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class Purchase extends Fragment {
  NavController navController;
    Button btPurchase;
    Button btCall;
    ImageView image;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.purchase_fragment,container,false);
        navController = NavHostFragment.findNavController(this);
        init(v);
        return v;
    }

    public void init(View v){
        btPurchase = v.findViewById(R.id.b_purchase);
        btCall = v.findViewById(R.id.b_phone);

        btPurchase.setOnClickListener(s -> {
                    Log.d("test","work");
                    navController.navigate(R.id.ordering);
                }
        );
        btCall.setOnClickListener(s -> {
            Log.d("test", "work");
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "123456789", null)));
        });

        image = v.findViewById(R.id.imgVehicle);
        image.setImageResource(R.drawable.traktor);

    }

}
