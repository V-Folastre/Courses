package fr.afpa.courses.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ListeCourse {
    private int id;
    private String nom;
    private ArrayList<Article> articles;

    public ListeCourse() {
        this.articles = new ArrayList<>();
    }

    public ListeCourse(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.articles = new ArrayList<>();
    }
}
