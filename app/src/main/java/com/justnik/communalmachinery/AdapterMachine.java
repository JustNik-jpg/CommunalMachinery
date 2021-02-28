package com.justnik.communalmachinery;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMachine extends RecyclerView.Adapter<AdapterMachine.MachineViewHolder> {
    NavController navController;
    private Context context;


    public static class MachineViewHolder extends RecyclerView.ViewHolder{

        TextView nameMachine;
        TextView price;
        TextView contact;
        TextView markPrice;
        ImageView photoMachine;

        TextView queryButton;

        public MachineViewHolder(@NonNull View itemView, NavController navController) {
            super(itemView);

            nameMachine = itemView.findViewById(R.id.name_machine);
            price = itemView.findViewById(R.id.price);
            contact = itemView.findViewById(R.id.contact);
            markPrice = itemView.findViewById(R.id.markPrice);

            photoMachine = itemView.findViewById(R.id.machine_photo);

            queryButton = itemView.findViewById(R.id.button_text);

            queryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(R.id.purchase);
                }
            });
        }
    }

    List<CommunalMachinery> machineList;

    public AdapterMachine(List<CommunalMachinery> machines, Context context, NavController controller){
        this.context = context;
        this.navController = controller;
        this.machineList = machines;
    }

    @NonNull
    @Override
    public MachineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

       MachineViewHolder machineViewHolder = new MachineViewHolder(v, navController);

        return machineViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MachineViewHolder holder, int position) {
    holder.nameMachine.setText(machineList.get(position).name);
    holder.price.setText(String.valueOf(machineList.get(position).price));
    holder.contact.setText(machineList.get(position).contactNumber);
    holder.markPrice.setText(machineList.get(position).forEach);
        Picasso.with(context)
                .load(Uri.parse(machineList.get(position).photoLink))
                .resize(220,155)
                .centerCrop()
                .into(holder.photoMachine);



    }

    @Override
    public int getItemCount() {
        return machineList.size();
    }


}
