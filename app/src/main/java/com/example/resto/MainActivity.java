package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resto.SQLitePackage.MyDbClasse;
import com.example.resto.bd.User;
import com.example.resto.bd.UsrDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static User user= new User();
    EditText login , password ;
    Button btn ;
    static UsrDatabase mydatabase;
    private TextView Text;
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
    @SuppressLint("CutPasteId")
    public void myClick(View v) {
        btn = this.findViewById(R.id.button1);
        login = this.findViewById(R.id.editText1);
        password =  this.findViewById(R.id.editText);
        Text =  this.findViewById(R.id.textView4);
        mydatabase = Room.databaseBuilder(getApplicationContext(),UsrDatabase.class, "user_bd").allowMainThreadQueries().build() ;


        user.nom = login.getText().toString();
        user.mdp = password.getText().toString();
        if ( !(login.getText().toString()).matches("")) {
            List<User> usr = MainActivity.mydatabase.mydao().getUser(login.getText().toString());
            switch (v.getId()) {
                case R.id.textView4:
                    if (usr.size() != 0) {

                        Toast.makeText(getApplicationContext(), "Impossible de créer le compte: login existant", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        MainActivity.mydatabase.mydao().adduser(user);
                        Toast.makeText(getApplicationContext(), "Parfait le compte est créé", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.button1:
                    if (usr.size() != 0) {
                        if (usr.get(0).mdp.contentEquals(password.getText().toString()) ) {
                            Intent intent = new Intent(this, MyList.class);
                            startActivity(intent);
                            break;
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Compte non existant", Toast.LENGTH_SHORT).show();
                        break;
                    }}}}



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
        }
    }
}
