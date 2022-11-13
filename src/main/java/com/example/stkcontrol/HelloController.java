package com.example.stkcontrol;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import connection.ConnectionFactory;
import model.DAO.ProdutoDAO;
import model.DAO.VendaDAO;

import java.sql.Connection;
import java.sql.SQLException;

import static connection.ConnectionFactory.closeConnection;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            //VendaDAO dao = new VendaDAO();
            //dao.simularVenda();
            ProdutoDAO dao = new ProdutoDAO();
            dao.adicionarNovoProduto();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}