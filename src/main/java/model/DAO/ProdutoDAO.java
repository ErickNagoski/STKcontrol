package model.DAO;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private static Connection con = null;

    public ProdutoDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void adicionarNovoProduto(String cd, String descricao) throws SQLException {
        String sql = "INSERT INTO produto(codigo, descricao, preco_custo, preco_venda, ipi, unidade_medida, multiplo, endereco, fornecedor_id) values (?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, cd);
            stmt.setString(2, descricao);
            stmt.setString(3, String.valueOf(10));
            stmt.setString(4, String.valueOf(26.20));
            stmt.setString(5, String.valueOf(3));
            stmt.setString(6, "Kg");
            stmt.setString(7, String.valueOf(1));
            stmt.setString(8, "1.2.1");
            stmt.setString(9, "1");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void buscarProduto(String codigo) throws SQLException {
        String sql = "SELECT * FROM stkcontrol.produto WHERE codigo = ?;";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                    System.out.println(rs.getString("descricao"));
                    System.out.println(rs.getString("preco_custo"));
                    System.out.println(rs.getString("preco_venda"));
                    System.out.println(rs.getString("ipi"));
                    System.out.println(rs.getString("unidade_medida"));
                    System.out.println(rs.getString("multiplo"));
                    System.out.println(rs.getString("endereco"));
                    System.out.println(rs.getString("fornecedor_id"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
    }

    public void removerProduto(String codigo) throws SQLException {
        String sql = "DELETE FROM produto WHERE codigo = ?;";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, "123");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void alterarEstoque(String codigo, double quantidade){

    }

    public void buscarTodosProdutos(){

    }


}
