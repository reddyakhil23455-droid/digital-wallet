package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionDAO {

    public void saveTransaction(Connection conn, int sender, int receiver, double amount, String status) throws Exception {

        String query = "INSERT INTO transactions (sender_id, receiver_id, amount, status) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, sender);
        ps.setInt(2, receiver);
        ps.setDouble(3, amount);
        ps.setString(4, status);

        ps.executeUpdate();
    }
}