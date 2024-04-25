package com.example.votingapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities =  {UserEntity.class,VoterEntity.class} , exportSchema = false,version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "user_db";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getdDB(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,DatabaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    public abstract UserDataDao userDataDao();
    public abstract VoterDataDao voterDataDao();
}
