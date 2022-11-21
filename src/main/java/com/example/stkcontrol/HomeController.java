package com.example.stkcontrol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController {
    Application app = new Application();

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnCadastro;

    @FXML
    void cadastro(ActionEvent event) {
        try {
            app.CastroProduct();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void edit(ActionEvent event) {
        try {
            app.EditProduct();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
