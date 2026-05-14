package com.example.rotkcompanion.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.rotkcompanion.DAO.ChapterDAO;
import com.example.rotkcompanion.DAO.CharacterDAO;
import com.example.rotkcompanion.DAO.CharacterFactionDAO;
import com.example.rotkcompanion.DAO.FactionDAO;
import com.example.rotkcompanion.DAO.NicknamesDAO;
import com.example.rotkcompanion.Entities.ChapterEntity;
import com.example.rotkcompanion.Entities.CharacterEntity;
import com.example.rotkcompanion.Entities.CharacterFactionEntity;
import com.example.rotkcompanion.Entities.FactionEntity;
import com.example.rotkcompanion.Entities.NicknamesEntity;

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
            CharacterFactionDAO characterFactionDAO = ROTKDatabaseBuilder.characterFactionDAO();
            NicknamesDAO nicknamesDAO = ROTKDatabaseBuilder.nicknamesDAO();

            for (CharacterEntity myChosenCharacter : charactersList()) {
                characterDAO.insert(myChosenCharacter);
            }
            for (ChapterEntity myChosenChapter : chaptersList()) {
                chapterDAO.insert(myChosenChapter);
            }

            for (FactionEntity myChosenFaction: factionsList()) {
                factionDAO.insert(myChosenFaction);
            }

            for (CharacterFactionEntity myChosenCharacterFaction: characterFactionsList()) {
                characterFactionDAO.insert(myChosenCharacterFaction);
            }

            for (NicknamesEntity myChosenNicknames: nicknamesList()) {
                nicknamesDAO.insert(myChosenNicknames);
            }

        }).start();
    }

    //CHAPTERS
    private List<ChapterEntity> chaptersList() {
        List<ChapterEntity> chapters = new ArrayList<>();
        //1
        //TODO - Add characterFirstAppearance (chapter number) and storySoFar
        chapters.add(new ChapterEntity(1, 1, 1));
        chapters.add(new ChapterEntity(1, 2, 2));
        chapters.add(new ChapterEntity(1, 3, 3));
        chapters.add(new ChapterEntity(1, 4, 4));
        chapters.add(new ChapterEntity(1, 5, 5));
        chapters.add(new ChapterEntity(1, 6, 6));
        chapters.add(new ChapterEntity(1, 7, 7));
        chapters.add(new ChapterEntity(1, 8, 8));
        chapters.add(new ChapterEntity(1, 9, 9));
        chapters.add(new ChapterEntity(1, 10, 10));
        chapters.add(new ChapterEntity(1, 11, 11));
        chapters.add(new ChapterEntity(1, 12, 12));
        chapters.add(new ChapterEntity(1, 13, 13));
        chapters.add(new ChapterEntity(1, 14, 14));
        chapters.add(new ChapterEntity(1, 15, 15));
        chapters.add(new ChapterEntity(1, 16, 16));
        chapters.add(new ChapterEntity(1, 17, 17));
        chapters.add(new ChapterEntity(1, 18, 18));
        chapters.add(new ChapterEntity(1, 19, 19));
        chapters.add(new ChapterEntity(1, 20, 20));
        chapters.add(new ChapterEntity(1, 21, 21));
        chapters.add(new ChapterEntity(1, 22, 22));

        return chapters;
    }


    //CHARACTERS
    private List<CharacterEntity> charactersList() {
        List<CharacterEntity> characters = new ArrayList<>();
        characters.add(new CharacterEntity(1, "Supreme Ancestor"));
        characters.add(new CharacterEntity(2, "Guang Wu", "Emperor"));
        characters.add(new CharacterEntity(3, "Xian", "Emperor"));
        characters.add(new CharacterEntity(4, "Huang", "Emperor"));
        characters.add(new CharacterEntity(5, "Ling", "Emperor"));
        characters.add(new CharacterEntity(6, "Dou Wu", "Regent-Marshal"));
        characters.add(new CharacterEntity(7, "Chen Fan", "Imperial Guardian"));
        characters.add(new CharacterEntity(8, "Cao Jie", "Eunuch"));
        characters.add(new CharacterEntity(9, "Cai Yong", "Court Counselor"));
        characters.add(new CharacterEntity(10, "Zhang Rang", "Eunuch"));
        characters.add(new CharacterEntity(11, "Zhao Zhong", "Eunuch"));
        characters.add(new CharacterEntity(12, "Feng Xu", "Eunuch"));
        characters.add(new CharacterEntity(13, "Duan Gui", "Eunuch"));
        characters.add(new CharacterEntity(14, "Hou Lan", "Eunuch"));
        characters.add(new CharacterEntity(15, "Jian Shuo", "Eunuch"));
        characters.add(new CharacterEntity(16, "Cheng Kuang", "Eunuch"));
        characters.add(new CharacterEntity(17, "Xia Yun", "Eunuch"));
        characters.add(new CharacterEntity(18, "Guo Sheng", "Eunuch"));

        characters.add(new CharacterEntity(19, "Zhang Jue", null, "Great and Worthy Teacher"));
        characters.add(new CharacterEntity(20, "Zhang Bao"));
        characters.add(new CharacterEntity(21, "Zhang Liang"));

        characters.add(new CharacterEntity(22, "Zhuang Zi", "Taoist Sage"));





        return characters;
    }

    //FACTIONS

    private List<FactionEntity> factionsList() {
        List<FactionEntity> factions = new ArrayList<>();
        factions.add(new FactionEntity(0, "My Test Faction", "Coming Soon"));
        //factions.add(new FactionEntity(1, "Zhou Dynasty", "Coming Soon"));
        //factions.add(new FactionEntity(2, "Qin", "Coming Soon"));
        //factions.add(new FactionEntity(3, "Chu", "Coming Soon"));
        factions.add(new FactionEntity(4, "Han", "Coming Soon"));
        factions.add(new FactionEntity(5, "Ten Regular Attendants", "Coming Soon"));

        factions.add(new FactionEntity(6, "Yellow Scarves", "Coming Soon"));




        return factions;
    }

    //CHARACTER FACTIONS
    private List<CharacterFactionEntity> characterFactionsList() {
        List<CharacterFactionEntity> characterFactions = new ArrayList<>();

        characterFactions.add(new CharacterFactionEntity(19, 6, 1, 1));
        characterFactions.add(new CharacterFactionEntity(19, 0, 1, 1));
        characterFactions.add(new CharacterFactionEntity(19, 4, 2, 0));

        return characterFactions;
    }

    //LOCATIONS
    //Luoyang - the capitol
    //Yuan Mountains
    //Julu District
    //Mount Hua

    //NICKNAMES
    private List<NicknamesEntity> nicknamesList() {
        List<NicknamesEntity> characterNicknames = new ArrayList<>();

        characterNicknames.add(new NicknamesEntity(19, "Master of the Millenium"));
        characterNicknames.add(new NicknamesEntity(22, "The Old Hermit From Mount Hua Summit"));


        return characterNicknames;
    }

}