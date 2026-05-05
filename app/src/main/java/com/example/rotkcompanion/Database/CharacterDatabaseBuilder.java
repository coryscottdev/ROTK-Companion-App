package com.example.rotkcompanion.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.Entities.CharacterEntity;

@Database(entities = {CharacterEntity.class}, version = 2, exportSchema = false)
public abstract class CharacterDatabaseBuilder extends RoomDatabase {
    public abstract CharacterDAO characterDAO();

    public static volatile CharacterDatabaseBuilder INSTANCE;

    static CharacterDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CharacterDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CharacterDatabaseBuilder.class, "MyCharacterDatabase.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new CharacterPopulator(context))
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
