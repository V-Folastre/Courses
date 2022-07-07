package fr.afpa.courses.servlets;

import fr.afpa.courses.bo.Article;
import fr.afpa.courses.dal.ArticleSQL;
import fr.afpa.courses.dal.ListeSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/nouvelle")
public class ListeCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si c'est une liste existante alors un id est en parametre
        String id = request.getParameter("id");
        // Je créé une instance de la DAL
        ListeSQL listeSQL = new ListeSQL();
        // Si l'id n'est pas nul
        if (id != null) {
            // Alors je recherche la liste en bdd
            fr.afpa.courses.bo.ListeCourse listeCourse = listeSQL.selectById(Integer.parseInt(id));
            // Et je l'envoie a la jsp
            request.setAttribute("listeCourse", listeCourse);
        }
        // Dans tous les cas, je vais sur la jsp nouvelle.jsp
        request.getRequestDispatcher("WEB-INF/nouvelle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Je récupère l'id de la liste et le nom de l'article envoyé par formulaire
        String id = request.getParameter("id_liste");
        String nom_article = request.getParameter("nom_article");
        // A partir de ces deux informations, je créé un nouvel article
        Article nouvel_article = new Article(nom_article, Integer.parseInt(id));
        // Avec une instance de la DAL
        ListeSQL listeSQL = new ListeSQL();
        ArticleSQL articleSQL = new ArticleSQL();
        // J'insère un nouvel article en BDD
        articleSQL.insert(nouvel_article, Integer.parseInt(id));
        // Et je sélectionne la liste en bdd pour la re afficher sur la jsp
        fr.afpa.courses.bo.ListeCourse listeCourse = listeSQL.selectById(Integer.parseInt(id));
        request.getRequestDispatcher("WEB-INF/nouvelle.jsp").forward(request, response);
    }
}
