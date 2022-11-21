package com.example.stkcontrol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DAO.ProdutoDAO;

import java.sql.SQLException;

public class Produto {
    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtCusto;

    @FXML
    private TextField txtIpi;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtUm;

    @FXML
    private TextField txtMultiplo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtPreco;

    @FXML
    void Submit(ActionEvent event) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.adicionarNovoProduto(txtCodigo.getText(), txtDescricao.getText());
    }

    @FXML
    void checkLength(ActionEvent event) {
        System.out.println(txtDescricao.getLength());
    }

}

