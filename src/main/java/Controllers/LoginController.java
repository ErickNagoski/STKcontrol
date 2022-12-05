package Controllers;

import com.example.stkcontrol.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DAO.UserDAO;

import java.io.IOException;
import java.sql.SQLException;
import Class.ErrorLog;
import org.apache.poi.ss.formula.functions.Log;
import util.AlertDialog;
import util.Logs;
/**
 *
 * @author Vitória
 */
public class LoginController {
    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void handleCadastro(ActionEvent event) throws IOException {
        Application app = new Application();
        try {
            app.OpenScreen("CadastroUsuario");
            txtUser.getScene().getWindow().hide();
        } catch (IOException e) {
            Logs.writeLog(new ErrorLog("Erro cadastrar usuário"));
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleLogin(ActionEvent event) throws SQLException, IOException {
        Application app = new Application();
        String user = txtUser.getText();
        String password = txtPassword.getText();
        UserDAO dao = new UserDAO();
        boolean login = dao.login(user, password);
        if(login){
            ErrorLog log = new ErrorLog("Usuário "+ user+" Logou.");
            Logs.writeLog(log);
            try {
                app.OpenScreen("Home");
                txtUser.getScene().getWindow().hide();
            } catch (IOException e) {
                Logs.writeLog(new ErrorLog("Erro de login"));
                throw new RuntimeException(e);
            }
        }else{
            AlertDialog.SimpleDialog("Incorreto", "Usuário ou senha errado!");
        }
    }

}
