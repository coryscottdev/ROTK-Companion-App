package com.example.rotkcompanion.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FactionEntity {
    @PrimaryKey
    private int factionID;

    private String factionName;

    private String factionSummary;

    public FactionEntity(int factionID, String factionName, String factionSummary) {
        this.factionID = factionID;
        this.factionName = factionName;
        this.factionSummary = factionSummary;
    }

    public int getFactionID() {
        return factionID;
    }

    public void setFactionID(int factionID) {
        this.factionID = factionID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionSummary() {
        return factionSummary;
    }

    public void setFactionSummary(String factionSummary) {
        this.factionSummary = factionSummary;
    }
}
