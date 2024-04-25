package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    TextInputEditText username,password,mobile,email;
    ImageView btn_back;
    AppCompatButton login,register;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.edt_username_1);
        password = findViewById(R.id.edt_password_1);
        email = findViewById(R.id.edt_email_1);
        mobile = findViewById(R.id.edt_phone_1);
        login = findViewById(R.id.login_1);
        register = findViewById(R.id.register_1);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper = DatabaseHelper.getdDB(Register.this);
                if(databaseHelper.userDataDao().getDataByUserName(username.getText().toString()) == null){
                    UserEntity userEntity = new UserEntity(username.getText().toString(),password.getText().toString(),
                            email.getText().toString(),mobile.getText().toString());
                    databaseHelper.userDataDao().AddData(userEntity);
                    Toast.makeText(Register.this, "Registration is Successful...", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Register.this,MainActivity.class));

                }else{
                    username.setText("");
                    password.setText("");
                    email.setText("");
                    mobile.setText("");
                    Toast.makeText(Register.this, "This Username is already exist Please use another one", Toast.LENGTH_LONG).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainActivity.class));
            }
        });

    }
}