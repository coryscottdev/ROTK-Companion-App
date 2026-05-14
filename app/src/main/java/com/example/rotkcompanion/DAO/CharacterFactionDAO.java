package com.example.rotkcompanion.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rotkcompanion.Entities.CharacterFactionEntity;
import com.example.rotkcompanion.Entities.FactionEntity;

import java.util.List;

@Dao
public interface CharacterFactionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CharacterFactionEntity characterFaction);

    @Update
    void update(CharacterFactionEntity characterFaction);

    @Query("SELECT factionID FROM CharacterFactionEntity WHERE characterID = :charID")
    List<Integer> getmAllFactionIDsByCharacter(int charID);

    @Query("SELECT factionID FROM CharacterFactionEntity WHERE isCurrent = 1 AND characterID =:charID")
    List<Integer> getmCurrentFactionIDsByCharacter(int charID);
}
