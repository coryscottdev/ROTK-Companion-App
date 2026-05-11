package com.example.rotkcompanion.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.rotkcompanion.DAO.ChapterDAO;
import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.DAO.FactionDAO;
import com.example.rotkcompanion.Entities.ChapterEntity;
import com.example.rotkcompanion.Entities.CharacterEntity;
import com.example.rotkcompanion.Entities.FactionEntity;

import java.util.ArrayList;
import java.util.List;

public class DatabasePopulator extends RoomDatabase.Callback {

    private final Context context;

    public DatabasePopulator(Context context) {
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
            ROTKDatabaseBuilder ROTKDatabaseBuilder = com.example.rotkcompanion.Database.ROTKDatabaseBuilder.getDatabase(context);

            CharacterDAO characterDAO = ROTKDatabaseBuilder.characterDAO();
            ChapterDAO chapterDAO = ROTKDatabaseBuilder.chapterDAO();
            FactionDAO factionDAO = ROTKDatabaseBuilder.factionDAO();

            for (CharacterEntity myChosenCharacter : charactersList()) {
                characterDAO.insert(myChosenCharacter);
            }
            for (ChapterEntity myChosenChapter : chaptersList()) {
                chapterDAO.insert(myChosenChapter);
            }

            for (FactionEntity myChosenFaction: factionsList()) {
                factionDAO.insert(myChosenFaction);
            }

        }).start();
    }

    //CHAPTERS
    private List<ChapterEntity> chaptersList() {
        List<ChapterEntity> chapters = new ArrayList<>();
        //1
        chapters.add(new ChapterEntity(1, 1, 1));
        chapters.add(new ChapterEntity(1, 2, 2));
        chapters.add(new ChapterEntity(1, 3, 3));
        chapters.add(new ChapterEntity(1, 4, 4));
        chapters.add(new ChapterEntity(1, 4, 5));

        return chapters;
    }


    //CHARACTERS
    private List<CharacterEntity> charactersList() {
        List<CharacterEntity> characters = new ArrayList<>();
        characters.add(new CharacterEntity(1, "Supreme Ancestor"));
        characters.add(new CharacterEntity(2, "Guang Wu")); //Emperor
        characters.add(new CharacterEntity(3, "Xian"));
        characters.add(new CharacterEntity(4, "Huang"));
        characters.add(new CharacterEntity(5, "Ling"));
        return characters;
    }

    //FACTIONS

    private List<FactionEntity> factionsList() {
        List<FactionEntity> factions = new ArrayList<>();
        factions.add(new FactionEntity(1, "Zhou Dynasty", "Coming Soon"));
        factions.add(new FactionEntity(2, "Qin", "Coming Soon"));
        factions.add(new FactionEntity(3, "Chu", "Coming Soon"));
        factions.add(new FactionEntity(4, "Han", "Coming Soon"));


        return factions;
    }
}