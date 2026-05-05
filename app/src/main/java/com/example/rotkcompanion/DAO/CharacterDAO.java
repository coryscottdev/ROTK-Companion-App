package com.example.rotkcompanion.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rotkcompanion.Entities.CharacterEntity;

import java.util.List;

@Dao
public interface CharacterDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CharacterEntity character);

    @Update
    void update(CharacterEntity character);

    @Query("SELECT characterName FROM CharacterEntity ORDER BY characterName ASC")
    List<String> getmAllCharactersByNameASC();

    @Query("SELECT * FROM CharacterEntity ORDER BY characterName ASC")
    List<CharacterEntity> getmAllCharacters();

    @Query("SELECT characterName FROM CharacterEntity WHERE characterID = :charID")
    String getmCharNameByID(int charID);
}
