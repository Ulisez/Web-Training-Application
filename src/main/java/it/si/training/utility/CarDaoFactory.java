package it.si.training.utility;

import it.si.training.DAO.CarDAO;
import it.si.training.DAOImpl.CarDAOJDBCImpl;
import it.si.training.DAOImpl.CarDaoJPAImpl;
import it.si.training.model.Car;


public class CarDaoFactory {

    public static CarDAO<Car> getCarDAO(String type){
        CarDAO<Car> carDao = null;
        switch (type){
            case "jdbc":
                carDao = new CarDAOJDBCImpl();
                break;
            case "jpa":
               carDao = new CarDaoJPAImpl();
                break;
            default:
                System.out.println("Il tipo di oggetto indicato non esiste");
        }
        return carDao;
    }
}
