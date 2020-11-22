package it.si.training.DAOImpl;

import it.si.training.DAO.UserDAO;
import it.si.training.model.Car;
import it.si.training.model.User;
import it.si.training.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOJDBCImpl implements UserDAO<User> {

   private DatabaseConnection dbConnection;

    public UserDAOJDBCImpl() {
        try {
            dbConnection = DatabaseConnection.getIstance();
            System.out.println(dbConnection.getConnection());
        }catch (SQLException e){
            System.out.println("Errore di connessione" + e.getSQLState());
        }
    }

    public void save(User user) {
        String saveQuery = "INSERT INTO users (firstname, lastname, address, phone)"+
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(saveQuery);
            statement.setString(1,user.getName());
            statement.setString(2,user.getLastname());
            statement.setString(3,user.getAddress());
            statement.setString(4,user.getPhone());

            statement.executeUpdate();
        }catch (SQLException e){

        }
    }

    public void delete(Long id) {
     String deleteQuery = "DELETE FROM users WHERE userId = ?";
     try {
         PreparedStatement statement = dbConnection.getConnection().prepareStatement(deleteQuery);
         statement.setLong(1,id);
        int result = statement.executeUpdate();
        System.out.println("Operazione di eliminazione " +result);

     }catch (SQLException e){
         System.out.println("Errore nell'operazione di eliminazione" + e.getMessage());
     }
    }

    public void update(User user) {
        //query per aggiornare i dati dell'utente passato come parametro
        String updateQuery = "UPDATE users SET firstname=? ,"+
                "lastname=?, address=?, phone=?" + "WHERE userId=?";
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(updateQuery);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone());
            statement.setLong(5, user.getUserId());
           int resultOperation = statement.executeUpdate();
           System.out.println("L'utente " +user.getName() + " è stato AGGIORNATO e il risultato dell'operazione è " +resultOperation);
        }catch (SQLException e){
            System.out.println("L'operazione di aggiornamento ha causato un problema" + e.getMessage());
        }

    }

    /**
     * Restituisce la lista degli utenti presneti nel database
     * @return lista di utenti
     */
    public List<User> findAll() {
        //lista di utenti che conterrà tutti gli utenti recuperati dalla base di dati
        List<User> users = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT* FROM users"; //select per recuperare tutti gli utenti

        try {
            statement = dbConnection.getConnection().prepareStatement(query);
            resultSet = statement.executeQuery(); //seguire la query

           //scorrere l'intera tabella e per ogni riga recuperare tutti i dati
            while(resultSet.next()){
             if(users == null)
                 users = new ArrayList<User>();

             //crea un oggetto utente con i dati recuperati dalla base di dati e l'aggiunge alla lista
             users.add(new User(resultSet.getLong(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getString(4),
                     resultSet.getString(5)));
            }

        }catch (SQLException e){
            System.out.println("errore nel recupero degli utenti" + e.getMessage());
        }finally {
            close(statement,resultSet);
        }

        return users;
    }

    @Override
    public User find(Long id) {
        return null;
    }


    public Set<Car> findUserCars(Long userId) {
        Set<Car> cars = null;
        String queryFindCars = "SELECT c.carId, c.brand, c.model, c.category, c.price FROM purchases p INNER JOIN cars c ON p.carId=c.carId and p.userId=?";
        try{
        PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(queryFindCars);
        preparedStatement.setLong(1,userId);
        ResultSet result = preparedStatement.executeQuery();
        cars = new HashSet<>();
        while(result.next()){
            Car car = new Car();
            car.setCarId(Long.parseLong(result.getString(1)));
            car.setBrand(result.getString(2));
            car.setModel(result.getString(3));
            car.setCategory(result.getString(4));
            car.setPrice(Double.parseDouble(result.getString(5)));
            cars.add(car);
            System.out.println(car);
        }

        } catch (SQLException e ){
            System.out.println("L'operazione di recupero delle macchine comprate dall'utente è fallita" + e.getMessage());
        }

        return cars;
    }

    @Override
    public void addNewCar(Long userId, Long carId) {

    }

    private void close(PreparedStatement statement, ResultSet resultSet) {
        try {
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }

        }catch (Exception e){
            System.out.println("L'operazione di chiusura è fallita" + e.getMessage());
        }

    }

}
