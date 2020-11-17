
package it.si.training.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ulises Sanchez
 * controller principale
 */

@WebServlet(value = "/")
public class HomeController extends HttpServlet {

    public HomeController() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //inoltra il controllo a home.jsp che si occuperà di visualizzare i dati
        req.getRequestDispatcher("home.jsp").forward(req, resp);


   /*   bad practice, il server deve solo ocucparsi di processare la richiesta e mai
        di scrivere i dati da mostrare, sarà la JSP a occuparsi di mostrare i dati
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<h3>Hello Servlet</h3>");
        out.print("</body></html>");

        */


    }
}
