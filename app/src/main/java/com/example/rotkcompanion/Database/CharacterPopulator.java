package com.example.rotkcompanion.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.Entities.CharacterEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CharacterPopulator extends RoomDatabase.Callback {

    private final Context context;

    public CharacterPopulator(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        populateDatabase();
    }

    @Override
    public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
        super.onDestructiveMigration(db);
        populateDatabase();
    }

    private void populateDatabase() {
        new Thread(() -> {
            CharacterDatabaseBuilder characterDatabaseBuilder = CharacterDatabaseBuilder.getDatabase(context);
            CharacterDAO characterDAO = characterDatabaseBuilder.characterDAO();
            for (CharacterEntity myChosenCharacter : charactersList()) {
                characterDAO.insert(myChosenCharacter);
            }
        }).start();
    }

    //TODO add boolean "hasNickname"
    private List<CharacterEntity> charactersList() {
        List<CharacterEntity> characters = new ArrayList<>();
        characters.add(new CharacterEntity(1, "Character1"));
        characters.add(new CharacterEntity(2, "Character2"));
        characters.add(new CharacterEntity(3, "Character3"));
        characters.add(new CharacterEntity(4, "Character4"));
        return characters;
    }
}