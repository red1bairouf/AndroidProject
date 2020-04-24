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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<Produit> objProduitArrayList;
    public MyAdapter(ArrayList<Produit> objProduitArrayList){
        this.objProduitArrayList=objProduitArrayList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View singleRow= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item,viewGroup,false);
        return new MyViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Produit objProduit=objProduitArrayList.get(i);
        System.out.println("Vname =" + objProduit.getName());
        System.out.println("position=" + i);
        holder.display(objProduit);
    }

    @Override
    public int getItemCount() {
        return objProduitArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView ref;
        private TextView name;
        private TextView prix;
        private Button buttonI;
        private Button buttonD;
        private Produit currentProd;
        private TextView qtee;
        private int qte = 0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ref = itemView.findViewById(R.id.textView7);
            name = itemView.findViewById(R.id.textView8);
            qtee = itemView.findViewById(R.id.textView10);
            prix = itemView.findViewById(R.id.textView9);
            buttonI = itemView.findViewById(R.id.buttonInc);
            buttonD = itemView.findViewById(R.id.buttonDec);

            buttonI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qte=currentProd.getQte();
                    qte=qte+1;
                    currentProd.setQte(qte);
                    qtee.setText(Integer.toString(currentProd.getQte()));
                    notifyItemChanged(getPosition());
                }
            });
            buttonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentProd.getQte()>0){
                        qte=currentProd.getQte();
                        qte=qte-1;
                        currentProd.setQte(qte);
                        qtee.setText(Integer.toString(currentProd.getQte()));
                        notifyItemChanged(getPosition());
                    }
                }
            });
        }
        public void display(Produit Prod) {
            currentProd = Prod;
            name.setText(Prod.getName());
            ref.setText(Prod.getRef());
            prix.setText(Double.toString(Prod.getPrix()));
            qtee.setText(Integer.toString(Prod.getQte()));

        }
    }
}

/*
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public ArrayList Produit = new ArrayList<>(Arrays.asList(
    ));

    @Override
    public int getItemCount() {
        return Produit.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Produit Prod = (Produit) Produit.get(position);
        System.out.println("Vname =" + Prod.getName());
        System.out.println("position=" + position);
        holder.display(Prod);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView ref;
        private TextView name;
        private TextView prix;
        private Button buttonI;
        private Button buttonD;
        private Produit currentProd;
        private TextView qtee;
        private int qte = 0;
        public MyViewHolder(final View itemView) {
            super(itemView);

            ref = itemView.findViewById(R.id.textView7);
            name = itemView.findViewById(R.id.textView8);
            qtee = itemView.findViewById(R.id.textView10);
            prix = itemView.findViewById(R.id.textView9);
            buttonI = itemView.findViewById(R.id.buttonInc);
            buttonD = itemView.findViewById(R.id.buttonDec);


            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentEtab.getLabel())
                            .show();
                }
            });*/
           /* buttonI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qte=currentProd.getQte();
                    qte=qte+1;
                    currentProd.setQte(qte);
                    qtee.setText(Integer.toString(currentProd.getQte()));
                    notifyItemChanged(getPosition());
                }
            });
            buttonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentProd.getQte()>0){
                        qte=currentProd.getQte();
                        qte=qte-1;
                        currentProd.setQte(qte);
                        qtee.setText(Integer.toString(currentProd.getQte()));
                        notifyItemChanged(getPosition());
                    }
                }
            });
        }
        public void display(Produit Prod) {
            currentProd = Prod;
            name.setText(Prod.getName());
            ref.setText(Prod.getRef());
            prix.setText(Double.toString(Prod.getPrix()));
            qtee.setText(Integer.toString(Prod.getQte()));

        }
    }
}
*/