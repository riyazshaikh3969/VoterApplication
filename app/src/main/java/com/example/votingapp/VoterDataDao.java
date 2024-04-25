package com.example.votingapp;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface VoterDataDao {
//
    @Query("select * from voterdata")
    VoterEntity getAllData();


    @Query("UPDATE voterdata SET candidate_1 = :data")
    void updateDataByCandidate_1(int data);

    @Query("UPDATE voterdata SET candidate_2 = :data")
    void updateDataByCandidate_2(int data);
    @Query("UPDATE voterdata SET candidate_3 = :data")
    void updateDataByCandidate_3(int data);
    @Query("UPDATE voterdata SET candidate_4 = :data")
    void updateDataByCandidate_4(int data);
    @Insert
    void AddData(VoterEntity voterEntity);


}
