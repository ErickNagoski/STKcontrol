package connection;

import java.sql.*;

/**
 *
 * @author Erick Nagoski
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL =  "jdbc:mysql://localhost:3306/STKcontrol?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() throws SQLException{

        try {
            Class.forName(DRIVER);
            System.out.println("Conectado");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void closeConnection (Connection com){
        if(com != null){
            try {
                com.close();
                System.out.println("Fechado");
            } catch (SQLException ex) {
                System.err.println("Erro "+ex);
            }
        }
    }
public static void closeConnection (Connection com, PreparedStatement stmt) throws SQLException{
        if(stmt != null){
            stmt.close();
        }
        closeConnection(com);
    }
public static void closeConnection (Connection com, PreparedStatement stmt, ResultSet rs) throws SQLException{
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro "+ex);
            }
        }
        closeConnection(com, stmt);
    }
}
