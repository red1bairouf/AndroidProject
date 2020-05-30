package com.example.restoserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.restoserver.Model.Category;
import com.example.restoserver.ViewHolder.MenuViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    TextView txtslogan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        txtslogan = findViewById(R.id.txtslogan);
    }
    public void signIn(View view) {
        Intent intent = new Intent(MainActivity.this,SignIn.class);
        startActivity(intent);
    }
}
