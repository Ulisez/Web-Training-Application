
package it.si.training.controller;

import it.si.training.DAOImpl.UserDAOJDBCImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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

        UserDAOJDBCImpl userDAO = new UserDAOJDBCImpl();

       /* list.add(new User("Pluto","pippo","milano","365-896-4565"));
        list.add(new User("Mirko","brea","padova","365-896-4565"));
        list.add(new User("Ulises","sanchez","vanzaghello","365-896-4565"));
        list.add(new User("Ezequiel","Perez","Magnago","365-896-4565")); */

        req.setAttribute("users",userDAO.findAll());

        //inoltra il controllo a home.jsp che si occuperà di visualizzare i dati
        req.getRequestDispatcher("home.jsp").forward(req, resp);


   /*   bad practice, il servlet deve solo ocucparsi di processare la richiesta e mai
        di scrivere i dati da mostrare, sarà la JSP a occuparsi di mostrare i dati
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<h3>Hello Servlet</h3>");
        out.print("</body></html>");

        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
