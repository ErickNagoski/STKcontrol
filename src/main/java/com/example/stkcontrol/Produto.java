package com.example.stkcontrol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DAO.ProdutoDAO;

import java.sql.SQLException;

public class Produto {
    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescricao;
    @FXML
    void Search(ActionEvent event) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.adicionarNovoProduto(txtCodigo.getText(), txtDescricao.getText());
    }

}

