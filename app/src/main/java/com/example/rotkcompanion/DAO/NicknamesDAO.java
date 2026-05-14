package com.example.rotkcompanion.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rotkcompanion.Entities.ChapterEntity;
import com.example.rotkcompanion.Entities.NicknamesEntity;

import java.util.List;

@Dao
public interface NicknamesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(NicknamesEntity nicknamesEntity);

    @Update
    void update(NicknamesEntity nicknamesEntity);

    @Query("SELECT nickname FROM NicknamesEntity WHERE characterID = :charID")
    List<String> getmAllCharacterNicknames(int charID);
}
