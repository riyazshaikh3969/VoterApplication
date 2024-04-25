package com.example.votingapp;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static MySharedPreferences instance;
    private final SharedPreferences sharedPreferences;


    private MySharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
    }

    public static MySharedPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new MySharedPreferences(context);
            updateTable();
        }
        return instance;
    }
    private static void updateTable(){
       SharedPreferences.Editor editor =  instance.getSharedPreferences().edit();
       editor.putInt("candidate_1",0);
       editor.putInt("candidate_2",0);
       editor.putInt("candidate_3",0);
       editor.putInt("candidate_4",0);
       editor.apply();
    }
    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
