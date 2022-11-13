package model.DAO;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {
    private static Connection con = null;

    public VendaDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void simularVenda() throws SQLException {
        String sql = "INSERT INTO venda(valor, `data`, cliente_id) VALUES (?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, String.valueOf(20));
            stmt.setString(2, "2022-10-03");
            stmt.setString(3, String.valueOf(1));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
