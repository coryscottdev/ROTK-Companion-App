package com.example.rotkcompanion.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rotkcompanion.Entities.ChapterEntity;

import java.util.List;
@Dao
public interface ChapterDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ChapterEntity chapter);

    @Update
    void update(ChapterEntity chapter);

    @Query("SELECT chapterNum FROM ChapterEntity WHERE characterID = :charID")
    List<Integer> getmAllChaptersByCharacter(int charID);

    @Query("SELECT * FROM ChapterEntity")
    List<ChapterEntity> getmAllChapters();

    @Query("SELECT characterID FROM ChapterEntity WHERE chapterNum = :chapterNum ORDER BY characterAppearanceOrder ASC")
    List<Integer> getmAllCharactersByChapter(int chapterNum);
}
