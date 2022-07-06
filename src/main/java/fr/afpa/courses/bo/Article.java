package fr.afpa.courses.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Article {
    private int id;
    private String nom;
    private int id_liste;
    private boolean coche;

    public Article(String nom, int id_liste) {
        this.nom = nom;
        this.id_liste = id_liste;
        this.coche = false;
    }

    public Article(int id, String nom, boolean coche) {
        this.id = id;
        this.nom = nom;
        this.coche = coche;
    }
}
