package it.si.training.DAO;

import it.si.training.model.Car;
import java.util.List;

/**
 * UserDAO eredita tutti i metodi dell'interfaccia generica
 * @see DAOGeneric
 */
public interface UserDAO<T> extends DAOGeneric<T> {

    public List<Car> findUserCars(Long userId);
}
