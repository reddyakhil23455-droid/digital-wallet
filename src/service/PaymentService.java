package service;

import dao.DBConnection;
import dao.TransactionDAO;
import dao.WalletDAO;
import java.sql.Connection;

public class PaymentService {

    WalletDAO walletDAO = new WalletDAO();
    TransactionDAO txnDAO = new TransactionDAO();

    public void transferMoney(int senderId, int receiverId, double amount) {

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            double senderBalance = walletDAO.getBalance(conn, senderId);

            if (senderBalance < amount) {
                System.out.println("Insufficient balance");
                txnDAO.saveTransaction(conn, senderId, receiverId, amount, "FAILED");
                conn.rollback();
                return;
            }

            walletDAO.updateBalance(conn, senderId, -amount);
            walletDAO.updateBalance(conn, receiverId, amount);

            txnDAO.saveTransaction(conn, senderId, receiverId, amount, "SUCCESS");

            conn.commit();
            System.out.println("Transaction Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferByName(String senderName, String receiverName, double amount) {

        try (Connection conn = DBConnection.getConnection()) {

            int senderId = walletDAO.getUserIdByName(conn, senderName);
            int receiverId = walletDAO.getUserIdByName(conn, receiverName);

            if (senderId == -1 || receiverId == -1) {
                System.out.println("Invalid user name");
                return;
            }

            transferMoney(senderId, receiverId, amount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}