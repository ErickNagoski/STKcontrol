package com.example.stkcontrol;

import Class.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DAO.ProdutoDAO;
import util.AlertDialog;

import java.sql.SQLException;

public class ProdutoController {
    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtIpi;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtCusto;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtUm;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtPreco;

    @FXML
    void Submit(ActionEvent event) throws SQLException {
        String codigo =txtCodigo.getText();

        Produto produto = new Produto(
                codigo,
                txtDescricao.getText(),
                Float.parseFloat(txtCusto.getText()),
                Float.parseFloat(txtPreco.getText()),
                Float.parseFloat(txtIpi.getText()),
                txtFornecedor.getText(),
                Float.parseFloat(txtQuantidade.getText()),
                txtEndereco.getText(),
                txtUm.getText());

        ProdutoDAO dao = new ProdutoDAO();

        if(dao.buscarProdutoInserido(codigo) == null){
            try {
                dao.adicionarNovoProduto(produto);
                AlertDialog.SimpleDialog("Sucesso", "Produto Cadastrado");
                txtCodigo.getScene().getWindow().hide();
            } catch (SQLException e) {
                AlertDialog.SimpleDialog("Erro", "Não foi possivel cadastrar o produto.");
                //log não foi possivel criar produto
                throw new RuntimeException(e);
            }
        }else{
            AlertDialog.SimpleDialog("Erro", "Já existem um produto com o código "+codigo+" cadastrado!");
        }
    }


    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void checkLength(ActionEvent event) {
        System.out.println(txtDescricao.getLength());
    }

}

