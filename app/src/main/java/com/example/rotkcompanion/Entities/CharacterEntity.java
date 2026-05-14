package com.example.rotkcompanion.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class CharacterEntity {
    @PrimaryKey
    private int characterID;

    private String characterName;

    private String characterTitle;
    private String styleName;
    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

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
    public CharacterEntity(int characterID, String characterName, String characterTitle, String styleName) {
        this.characterID = characterID;
        this.characterName = characterName;
        this.characterTitle = characterTitle;
        this.styleName = styleName;
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
