
package it.si.training.controller;

import it.si.training.DAO.UserDAO;
import it.si.training.model.User;
import it.si.training.utility.UserDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author Ulises Sanchez
 * controller principale
 */

@WebServlet(value = "/")
public class HomeController extends HttpServlet {

    UserDAO<User> userDAO = null;

    public HomeController() {

    }

    @Override
    public void init() throws ServletException {
        userDAO = UserDaoFactory.getUserDAO("jpa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("users",listUsers());

        //inoltra il controllo a home.jsp che si occuperà di visualizzare i dati
        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private List<User> listUsers() {
        return userDAO.findAll();
    }
}
