package com.example.rotkcompanion.ui.theme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rotkcompanion.R;

public class CharacterDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_character_details);
        Intent intent = getIntent();
        int characterID = intent.getIntExtra("characterID", -1);
        String characterName = intent.getStringExtra("characterName");
        ((TextView) findViewById(R.id.characterDetailsNameTextView)).setText(characterName);
    }

}
