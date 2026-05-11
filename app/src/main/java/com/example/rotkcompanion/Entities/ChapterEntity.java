package com.example.rotkcompanion.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"chapterNum", "characterID"})
public class ChapterEntity {

    private int chapterNum;

    private int characterID;

    private int characterAppearanceOrder;

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public int getCharacterAppearanceOrder() {
        return characterAppearanceOrder;
    }

    public void setCharacterAppearanceOrder(int characterAppearanceOrder) {
        this.characterAppearanceOrder = characterAppearanceOrder;
    }

    public ChapterEntity(int chapterNum, int characterID, int characterAppearanceOrder) {
        this.chapterNum = chapterNum;
        this.characterID = characterID;
        this.characterAppearanceOrder = characterAppearanceOrder;
    }
}
