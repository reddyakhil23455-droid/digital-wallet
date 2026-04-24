package service;

import dao.DBConnection;
import dao.TransactionDAO;
import dao.WalletDAO;
import java.sql.Connection;

public class PaymentService {

    WalletDAO walletDAO = new WalletDAO();
    TransactionDAO txnDAO = new TransactionDAO();

    // 🔥 MAIN METHOD (single connection)
    public void transferMoney(Connection conn, int senderId, int receiverId, double amount) {

        try {

            conn.setAutoCommit(false);

            double senderBalance = walletDAO.getBalance(conn, senderId);

            // ❌ insufficient balance
            if (senderBalance < amount) {
                System.out.println("Insufficient balance");
                System.out.println("Transaction Failed");

                txnDAO.saveTransaction(conn, senderId, receiverId, amount, "FAILED");
                conn.rollback();
                return;
            }

            // ✔ update balances
            walletDAO.updateBalance(conn, senderId, -amount);
            walletDAO.updateBalance(conn, receiverId, amount);

            txnDAO.saveTransaction(conn, senderId, receiverId, amount, "SUCCESS");

            conn.commit();
            System.out.println("Transaction Successful");

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    // 🔥 ENTRY METHOD (called from MainApp)
    public void transferByName(String senderName, String receiverName, double amount) {

        // ❌ same user
        if (senderName.equalsIgnoreCase(receiverName)) {
            System.out.println("Sender and receiver cannot be the same");
            return;
        }

        // ❌ invalid amount
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            int senderId = walletDAO.getUserIdByName(conn, senderName);
            int receiverId = walletDAO.getUserIdByName(conn, receiverName);

            // ❌ invalid user
            if (senderId == -1 || receiverId == -1) {
                System.out.println("Invalid user name");
                return;
            }

            // ✔ single connection used
            transferMoney(conn, senderId, receiverId, amount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}