package com.example.rotkcompanion.Entities;

import androidx.room.Entity;

@Entity
public class FactionByChapterEntity {
    private int chapterNum;

    private int FactionID;

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public int getFactionID() {
        return FactionID;
    }

    public void setFactionID(int factionID) {
        FactionID = factionID;
    }

    public int getFactionAppearanceOrder() {
        return factionAppearanceOrder;
    }

    public void setFactionAppearanceOrder(int factionAppearanceOrder) {
        this.factionAppearanceOrder = factionAppearanceOrder;
    }

    private int factionAppearanceOrder;
}
