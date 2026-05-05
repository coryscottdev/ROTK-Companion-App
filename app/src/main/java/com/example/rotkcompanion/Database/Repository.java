package com.example.rotkcompanion.Database;

import android.app.Application;



import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.Entities.CharacterEntity;

import java.util.List;

public class Repository {

    private static CharacterDAO mCharacterDAO;

    private List<String> mAllCharacterNames;
    private List<CharacterEntity> mAllCharacters;

    public Repository(Application application){
        CharacterDatabaseBuilder db = CharacterDatabaseBuilder.getDatabase(application);
        mCharacterDAO = db.characterDAO();
    }
    public List<String> getmAllCharactersByNameASC() {
       return mAllCharacterNames;
    }

    public List<CharacterEntity> getmAllCharacters() {
        return mCharacterDAO.getmAllCharacters();
    }

    public String getmCharacterNameByID(int charID) {
        return mCharacterDAO.getmCharNameByID(charID);
    }

}
