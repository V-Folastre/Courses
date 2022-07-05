package fr.afpa.courses.servlets;

import fr.afpa.courses.dal.ListeSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/index")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListeSQL listeSQL = new ListeSQL();
        request.setAttribute("listes", listeSQL.selectAll());
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
