package com.example.recipesmanager;

import java.util.ArrayList;
import java.util.List;

public class MesRecettes {
    ArrayList<Recette> list = new ArrayList<Recette>();

    public MesRecettes(){
        Recette r1 = new Recette("Velouté de Potiron et Carottes", "déjeuner", 4, "débutant", new String[]{"1 kg de potiron", "500 g de carotte", "2 pommes de terre", "1 gousse d'ail", "1 oignon", "500 ml de lait", "500 ml de bouillon de volaille", "1 cuillère à soupe d'huile d'olive", "Persil", "Poivre", "Sel", "Muscade", "10 cl de crème liquide (facultatif)"}, "Éplucher et couper en dés le potiron, les pommes de terre, les carottes en rondelles.\n" +
                "Emincer l'ail et l'oignon.\n" +
                "Faire suer l'oignon dans l'huile d'olive.\n" +
                "Ajouter tous les légumes et l'ail puis verser le bouillon et le lait.\n" +
                "Saler, poivrer, \"muscader\" et laisser cuire environ une trentaine de minutes.\n" +
                "Mixer le tout (ajouter éventuellement la crème) et rectifier l'assaisonnement si nécessaire.\n" +
                "Bon appétit !");

        list.add(r1);
    }

    public List<String> gettitres(){
        List<String> titres = new ArrayList<>();

        for(int i=0; i<list.size();i++){
            titres.add(list.get(i).getTitre());
        }
        return titres;
    }

}
