package it.si.training.controller;

import it.si.training.DAO.PurchaseDAO;
import it.si.training.DAOImpl.PurchaseDaoJDBCImpl;
import it.si.training.model.Purchase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Classe utlizzata per gestire l'acquisto delle auto nella versione JDBC
 */
@WebServlet("/car/purchase")
public class PurchaseCarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //prelevo i parametri sull'utente selezionato inviati nella request
        String userDetail = req.getParameter("userSelected");
        String carId = req.getParameter("carId");

        //controlo che le informazioni sull'utente non siano nulle o vuote
        if(userDetail != null && !userDetail.equals("")){
            String userId = splitUserInformation(req,userDetail);
            savePurchase(userId,carId);
        }

        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/user/show/cars"));
    }

    private void savePurchase(String userId, String carId) {
        PurchaseDAO purchaseDao = new PurchaseDaoJDBCImpl();
        purchaseDao.savePurchase(new Purchase(Long.parseLong(userId),Long.parseLong(carId)));
    }

    private String splitUserInformation(HttpServletRequest req, String userInformation) {
        String[] information = userInformation.split(" ");
        req.setAttribute("name",information[0]);
        req.setAttribute("userId",Long.parseLong(information[1]));
        //restituisce l'id dell'utente
        return information[1];
    }
}
