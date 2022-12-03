package Controllers;

import com.example.stkcontrol.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DAO.UserDAO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void handleCadastro(ActionEvent event) {
        Application app = new Application();
        try {
            app.OpenScreen("CadastroUsuario");
            txtUser.getScene().getWindow().hide();
        } catch (IOException e) {
            //log
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleLogin(ActionEvent event) throws SQLException {
        Application app = new Application();
        String user = txtUser.getText();
        String password = txtPassword.getText();
        UserDAO dao = new UserDAO();
        boolean login = dao.login(user, password);
        if(login){
            System.out.println("Correto");
            try {
                app.OpenScreen("Home");
            } catch (IOException e) {
                //log
                throw new RuntimeException(e);

            }
        }else{
            System.out.println("Errado");

        }
    }

}
