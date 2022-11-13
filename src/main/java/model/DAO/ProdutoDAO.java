package model.DAO;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private static Connection con = null;

    public ProdutoDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void adicionarNovoProduto() throws SQLException {
        String sql = "INSERT INTO produto(codigo, descricao, preco_custo, preco_venda, ipi, unidade_medida, multiplo, endereco, fornecedor_id) values (?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, "5");
            stmt.setString(2, "produto de teste");
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

    public void buscarProduto(String codigo){

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
