package com.example.votingapp;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "voterdata")
public class VoterEntity{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "candidate_1")
    private int candidate_1;

    @ColumnInfo(name = "candidate_2")
    private int candidate_2;

    @ColumnInfo(name = "candidate_3")
    private int candidate_3;

    @ColumnInfo(name = "candidate_4")
    private int candidate_4;

    public VoterEntity(int candidate_1, int candidate_2, int candidate_3, int candidate_4) {
        this.candidate_1 = candidate_1;
        this.candidate_2 = candidate_2;
        this.candidate_3 = candidate_3;
        this.candidate_4 = candidate_4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidate_1() {
        return candidate_1;
    }

    public void setCandidate_1(int candidate_1) {
        this.candidate_1 = candidate_1;
    }

    public int getCandidate_2() {
        return candidate_2;
    }

    public void setCandidate_2(int candidate_2) {
        this.candidate_2 = candidate_2;
    }

    public int getCandidate_3() {
        return candidate_3;
    }

    public void setCandidate_3(int candidate_3) {
        this.candidate_3 = candidate_3;
    }

    public int getCandidate_4() {
        return candidate_4;
    }

    public void setCandidate_4(int candidate_4) {
        this.candidate_4 = candidate_4;
    }
}
