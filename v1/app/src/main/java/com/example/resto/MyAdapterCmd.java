package com.example.resto;


import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

public class MyAdapterCmd extends RecyclerView.Adapter<MyAdapterCmd.MyViewHolder> {
    ArrayList<Commande> objcommandeArrayList;
    public MyAdapterCmd(ArrayList<Commande> objcommandeArrayList){
        this.objcommandeArrayList=objcommandeArrayList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View singleRow= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.receiptitem,viewGroup,false);
        return new MyViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Commande objCommande=objcommandeArrayList.get(i);
        System.out.println("Vname =" + objCommande.getName());
        System.out.println("position=" + i);
        holder.display(objCommande);
    }

    @Override
    public int getItemCount() {
        return objcommandeArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView rci7;
        private TextView rci8;
        private TextView rci9;
        private Commande currentCmd;
        private TextView tot;
        private int total = 0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            rci7 = itemView.findViewById(R.id.rci7);
            rci8 = itemView.findViewById(R.id.rci8);
            rci9 = itemView.findViewById(R.id.rci9);

        }
        public void display(Commande Cmd) {
            currentCmd = Cmd;
            rci8.setText(Cmd.getName());
            rci9.setText(Integer.toString(Cmd.getQuantite()));
            rci7.setText(Float.toString(Cmd.getPrix()));

        }
    }
}
