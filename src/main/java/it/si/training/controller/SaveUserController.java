package it.si.training.controller;

import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/save")
public class SaveUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        //creo l'utente e lo passo alal funzione saveUser che chiamerà poi l'oggetto che implementa il DAO per l'accesso ai dati
        User user = new User(name,lastname,address,phone);
        saveUser(user);

        //passiamo il controllo alla home per fare un refresh della pagina
        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));

    }

    private void saveUser(User user){
        UserDAO userDao = new UserDAOJDBCImpl();
        userDao.save(user);
    }
}
