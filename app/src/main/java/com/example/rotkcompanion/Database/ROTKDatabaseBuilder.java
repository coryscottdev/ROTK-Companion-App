package com.example.rotkcompanion.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rotkcompanion.DAO.ChapterDAO;
import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.DAO.FactionDAO;
import com.example.rotkcompanion.Entities.ChapterEntity;
import com.example.rotkcompanion.Entities.CharacterEntity;
import com.example.rotkcompanion.Entities.FactionEntity;

@Database(entities = {CharacterEntity.class, ChapterEntity.class, FactionEntity.class}, version = 7, exportSchema = false)
public abstract class ROTKDatabaseBuilder extends RoomDatabase {
    public abstract CharacterDAO characterDAO();
    public abstract ChapterDAO chapterDAO();
    public abstract FactionDAO factionDAO();

    public static volatile ROTKDatabaseBuilder INSTANCE;

    static ROTKDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ROTKDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ROTKDatabaseBuilder.class, "MyCharacterDatabase.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new DatabasePopulator(context))
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
