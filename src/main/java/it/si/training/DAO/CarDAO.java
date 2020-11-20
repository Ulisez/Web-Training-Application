package it.si.training.DAO;

import it.si.training.model.Car;

public interface CarDAO extends DAOGeneric<Car>{

    public Car findCar(Long id);
}
