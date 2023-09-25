package com.example.cannabisstoreinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cannabisstoreinventory.user.User;
import com.example.cannabisstoreinventory.user.UserDbHelper;

public class SignUp extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button signUp;

    private UserDbHelper udbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Vaiables
        name=findViewById(R.id.editTextName);
        password=findViewById(R.id.editTextPassword);
        signUp= findViewById(R.id.btnSignUp);

        //Initializing DB
        udbh=new UserDbHelper(SignUp.this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userPassword=password.getText().toString();

                if(userName.isEmpty()&&userPassword.isEmpty()){
                    Toast.makeText(SignUp.this,"Please enter all data",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(udbh.readNamesUsers().contains(userName)){
                    Toast.makeText(SignUp.this,"The name is not available",Toast.LENGTH_SHORT).show();
                    return;
                }

                User user= new User(userName,userPassword,1,null);

                udbh.addNewUser(user);

                Toast.makeText(SignUp.this,"User has been added.",Toast.LENGTH_SHORT).show();
                name.setText("");
                password.setText("");

            }
        });

    }


}