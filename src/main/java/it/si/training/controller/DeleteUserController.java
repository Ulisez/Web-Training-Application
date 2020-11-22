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

@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {

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
        if( userId == null || userId.equals("") ){
            req.getRequestDispatcher("/").forward(req,resp);
        }else{
            deleteUser(userId);
            resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
        }
    }

    private void deleteUser(String userId){
        userDao.delete(Long.parseLong(userId));
    }
}
