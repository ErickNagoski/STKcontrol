package com.example.stkcontrol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.DAO.ProdutoDAO;

import java.sql.SQLException;

public class EditProductController {

    @FXML
    private Text lblEndereco;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtCusto;

    @FXML
    private Text lblDescricao;

    @FXML
    private TextField txtEndereco;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtCode;

    @FXML
    private Text lblFornecedor;

    @FXML
    private TextField txtMultiplo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private Text lblEstoque;

    @FXML
    private TextField txtEstoque;

    @FXML
    private Text lblUm;

    @FXML
    private Text lblIpi;

    @FXML
    private Text lblPreco;

    @FXML
    private TextField txtIpi;

    @FXML
    private Text lblCusto;

    @FXML
    private TextField txtUm;

    @FXML
    private Text lblMultiplo;

    @FXML
    private TextField txtPreco;

    @FXML
    private Button btnSubmit;

    @FXML
    void search(ActionEvent event) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        try {
            dao.buscarProdutoInserido(txtCode.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void submit(ActionEvent event) {

    }


}
