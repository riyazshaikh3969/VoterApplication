package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText username,password;
    AppCompatButton login,register;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        databaseHelper = DatabaseHelper.getdDB(MainActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(databaseHelper.voterDataDao().getAllData() == null){
                    VoterEntity voterEntity = new VoterEntity(0,0,0,0);
                    databaseHelper.voterDataDao().AddData(voterEntity);
                }
                UserEntity userEntity = databaseHelper.userDataDao().getDataByUserName(username.getText().toString());
               if(userEntity != null && userEntity.getPassword().equals(password.getText().toString())){
                   String pass = databaseHelper.userDataDao().getDataByUserName(username.getText().toString()).getPassword();
                   if(pass.equals((password.getText().toString()))){
                       if(username.getText().toString().equals("riyazshaikh3969")){
                           startActivity(new Intent(MainActivity.this, VotingResults.class));
                           Toast.makeText(MainActivity.this, "Admin has logged in... ", Toast.LENGTH_LONG).show();
                           username.setText("");
                           password.setText("");

                       }else if(databaseHelper.userDataDao().getDataByUserName(username.getText().toString()).getVoteCount() == 0){
                           databaseHelper.userDataDao().updateDataByUsername(username.getText().toString());
                           startActivity(new Intent(MainActivity.this, Voting.class));
                           username.setText("");
                           password.setText("");
                       }else {
                           Toast.makeText(MainActivity.this, "Already Voted ", Toast.LENGTH_LONG).show();
                       }

                   }
               }else{
                   Toast.makeText(MainActivity.this, "Invalid UserName or Password ", Toast.LENGTH_LONG).show();
               }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }
}