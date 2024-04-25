package com.example.votingapp;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDataDao {

    @Query("select * from UserData")
    UserEntity getAllData();

    @Query("select * from UserData where Username = :user")
    UserEntity getDataByUserName(String user);

    @Query("UPDATE UserData SET voteCount = 1 where username = :user ")
    void updateDataByUsername(String user);
    @Insert
    void AddData(UserEntity userEntity);


    @Update
    void UpdateData(UserEntity userEntity);


}
