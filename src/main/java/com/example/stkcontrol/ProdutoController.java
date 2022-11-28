package com.example.stkcontrol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DAO.ProdutoDAO;

import java.sql.SQLException;
import Class.Produto;

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
        Produto produto = new Produto(
                txtCodigo.getText(),
                txtDescricao.getText(),
                Float.parseFloat(txtCusto.getText()),
                Float.parseFloat(txtPreco.getText()),
                Float.parseFloat(txtIpi.getText()),
                txtFornecedor.getText(),
                Float.parseFloat(txtQuantidade.getText()),
                txtEndereco.getText(),
                txtUm.getText());

        ProdutoDAO dao = new ProdutoDAO();
        dao.adicionarNovoProduto(produto);
    }


    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void checkLength(ActionEvent event) {
        System.out.println(txtDescricao.getLength());
    }

}

