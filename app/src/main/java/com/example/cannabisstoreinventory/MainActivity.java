package com.example.cannabisstoreinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.example.cannabisstoreinventory.user.UserDbHelper;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDbHelper udbh= new UserDbHelper(MainActivity.this);
        idCaption();
    }

    public void launchSignIn(View view){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void launchSignUp(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void idCaption(){
        EditText user= (EditText) findViewById(R.id.editTextUser);
        EditText password= (EditText) findViewById(R.id.editTextPassword);
        Button signIn=(Button) findViewById(R.id.btnSignIn);
        TextView signUp=(TextView) findViewById(R.id.linkSignUp);


    }
}