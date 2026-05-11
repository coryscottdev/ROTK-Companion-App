package com.example.rotkcompanion.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rotkcompanion.Entities.CharacterEntity;
import com.example.rotkcompanion.Entities.FactionEntity;

import java.util.List;

@Dao
public interface FactionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FactionEntity faction);

    @Update
    void update(FactionEntity faction);

    @Query("SELECT factionName from FactionEntity WHERE factionID = :factionID")
    String getmFactionNameFromID(int factionID);

    @Query("SELECT factionSummary from FactionEntity WHERE factionID = :factionID")
    String getmFactionSummaryFromID(int factionID);
}
