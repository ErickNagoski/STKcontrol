package com.example.stkcontrol;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


//    public void Home() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Home.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
//    }

//    public void EditProduct() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("EditProduct.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
//    }
// public void CastroProduct() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Produto.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        launch();
    }

//    public void CadastroUsuario() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("CadastroUsuario.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
//    }

    public void OpenScreen(String screenName)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(screenName+".fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}