package it.si.training.DAOImpl;

import it.si.training.DAO.PurchaseDAO;
import it.si.training.model.Purchase;
import it.si.training.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDaoJDBCImpl implements PurchaseDAO {

    private DatabaseConnection dbConnection = null;

    public PurchaseDaoJDBCImpl() {
        try {
            dbConnection = DatabaseConnection.getIstance();
        }catch (SQLException e){
            System.out.println("Errore di connessione" + e.getSQLState());
        }
    }

    @Override
    public void savePurchase(Purchase purchase) {
        String saveQuery = "INSERT INTO purchases (userId, carId)"+
                "VALUES(?,?)";
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(saveQuery);
            statement.setLong(1,purchase.getUserId());
            statement.setLong(2,purchase.getCarId());

            statement.executeUpdate();

        }catch (SQLException e){

        }
    }
}
