package it.si.training.controller;

import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.User;
import it.si.training.utility.UserDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/saveorupdate")
public class SaveOrUpdateUserController extends HttpServlet {

    UserDAO<User> userDao = null;

    @Override
    public void init() throws ServletException {
        userDao = UserDaoFactory.getUserDAO("jpa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        if (userId == null) {
            //creo l'utente e lo passo alal funzione saveUser che chiamerà poi l'oggetto che implementa il DAO per l'accesso ai dati
            addUser(new User(name, lastname, address, phone));
        } else {
            updateUser(new User(Long.parseLong(userId),name, lastname, address, phone));
        }
        //passiamo il controllo alla home per fare un refresh della pagina
        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));

    }

    private void addUser(User user){
        userDao.save(user);
    }

    private void updateUser(User user){
     userDao.update(user);
    }
}
