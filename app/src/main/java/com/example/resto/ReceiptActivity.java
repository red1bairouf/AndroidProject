package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resto.SQLitePackage.MyDbClasse;

import java.util.ArrayList;

public class ReceiptActivity extends AppCompatActivity {
    MyDbClasse objMyDbClasse;
    ArrayList<Commande> objcommandeArrayList;
    RecyclerView rv ;
    Button btn;
    TextView totqte,totalPr;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt);
        objMyDbClasse = new MyDbClasse(this);
        rv = (RecyclerView) findViewById(R.id.listcmd);
        totqte = (TextView) findViewById(R.id.totqte);
        totalPr = (TextView) findViewById(R.id.totalPr);
        btn = (Button)findViewById(R.id.buttonrec);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick(view);
            }
        });
        showData();
    }
    public void myClick(View view){
        Intent intent=new Intent(ReceiptActivity.this, MyList.class);
        startActivityForResult(intent, 2);
    }
    public void showData(){
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        try{
            if(intValue<0)Toast.makeText(this,"ERROR", Toast.LENGTH_SHORT).show();
            else {
                objcommandeArrayList = objMyDbClasse.getAllDataCmd(intValue);
                MyAdapterCmd objAdapter = new MyAdapterCmd(objcommandeArrayList);

                rv.hasFixedSize();
                rv.setLayoutManager(new LinearLayoutManager(this));

                rv.setAdapter(objAdapter);
                totqte.setText(Integer.toString(objMyDbClasse.qteTot(objcommandeArrayList)));
                totalPr.setText(Float.toString(objMyDbClasse.prixTot(objcommandeArrayList)));

            }
        }
        catch(Exception e){
            Toast.makeText(this,"showData:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
