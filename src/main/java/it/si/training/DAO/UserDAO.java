package it.si.training.DAO;

import it.si.training.model.Car;
import it.si.training.model.User;

import java.util.List;

/**
 * UserDAO eredita tutti i metodi dell'interfaccia generica
 * @see DAOGeneric
 */
public interface UserDAO extends DAOGeneric<User> {

    public List<Car> findUserCars(Long userId);
}
