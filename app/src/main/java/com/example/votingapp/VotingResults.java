package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VotingResults extends AppCompatActivity {
TextView res_1,res_2,res_3,res_4;
    ImageView btn_back;

DatabaseHelper databaseHelper ;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_results);

        databaseHelper = DatabaseHelper.getdDB(this);

        res_1 = findViewById(R.id.res_1);
        res_2 = findViewById(R.id.res_2);
        res_3 = findViewById(R.id.res_3);
        res_4 = findViewById(R.id.res_4);
        btn_back = findViewById(R.id.back_btn_1);
        btn_back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });

        res_1.setText(String.valueOf(databaseHelper.voterDataDao().getAllData().getCandidate_1()));
        res_2.setText(String.valueOf(databaseHelper.voterDataDao().getAllData().getCandidate_2()));
        res_3.setText(String.valueOf(databaseHelper.voterDataDao().getAllData().getCandidate_3()));
        res_4.setText(String.valueOf(databaseHelper.voterDataDao().getAllData().getCandidate_4()));

    }
}