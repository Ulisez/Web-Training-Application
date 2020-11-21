package it.si.training.utility;

import it.si.training.DAO.UserDAO;
import it.si.training.DAOImpl.UserDAOJDBCImpl;
import it.si.training.DAOImpl.UserDaoJPAImpl;
import it.si.training.model.User;

/**
 * Inplementazione del pattern factory che restituisce un'implementazione dell'interfaccia UserDao
 */
public class UserDaoFactory {

    public static UserDAO<User> getUserDAO(String type){
        UserDAO<User> userDao = null;
        switch (type){
            case "jdbc":
                userDao = new UserDAOJDBCImpl();
                break;
            case "jpa":
                userDao = new UserDaoJPAImpl();
                break;
            default:
                System.out.println("Il tipo di oggetto indicato non esiste");
        }
        return userDao;
    }
}
