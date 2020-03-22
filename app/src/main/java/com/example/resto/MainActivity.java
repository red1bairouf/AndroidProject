package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resto.SQLitePackage.MyDbClasse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText login , password ;
    Button btn ;
    /*MyDbClasse objMyDbClasse;
    ArrayList<User> objUserArrayList;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*objMyDbClasse = new MyDbClasse(this);*/
        login = (EditText) findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String login1 =login.getText().toString();
                String password1 =password.getText().toString();
                objUserArrayList = objMyDbClasse.getAllDataUser();

                boolean CheckLogin = objMyDbClasse.loginCheck(login1,password1,objUserArrayList);

                if(CheckLogin){
                    myClick(view);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Les données entrées sont incorrectes",Toast.LENGTH_SHORT).show();
                }
            }*/
                myClick(view);
            }
        });
    }

    public void myClick(View view){
        Intent intent=new Intent(MainActivity.this, MyList.class);
        String login1 =login.getText().toString();
        String password1 =password.getText().toString();
        if(login1.equals("user")&&password1.equals("user"))
        startActivityForResult(intent, 2);
        else Toast.makeText(getApplicationContext(),"Les données entrées sont incorrectes",Toast.LENGTH_SHORT).show();
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
