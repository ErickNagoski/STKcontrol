package com.example.stkcontrol;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static connection.ConnectionFactory.closeConnection;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        Application app = new Application();

        app.OpenScreen("");
    }


}