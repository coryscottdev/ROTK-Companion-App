package com.example.rotkcompanion.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"characterID", "nickname"})
public class NicknamesEntity {
    private int characterID;
    @NonNull
    private String nickname;

    public NicknamesEntity(int characterID, @NonNull String nickname) {
        this.characterID = characterID;
        this.nickname = nickname;
    }
    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
