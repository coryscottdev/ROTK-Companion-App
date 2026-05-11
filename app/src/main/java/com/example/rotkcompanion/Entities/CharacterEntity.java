package com.example.rotkcompanion.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class CharacterEntity {
    @PrimaryKey
    private int characterID;

    private String characterName;

    private String characterTitle;

    public String getCharacterTitle() {
        return characterTitle;
    }

    public void setCharacterTitle(String characterTitle) {
        this.characterTitle = characterTitle;
    }

    public CharacterEntity(int characterID, String characterName) {
        this.characterID = characterID;
        this.characterName = characterName;
    }
    public CharacterEntity(int characterID, String characterName, String characterTitle) {
        this.characterID = characterID;
        this.characterName = characterName;
        this.characterTitle = characterTitle;
    }


    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public CharacterEntity() {
    }

}
