package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Voting extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton candidate_1,candidate_2,candidate_3,candidate_4;
    AppCompatButton submit;

    ImageView btn_back;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);


        radioGroup = findViewById(R.id.radio_group);
        submit = findViewById(R.id.submit);
        candidate_1 = findViewById(R.id.candidate_1);
        candidate_2 = findViewById(R.id.candidate_2);
        candidate_3 = findViewById(R.id.candidate_3);
        candidate_4 = findViewById(R.id.candidate_4);
        btn_back = findViewById(R.id.btn_back_nav);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        databaseHelper = DatabaseHelper.getdDB(Voting.this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(radioGroup.getCheckedRadioButtonId() == R.id.candidate_1){
                   int val = databaseHelper.voterDataDao().getAllData().getCandidate_1()+1;
                   databaseHelper.voterDataDao().updateDataByCandidate_1(val);
                   Toast.makeText(Voting.this, "Vote is done ...", Toast.LENGTH_LONG).show();
                   startActivity(new Intent(Voting.this,MainActivity.class));
               }else if(radioGroup.getCheckedRadioButtonId() == R.id.candidate_2){
                   int val = databaseHelper.voterDataDao().getAllData().getCandidate_2()+1;
                   databaseHelper.voterDataDao().updateDataByCandidate_2(val);
                   Toast.makeText(Voting.this, "Vote is done ...", Toast.LENGTH_LONG).show();
                   startActivity(new Intent(Voting.this,MainActivity.class));
               }else if(radioGroup.getCheckedRadioButtonId() == R.id.candidate_3){
                   int val = databaseHelper.voterDataDao().getAllData().getCandidate_3()+1;
                   databaseHelper.voterDataDao().updateDataByCandidate_3(val);
                   Toast.makeText(Voting.this, "Vote is done ...", Toast.LENGTH_LONG).show();
                   startActivity(new Intent(Voting.this,MainActivity.class));
               }else if(radioGroup.getCheckedRadioButtonId() == R.id.candidate_4){
                   int val = databaseHelper.voterDataDao().getAllData().getCandidate_4()+1;
                   databaseHelper.voterDataDao().updateDataByCandidate_4(val);
                   Toast.makeText(Voting.this, "Vote is done ...", Toast.LENGTH_LONG).show();
                   startActivity(new Intent(Voting.this,MainActivity.class));

               }

            }
        });
    }
}