package com.example.rotkcompanion.ui.theme;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rotkcompanion.Database.Repository;
import com.example.rotkcompanion.Entities.ChapterEntity;
import com.example.rotkcompanion.Entities.CharacterEntity;
import com.example.rotkcompanion.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterDetails extends AppCompatActivity {
    private List<String> chapterGroupList; // headers
    private Map<String, List<String>> chapterCollection;
    Repository repository;
    ExpandableListView detailsExpandable;
    private int characterID;
    private String characterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_character_details);
        repository = new Repository(getApplication());
        detailsExpandable = findViewById(R.id.characterDetailsExpandable);
        Intent intent = getIntent();
        characterID = intent.getIntExtra("characterID", -1);
        characterName = intent.getStringExtra("characterName");
        ((TextView) findViewById(R.id.characterDetailsNameTextView)).setText(characterName);

        createDetailsCollection();
    }



    private void createDetailsCollection() {
            chapterGroupList = new ArrayList<>();
            chapterCollection = new HashMap<>();

            new Thread(() -> {
                String extraDetails = "Character Details";
                List<String> moreDetails = new ArrayList<>();
                moreDetails.add("Nickname Placeholder for " + characterName);
                moreDetails.add("(Current) Faction: Placeholder for " + characterName);
                moreDetails.add("More info/physical description Placeholder for " + characterName);
                chapterCollection.put(extraDetails, moreDetails);

                List<Integer> allCharChaps = repository.getmAllChaptersByCharacter(characterID);


                runOnUiThread(() -> {
                    chapterGroupList.add(extraDetails);

                    for (int i = 0; i < allCharChaps.size(); i++){
                        String myGroup = "Chapter " + allCharChaps.get(i);
                        chapterGroupList.add(myGroup);
                        List<String> details = new ArrayList<>();
                        details.add("Chapter recap");

                        chapterCollection.put(myGroup, details);
                    }

                    ChapterExpandableAdapter adapter = new ChapterExpandableAdapter(
                            this, chapterGroupList, chapterCollection);
                    detailsExpandable.setAdapter(adapter);
                });
            }).start();
        }

}
