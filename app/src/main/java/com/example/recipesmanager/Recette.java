package com.example.recipesmanager;

import java.util.ArrayList;
import java.util.List;

public class Recette {

    int id;
    String titre;
    String type;
    int nbpersonnes;
    String niveau;
    String ingredients;
    String instruction;
    String image;

    public Recette(){}

    public Recette( String titre, String type, int nbpersonnes, String niveau, String ingredients, String instruction, String image) {
        this.titre = titre;
        this.type = type;
        this.nbpersonnes = nbpersonnes;
        this.niveau = niveau;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.image = image;
    }

    public Recette(int id, String titre, String type, int nbpersonnes, String niveau, String ingredients, String instruction, String image) {
        this.id =id;
        this.titre = titre;
        this.type = type;
        this.nbpersonnes = nbpersonnes;
        this.niveau = niveau;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.image = image;
    }


    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    public int getNbpersonnes() {
        return nbpersonnes;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNbpersonnes(int nbpersonnes) {
        this.nbpersonnes = nbpersonnes;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }


    @Override
    public String toString() {
        return titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
