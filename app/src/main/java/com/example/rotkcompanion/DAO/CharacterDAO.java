package com.example.rotkcompanion.DAO;

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

    @Query("SELECT characterName FROM CharacterEntity WHERE characterID = :charID ORDER BY characterName ASC")
    String getmCharactersByNameASC(int charID);

    @Query("SELECT * FROM CharacterEntity ORDER BY characterName ASC")
    List<CharacterEntity> getmAllCharacters();

    @Query("SELECT characterName FROM CharacterEntity WHERE characterID = :charID")
    String getmCharNameByID(int charID);

    @Query("SELECT characterTitle FROM CharacterEntity WHERE characterID = :charID")
    String getmCharTitleByID(int charID);

    @Query("SELECT styleName FROM CharacterEntity WHERE characterID = :charID")
    String getmCharStyleName(int charID);

}
