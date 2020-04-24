package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.widget.Toast;

import com.example.resto.SQLitePackage.MyDbClasse;

import java.util.ArrayList;

public class MyList extends AppCompatActivity {

    MyDbClasse objMyDbClasse;
    ArrayList<Produit> objProduitArrayList;
    RecyclerView rv ;
    Button btn,btn2 ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);

        objMyDbClasse = new MyDbClasse(this);
        objProduitArrayList = new ArrayList<>();
        rv = (RecyclerView) findViewById(R.id.list);
        btn = (Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       myClick(view);
                                   }
        });
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick2(view);
            }
        });
        showData();
    }

    public void myClick(View view){
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
    public void myClick2(View view){
        int intValue = objMyDbClasse.lastId();
        boolean insert = objMyDbClasse.cmd(objProduitArrayList);
        Intent intent=new Intent(MyList.this, ReceiptActivity.class);
        intent.putExtra("intVariableName", intValue);
        startActivityForResult(intent, 2);
    }
    public void showData(){
        try{
            objProduitArrayList=objMyDbClasse.getAllData();
            MyAdapter objAdapter = new MyAdapter(objProduitArrayList);

            rv.hasFixedSize();
            rv.setLayoutManager(new LinearLayoutManager(this));

            rv.setAdapter(objAdapter);
        }
        catch(Exception e){
            Toast.makeText(this,"showData:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
        }
    }
}

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(),layoutManager.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        rv.setAdapter(new MyAdapter());
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1: Toast.makeText(this, "à propos",
                    Toast.LENGTH_LONG).show(); break;
        }
        return super.onOptionsItemSelected(item);
    }
  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==4)
        {
            Log.i("tagX","msgX");

        }
    }


}
*/