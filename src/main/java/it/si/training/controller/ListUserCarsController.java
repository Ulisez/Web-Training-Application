package it.si.training.controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.Car;
import it.si.training.model.User;
import it.si.training.utility.UserDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/list/cars")
public class ListUserCarsController extends HttpServlet {

    UserDAO<User> userDao = null;

    @Override
    public void init() throws ServletException {
        userDao = UserDaoFactory.getUserDAO("jpa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      handleRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);

    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");

        if(userId != null && !userId.equals("")){
            setRequestAttributes(req,userId);
            req.getRequestDispatcher("/list-user-cars.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/").forward(req,resp);
        }
    }

    private void setRequestAttributes(HttpServletRequest req, String userId) {
        Long id = Long.parseLong(userId);
        User user = findUser(id);
        req.setAttribute("name",user.getName());
        req.setAttribute("lastname",user.getLastname());
        //req.setAttribute("cars",user.getCars().toArray());
    }

    private User findUser(Long id){
        return userDao.find(id);
    }
}
