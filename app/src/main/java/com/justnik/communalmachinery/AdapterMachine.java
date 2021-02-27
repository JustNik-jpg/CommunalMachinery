package com.justnik.communalmachinery;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMachine extends RecyclerView.Adapter<AdapterMachine.MachineViewHolder> {

    public static class MachineViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nameMachine;
        TextView price;
        TextView contact;
        ImageView photoMachine;

        public MachineViewHolder(@NonNull View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv);

            nameMachine = itemView.findViewById(R.id.name_machine);
            price = itemView.findViewById(R.id.price);
            contact = itemView.findViewById(R.id.contact);

            photoMachine = itemView.findViewById(R.id.machine_photo);

        }
    }

    List<CommunalMachinery> machineList;

    public AdapterMachine(List<CommunalMachinery> machines){
        this.machineList = machines;
    }

    @NonNull
    @Override
    public MachineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

       MachineViewHolder machineViewHolder = new MachineViewHolder(v);

        return machineViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MachineViewHolder holder, int position) {
    holder.nameMachine.setText(machineList.get(position).name);
    holder.price.setText(String.valueOf(machineList.get(position).price));
    holder.contact.setText(machineList.get(position).contactNumber);
//        Picasso.get()
//                .load(Uri.parse(machineList.get(position).photoLink))
//                .into(holder.photoMachine);



    }

    @Override
    public int getItemCount() {
        return machineList.size();
    }


}
