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
    }

    public ListeCourse(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
