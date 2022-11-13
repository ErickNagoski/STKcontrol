package model.DAO;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static Connection con = null;

    public UserDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public boolean login(String username, String password){
        String sql = "SELECT username, senha FROM usuario WHERE username = ? AND senha  = ?;";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return false;
    }

    public boolean cadastro() throws SQLException {
        String sql = "INSERT INTO usuario (username, email, senha) VALUES (?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, "username");
            stmt.setString(2, "email");
            stmt.setString(3, "senha");
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean verificaEmail(String email) throws SQLException {
        String sql = "SELECT email FROM tbCliente";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("email").equals(email)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return false;
    }
}
