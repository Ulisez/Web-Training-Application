package it.si.training.utility;

import java.sql.SQLException;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Ulises Sanchez
 * Classe usata per stabilire la connessione con la base di dati, implementa il pattern Singleton
 */
public class DatabaseConnection {

    private static DatabaseConnection istance;
    private Connection connection;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/training";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private DatabaseConnection() throws SQLException {
        try{
            Class.forName(DRIVER); //load diver class dinamicamente

            //stabilire una connessione con la base di dati
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        }catch (ClassNotFoundException e){
            System.out.println("connessione database fallita "+ e.getMessage());
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public static DatabaseConnection getIstance() throws SQLException {
        if(istance == null){
            istance = new DatabaseConnection();
        }else if(istance.getConnection().isClosed()){
            istance = new DatabaseConnection();
        }
        return istance;
    }
}
