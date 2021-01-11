package com.example.recipesmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Recette> list = new ArrayList<Recette>();
    Recette r = new Recette("Velouté de Potiron et Carottes", "déjeuner", 4 , "débutant", new String[] {"1 kg de potiron","500 g de carotte","2 pommes de terre","1 gousse d'ail","1 oignon","500 ml de lait","500 ml de bouillon de volaille","1 cuillère à soupe d'huile d'olive","Persil","Poivre", "Sel","Muscade", "10 cl de crème liquide (facultatif)"}, "Éplucher et couper en dés le potiron, les pommes de terre, les carottes en rondelles.\n" +
            "Emincer l'ail et l'oignon.\n" +
            "Faire suer l'oignon dans l'huile d'olive.\n" +
            "Ajouter tous les légumes et l'ail puis verser le bouillon et le lait.\n" +
            "Saler, poivrer, \"muscader\" et laisser cuire environ une trentaine de minutes.\n" +
            "Mixer le tout (ajouter éventuellement la crème) et rectifier l'assaisonnement si nécessaire.\n" +
            "Bon appétit !");

    //Constructeur
    protected MainActivity(){
        list.add(r);
    }



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}