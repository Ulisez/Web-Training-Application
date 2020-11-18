package it.si.training.DAOImpl;

import it.si.training.DAO.UserDAO;
import it.si.training.model.User;
import it.si.training.utility.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBCImpl implements UserDAO {

   private DatabaseConnection dbConnection;

    public UserDAOJDBCImpl() {
        try {
            dbConnection = DatabaseConnection.getIstance();
            System.out.println(dbConnection.getConnection());
        }catch (SQLException e){
            System.out.println("Errore di connessione" + e.getSQLState());
        }
    }

    public long save(User user) {
        return 0;
    }

    public void delete(Long id) {

    }

    public void update(User user) {

    }

    /**
     * Restituisce la lista degli utenti presneti nel database
     * @return lista di utenti
     */
    public List<User> findAll() {
        //lista di utenti che conterrà tutti gli utenti recuperati dalla base di dati
        List<User> users = null;
        String query = "SELECT* FROM users"; //select per recuperare tutti gli utenti
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(); //seguire la query

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
        }

        return users;
    }
}
