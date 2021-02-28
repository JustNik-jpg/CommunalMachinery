package com.justnik.communalmachinery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class Ordering extends Fragment {
    NavController navController;
    EditText t_name;
    EditText t_2name;
    EditText t_phone;
    EditText t_mail;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.ordering_fragment,container,false);
        navController = NavHostFragment.findNavController(this);
        init(v);
        return v;
    }

    public void init(View v){
        button =  v.findViewById(R.id.button);
        t_name =  v.findViewById(R.id.t_name);
        t_2name = v.findViewById(R.id.t_2name);
        t_phone = v.findViewById(R.id.t_phone);
        t_mail =  v.findViewById(R.id.t_mail);
    }


}