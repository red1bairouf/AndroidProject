package com.ensias.ProjetAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSignIn , btnSignUp ;
    TextView slogantxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        slogantxt = (TextView) findViewById(R.id.txtslogan);
        Typeface face = Typeface.createFromAsset(getAssets() , "fonts/NABILA.TTF");
        slogantxt.setTypeface(face);
    }

   public void signUp(View view) {
        Intent intent = new Intent(MainActivity.this,SignUp.class);
        startActivity(intent);
    }

    public void signIn(View view) {
        Intent intent = new Intent(MainActivity.this,SignIn.class);
        startActivity(intent);
    }
}
