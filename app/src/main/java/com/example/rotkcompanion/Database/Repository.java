package com.example.rotkcompanion.Database;

import android.app.Application;


import com.example.rotkcompanion.DAO.ChapterDAO;
import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.DAO.FactionDAO;
import com.example.rotkcompanion.Entities.ChapterEntity;
import com.example.rotkcompanion.Entities.CharacterEntity;

import java.util.List;

public class Repository {

    private static CharacterDAO mCharacterDAO;
    private static ChapterDAO mChapterDAO;
    private static FactionDAO mFactionDAO;

    private List<String> mAllCharacterNames;
    private List<CharacterEntity> mAllCharacters;

    public Repository(Application application){
        ROTKDatabaseBuilder db = ROTKDatabaseBuilder.getDatabase(application);
        mCharacterDAO = db.characterDAO();
        mChapterDAO = db.chapterDAO();
        mFactionDAO = db.factionDAO();
    }
    //CHARACTERS
    public List<String> getmAllCharactersByNameASC() {
       return mAllCharacterNames;
    }

    public List<CharacterEntity> getmAllCharacters() {
        return mCharacterDAO.getmAllCharacters();
    }

    public String getmCharacterNameByID(int charID) {
        return mCharacterDAO.getmCharNameByID(charID);
    }

    public String getmCharTitleByID(int charID) {
        return mCharacterDAO.getmCharTitleByID(charID);
    }

    //CHAPTERS
    public List<ChapterEntity> getmAllChapters() {
        return mChapterDAO.getmAllChapters();
    }

    public List<Integer> getmAllChaptersByCharacter(int charID) {
       List<Integer> chapterListByCharacter = mChapterDAO.getmAllChaptersByCharacter(charID);
       return chapterListByCharacter;
    }

    public List<Integer> getCharacterIDsByChapter(int chapterNum) {
        List<Integer> charactersByChapter = mChapterDAO.getmAllCharactersByChapter(chapterNum);
        return charactersByChapter;
    }

    //FACTIONS

    public String getmFactionNameFromID(int factionID) {
        return mFactionDAO.getmFactionNameFromID(factionID);
    }

    public String getmFactionSummaryFromID(int factionID) {
        return mFactionDAO.getmFactionSummaryFromID(factionID);
    }
}
