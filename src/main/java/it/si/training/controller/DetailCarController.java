package it.si.training.controller;

import it.si.training.DAO.CarDAO;
import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.CarDAOJDBCImpl;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.Car;
import it.si.training.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/car/detail")
public class DetailCarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        if(carId != null && !carId.equals("")) {
            req.setAttribute("carDetail",carDetail(carId));
            req.setAttribute("userList",userList());
            req.getRequestDispatcher( "/car_detail.jsp").forward(req,resp);
        }
    }

    private Car carDetail(String id) {
        CarDAO carDao = new CarDAOJDBCImpl();
        return carDao.findCar(Long.parseLong(id));
    }

    private List<User> userList(){
        UserDAO userDao = new UserDAOJDBCImpl();
        return userDao.findAll();
    }

}
