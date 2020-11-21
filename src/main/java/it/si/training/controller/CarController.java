package it.si.training.controller;

import it.si.training.DAO.CarDAO;
import it.si.training.DAOImpl.CarDAOJDBCImpl;
import it.si.training.model.Car;
import it.si.training.utility.CarDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/car")
public class CarController extends HttpServlet {

    CarDAO<Car> carDao = null;

    @Override
    public void init() throws ServletException {
        carDao = CarDaoFactory.getCarDAO("jpa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       handleRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req,resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String command = req.getParameter("command");

        if(command == null){
            req.setAttribute("cars",carDao.findAll());
            req.getRequestDispatcher("car.jsp").forward(req,resp);
        }else{
            chooseOperation(command, req, resp);
        }
    }

    private void chooseOperation(String command, HttpServletRequest req, HttpServletResponse resp) {

        String carId = req.getParameter("carId");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String category = req.getParameter("category");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        switch (command){
            case "ADD":
                addCar(new Car(brand,model,category,description,Double.parseDouble(price)));
                break;
            case "UPDATE":
                updateCar(new Car(Long.parseLong(carId),brand,model,category,description,Double.parseDouble(price)));
                break;
            case "DELETE":
                deleteCar(Long.parseLong(carId));
        }
    }

    private void addCar(Car car){
        carDao.save(car);
    }

    private void updateCar(Car car){
        carDao.update(car);
    }

    private void deleteCar(Long id){
        carDao.delete(id);
    }
}
