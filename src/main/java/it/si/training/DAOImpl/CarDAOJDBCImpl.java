package it.si.training.DAOImpl;

import it.si.training.DAO.CarDAO;
import it.si.training.model.Car;
import it.si.training.model.User;
import it.si.training.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOJDBCImpl implements CarDAO {

    private DatabaseConnection dbConnection;

    public CarDAOJDBCImpl() {
        try {
            dbConnection = DatabaseConnection.getIstance();
            System.out.println(dbConnection.getConnection());
        }catch (SQLException e){
            System.out.println("Errore di connessione" + e.getSQLState());
        }
    }

    public long save(Car element) {
        return 0;
    }

    public void delete(Long id) {

    }

    public void update(Car element) {

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
                        resultSet.getDouble(5)));
            }

        }catch (SQLException e){
            System.out.println("errore nel recupero degli utenti" + e.getMessage());
        }

        return cars;
    }
}
