package com.example.rotkcompanion.ui.theme;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rotkcompanion.Database.Repository;
import com.example.rotkcompanion.Entities.CharacterEntity;
import com.example.rotkcompanion.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CurrentChapterActivity extends AppCompatActivity {
    Repository repository;
    ExpandableListView expandableListView;
    int chapNumSelection;
    CharacterExpandableAdapter expandableAdapter;

    Integer[] chapterNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
            49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75,
            76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102,
            103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120};
    String[] sortBy = {"Order of Appearance", "Alphabetical (A-Z)"};
    String[] display = {"Characters", "Locations"};

    private List<String> charGroupList;
    private Map<String, List<String>> charCollection;

    private void createCharCollection() {
        new Thread(() -> {
            List<Integer> charIDs = repository.getCharacterIDsByChapter(chapNumSelection);
            List<String> names = new ArrayList<>();
            for (int charID : charIDs) {
                names.add(repository.getmCharacterNameByID(charID));
            }

            runOnUiThread(() -> {
                String mentionedFactions = "Factions";
                charGroupList.add(mentionedFactions);
                List<String> myPH = new ArrayList<>();
                myPH.add("Placeholder1");
                myPH.add("Placeholder2");
                charCollection.put(mentionedFactions, myPH);

                for (String name : names) {
                    charGroupList.add(name);

                    List<String> details = new ArrayList<>();
                    details.add("Nickname Placeholder for " + name);
                    details.add("(Current) Faction: Placeholder for " + name);
                    details.add("More info/physical description Placeholder for " + name);
                    details.add(name + "'s Story So Far...");
                    charCollection.put(name, details);
                }

                expandableAdapter = new CharacterExpandableAdapter(
                        this, charGroupList, charCollection);
                expandableListView.setAdapter(expandableAdapter);
            });
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_current_chapter);

        repository = new Repository(getApplication());
        expandableListView = findViewById(R.id.characterExpandable);

        Spinner chapterSelectSpinner = findViewById(R.id.chapterSelectSpinner);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, chapterNumbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chapterSelectSpinner.setAdapter(adapter);
        chapterSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chapNumSelection = (int) parent.getItemAtPosition(position);
                charGroupList = new ArrayList<>();
                charCollection = new HashMap<>();
                createCharCollection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Spinner sortBySpinner = findViewById(R.id.sortBySpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sortBy);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBySpinner.setAdapter(adapter2);

        Spinner displaySpinner = findViewById(R.id.displaySpinner);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, display);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        displaySpinner.setAdapter(adapter3);
    }
}