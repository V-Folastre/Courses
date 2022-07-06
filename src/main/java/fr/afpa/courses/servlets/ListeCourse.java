package fr.afpa.courses.servlets;

import fr.afpa.courses.bo.Article;
import fr.afpa.courses.dal.ArticleSQL;
import fr.afpa.courses.dal.ListeSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/nouvelle")
public class ListeCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si c'est une liste existante alors un id est en parametre
        String id = request.getParameter("id");
        ListeSQL listeSQL = new ListeSQL();
        if (id != null) {
            fr.afpa.courses.bo.ListeCourse listeCourse = listeSQL.selectById(Integer.parseInt(id));
            request.setAttribute("listeCourse", listeCourse);
        }
        request.getRequestDispatcher("WEB-INF/nouvelle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id_liste");
        String nom_article = request.getParameter("nom_article");
        Article nouvel_article = new Article(nom_article, Integer.parseInt(id));
        ListeSQL listeSQL = new ListeSQL();
        ArticleSQL articleSQL = new ArticleSQL();
        articleSQL.insert(nouvel_article, Integer.parseInt(id));
        fr.afpa.courses.bo.ListeCourse listeCourse = listeSQL.selectById(Integer.parseInt(id));
        request.getRequestDispatcher("WEB-INF/nouvelle.jsp").forward(request, response);
    }
}
