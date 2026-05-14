package com.example.rotkcompanion.Entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"characterID", "factionID", "joinedChapter"})
public class CharacterFactionEntity {
    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public int getFactionID() {
        return factionID;
    }

    public void setFactionID(int factionID) {
        this.factionID = factionID;
    }

    public int getJoinedChapter() {
        return joinedChapter;
    }

    public void setJoinedChapter(int joinedChapter) {
        this.joinedChapter = joinedChapter;
    }

    public int getLeftChapter() {
        return leftChapter;
    }

    public void setLeftChapter(int leftChapter) {
        this.leftChapter = leftChapter;
    }

    public int getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(int isCurrent) {
        this.isCurrent = isCurrent;
    }


    private int characterID;

    private int factionID;

    private int joinedChapter;
    private int leftChapter;
    private int isCurrent;

    public CharacterFactionEntity(int characterID, int factionID, int joinedChapter, int leftChapter, int isCurrent) {
        this.characterID = characterID;
        this.factionID = factionID;
        this.joinedChapter = joinedChapter;
        this.leftChapter = leftChapter;
        this.isCurrent = isCurrent;
    }

    @Ignore
    public CharacterFactionEntity(int characterID, int factionID, int joinedChapter, int isCurrent) {
        this.characterID = characterID;
        this.factionID = factionID;
        this.joinedChapter = joinedChapter;
        this.isCurrent = isCurrent;
    }
    }