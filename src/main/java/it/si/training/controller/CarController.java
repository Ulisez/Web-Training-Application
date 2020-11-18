package it.si.training.controller;

import it.si.training.DAOImpl.CarDAOJDBCImpl;
import it.si.training.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/car")
public class CarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAOJDBCImpl carDao = new CarDAOJDBCImpl();
        for (Car car: carDao.findAll()
             ) {
            System.out.println(car);
        }
        req.getRequestDispatcher("car.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
