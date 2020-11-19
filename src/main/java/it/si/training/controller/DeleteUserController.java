package it.si.training.controller;

import it.si.training.DAOImpl.UserDAOJDBCImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {

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
            UserDAOJDBCImpl userDao = new UserDAOJDBCImpl();
            userDao.delete(Long.parseLong(userId));
            resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
        }
    }
}
