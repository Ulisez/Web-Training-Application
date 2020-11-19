package it.si.training.controller;

import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        if(userId == null || userId.equals("")){
            req.getRequestDispatcher("/").forward(req,resp);
        }else{

            UserDAO userDao = new UserDAOJDBCImpl();
            User user = new User();
            user.setUserId(Long.parseLong(userId));
            user.setName(req.getParameter("name"));
            user.setLastname(req.getParameter("lastname"));
            user.setAddress(req.getParameter("address"));
            user.setPhone(req.getParameter("phone"));
            userDao.update(user);
            resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
        }
        System.out.println(""+ req.getParameter("name"));

        //UserDAOJDBCImpl userDao = new UserDAOJDBCImpl();

    }
}
