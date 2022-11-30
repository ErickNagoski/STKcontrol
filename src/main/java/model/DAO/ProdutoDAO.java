package model.DAO;

import connection.ConnectionFactory;
import Class.Produto;
import Class.TableEstoque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    private static Connection con = null;

    public ProdutoDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void adicionarNovoProduto(Produto p) throws SQLException {
        String sql = "INSERT INTO produto(codigo, descricao, preco_custo, preco_venda, ipi, unidade_medida, fornecedor_id) values (?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;
        int rowCount = 0;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, String.valueOf(p.getPreco_custo()));
            stmt.setString(4, String.valueOf(p.getPreco_venda()));
            stmt.setString(5, String.valueOf(p.getIpi()));
            stmt.setString(6, p.getUnidade_media());
            stmt.setString(7, p.getCodigo_fornecedor());
           rowCount  = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);

            ConnectionFactory.closeConnection(con, stmt);
        }

        if(rowCount>0) {
            Produto produtoInserido = buscarProdutoInserido(p.getCodigo());
            System.out.println(produtoInserido.getProduto_id());
        }

        String estqSQL = "INSERT INTO estoque(produto_id, endereco, quantidade, ultimo_movimento) values (\n" +
                "(SELECT produto_id FROM produto WHERE codigo = '"+p.getCodigo()+"'),?,?,?)";

        try {
            stmt = (PreparedStatement) con.prepareStatement(estqSQL);
            stmt.setString(1, p.getEndereco());
            stmt.setString(2, String.valueOf(p.getEstoque()));
            stmt.setString(3, "28-11-2022");
            System.out.println(stmt);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            //log
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Produto buscarProdutoInserido(String codigo) throws SQLException {
        String sql = "SELECT * FROM stkcontrol.produto WHERE codigo = ?;";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                Produto p = new Produto(
                        Integer.parseInt(rs.getString("produto_id")),
                        rs.getString("codigo"),
                        rs.getString("descricao"),
                        Float.parseFloat(rs.getString("preco_custo")),
                        Float.parseFloat(rs.getString("preco_venda")),
                        Float.parseFloat(rs.getString("ipi")),
                        rs.getString("fornecedor_id"),
                        rs.getString("unidade_medida")
                    );
                return p;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;
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

    public ArrayList<Produto> buscarTodosProdutos() {
        String sql = "SELECT \n" +
                "\t\tp.*, \n" +
                "\t\te.endereco, \n" +
                "\t\tf.codigo as codigo_fornecedor, \n" +
                "        e.quantidade as estoque \n" +
                "\tFROM stkcontrol.produto p \n" +
                "inner join fornecedor f \n" +
                "\ton p.fornecedor_id = f.fornecedor_id\n" +
                "inner join estoque e \n" +
                "\ton p.produto_id = e.produto_id;";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            ArrayList<Produto> produtos = new ArrayList<Produto>();
            while (rs.next()) {
                Produto p = new Produto(
                        Integer.parseInt(rs.getString("produto_id")),
                        rs.getString("codigo"),
                        rs.getString("descricao"),
                        Float.parseFloat(rs.getString("preco_custo")),
                        Float.parseFloat(rs.getString("preco_venda")),
                        Float.parseFloat(rs.getString("ipi")),
                        rs.getString("codigo_fornecedor"),
                        Float.parseFloat(rs.getString("estoque")),
                        rs.getString("endereco"),
                        rs.getString("unidade_medida")
                );
                produtos.add(p);

            }
            return produtos;

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;
    }


    public ObservableList<TableEstoque> carregaProdutos() {
        ObservableList<TableEstoque> produtos = FXCollections.observableArrayList();
        String sql = "SELECT \n" +
                "\t\tp.*, \n" +
                "\t\te.endereco, \n" +
                "\t\tf.codigo as codigo_fornecedor, \n" +
                "        e.quantidade as estoque \n" +
                "\tFROM stkcontrol.produto p \n" +
                "inner join fornecedor f \n" +
                "\ton p.fornecedor_id = f.fornecedor_id\n" +
                "inner join estoque e \n" +
                "\ton p.produto_id = e.produto_id;";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TableEstoque data = new TableEstoque(
                        rs.getString("codigo"),
                        rs.getString("descricao"),
                        rs.getString("estoque"),
                        rs.getString("endereco")

                );
                produtos.add(data);
            }
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return produtos;
    }
}
