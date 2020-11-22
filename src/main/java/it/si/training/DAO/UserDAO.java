package it.si.training.DAO;

import it.si.training.model.Car;
import java.util.Set;

/**
 * UserDAO eredita tutti i metodi dell'interfaccia generica
 * @see DAOGeneric
 */
public interface UserDAO<T> extends DAOGeneric<T> {

    public Set<Car> findUserCars(Long userId);

    public void addNewCar(Long userId, Long carId);
}
