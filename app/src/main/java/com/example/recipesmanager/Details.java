package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    DB_Sqlite mydata = new DB_Sqlite(Details.this);
    TextView tvtitre;
    TextView tvtype;
    TextView tvtnbpersonnes;
    TextView tvniveau;
    TextView tvingredients;
    TextView tvinstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        int selectedid = getIntent().getExtras().getInt("selectedid");

        Recette recette = mydata.getRecetteById(selectedid);

        tvtitre = findViewById(R.id.titre);
        tvtitre.setText(recette.getTitre());

        tvtype = findViewById(R.id.type);
        tvtype.setText(recette.getType());


        tvtnbpersonnes = findViewById(R.id.nbpersonnes);
        tvtnbpersonnes.setText(String.valueOf(recette.getNbpersonnes()));

        tvniveau = findViewById(R.id.niveau);
        tvniveau.setText(recette.getNiveau());

        tvingredients = findViewById(R.id.ingredients);
        tvingredients.setText(recette.getIngredients());

        tvinstruction = findViewById(R.id.instruction);
        tvinstruction.setText(recette.getInstruction());












    }
}