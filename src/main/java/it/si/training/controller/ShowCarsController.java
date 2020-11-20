package it.si.training.controller;

import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/user/show/cars")
public class ShowCarsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("papapapapapapapapa"+ getServletName());
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userId = req.getParameter("userId");
       String name = req.getParameter("name");

       if(userId == null || userId.equals("")){
           req.getRequestDispatcher("/").forward(req,resp);
       }else{
           ArrayList<Car> cars = (ArrayList<Car>) new UserDAOJDBCImpl().findUserCars(Long.parseLong(userId));
           req.setAttribute("cars",cars);
           req.setAttribute("name",name);
           req.getRequestDispatcher("/showcars.jsp").forward(req,resp);
       }

    }
}
