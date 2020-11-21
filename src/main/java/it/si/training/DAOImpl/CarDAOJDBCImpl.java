package it.si.training.DAOImpl;

import it.si.training.DAO.CarDAO;
import it.si.training.model.Car;
import it.si.training.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOJDBCImpl implements CarDAO<Car> {

    private DatabaseConnection dbConnection;

    public CarDAOJDBCImpl() {
        try {
            dbConnection = DatabaseConnection.getIstance();
        }catch (SQLException e){
            System.out.println("Errore di connessione" + e.getSQLState());
        }
    }

    public void save(Car car) {

    }

    public void delete(Long id) {

    }

    public void update(Car car) {

    }

    public List<Car> findAll() {
        //lista di utenti che conterrà tutti gli utenti recuperati dalla base di dati
        List<Car> cars = null;
        String query = "SELECT* FROM cars"; //select per recuperare tutti gli utenti
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(); //seguire la query

            //scorrere l'intera tabella e per ogni riga recuperare tutti i dati
            while(resultSet.next()){
                if(cars == null)
                    cars= new ArrayList<Car>();

                //crea un oggetto utente con i dati recuperati dalla base di dati e l'aggiunge alla lista
                cars.add(new Car(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6)));
            }

        }catch (SQLException e){
            System.out.println("errore nel recupero delle macchine" + e.getMessage());
        }

        return cars;
    }

    @Override
    public Car findCar(Long id) {
        Car car = null;
        String findQuery = "SELECT* FROM cars WHERE carId=?";
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(findQuery);
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();

            if (result.next()){
                car = new Car();
                car.setCarId(result.getLong(1));
                car.setBrand(result.getString(2));
                car.setModel(result.getString(3));
                car.setCategory(result.getString(4));
                car.setPrice(result.getDouble(5));
            }

        }catch (SQLException e){
            System.out.println("Errore nel trovare l'auto " + e.getMessage());
        }
        return car;
    }
}
