package fr.afpa.courses.servlets;

import fr.afpa.courses.dal.ListeSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

// Servlet d'accueil dans web.xml
@WebServlet("/index")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // En utilisant la DAL
        ListeSQL listeSQL = new ListeSQL();
        // Je selectionne toutes les listes de courses en BDD
        // Et je les envoie a la jsp index.jsp
        request.setAttribute("listes", listeSQL.selectAll());
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
