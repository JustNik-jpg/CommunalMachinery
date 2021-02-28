package com.justnik.communalmachinery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class CommunalMachineryAdapter extends RecyclerView.Adapter<CommunalMachineryAdapter.MachineViewHolder> {

    List<CommunalMachinery> machineList;
    private final OnMachineClickListener onClickListener;

    public CommunalMachineryAdapter(List<CommunalMachinery> list, OnMachineClickListener onClickListener) {
        this.machineList = list;
        this.onClickListener = onClickListener;
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
        holder.photoMachine.setImageResource(R.drawable.traktor);
        holder.itemView.setOnClickListener(v -> onClickListener.onMachineClick(machineList.get(position)));
    }

    @Override
    public int getItemCount() {

        return machineList.size();
    }


    public static class MachineViewHolder extends RecyclerView.ViewHolder {
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

    interface OnMachineClickListener {
        void onMachineClick(CommunalMachinery cm);
    }

}
