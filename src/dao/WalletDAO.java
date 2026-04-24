package dao;

import java.sql.*;

public class WalletDAO {

    public double getBalance(Connection conn, int userId) throws Exception {
        String query = "SELECT balance FROM wallet WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDouble("balance");
        }
        return 0;
    }

    public void updateBalance(Connection conn, int userId, double amount) throws Exception {
        String query = "UPDATE wallet SET balance = balance + ? WHERE user_id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setInt(2, userId);
        ps.executeUpdate();
    }

    public int getUserIdByName(Connection conn, String name) throws Exception {
        String query = "SELECT user_id FROM users WHERE name=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("user_id");
        }
        return -1;
    }
}