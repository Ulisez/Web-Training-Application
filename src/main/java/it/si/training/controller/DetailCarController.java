package it.si.training.controller;

import it.si.training.DAO.CarDAO;
import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.CarDAOJDBCImpl;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.model.Car;
import it.si.training.model.User;
import it.si.training.utility.CarDaoFactory;
import it.si.training.utility.UserDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/car/detail")
public class DetailCarController extends HttpServlet {

    CarDAO<Car> carDao = null;
    UserDAO<User> userDao = null;

    @Override
    public void init() throws ServletException {
        carDao = CarDaoFactory.getCarDAO("jpa");
        userDao = UserDaoFactory.getUserDAO("jpa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          handleRequest(req,resp);

    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String carId  = req.getParameter("carId");
         String userId = req.getParameter("userSelected");

        if(userId != null && !userId.equals("")) {
            buyCar(Long.parseLong(userId),(Long.parseLong(carId)));
            resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()) + "/");

        }else{
            req.setAttribute("carDetail",carDetail(Long.parseLong(carId)));
            req.setAttribute("userList",userList());
            req.getRequestDispatcher( "/car_detail.jsp").forward(req,resp);
        }
    }

    private void buyCar(Long userId, Long carId){
        User user = userDao.find(userId);
        userDao.addNewCar(userId,carId);
    }

    private Car carDetail(Long id) {
        return carDao.find(id);
    }

    private User userDetail(Long id){
        return  userDao.find(id);
    }
    private List<User> userList(){
        return UserDaoFactory.getUserDAO("jpa").findAll();
    }

   /* private String splitUserInformation(HttpServletRequest req, String userInformation) {
        String[] information = userInformation.split(" ");
        req.setAttribute("name",information[0]);
        req.setAttribute("userId",Long.parseLong(information[1]));
        //restituisce l'id dell'utente
        return information[1];
    } */

}
