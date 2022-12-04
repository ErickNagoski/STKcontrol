package Controllers;

import Class.Usuario;
import com.example.stkcontrol.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DAO.UserDAO;
import util.AlertDialog;

import java.io.IOException;
import java.sql.SQLException;

public class CadastroUsuarioController {
    private static UserDAO dao;
    private static Application app;

    public CadastroUsuarioController() throws SQLException {
        this.dao = new UserDAO();
        this.app = new Application();
    }

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnCadastro;

    @FXML
    void handleCadastro(ActionEvent event) throws SQLException {
        String nome = txtUser.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        Usuario user = new Usuario(nome,email, senha);

        if(checkValidyUser(nome,email)){
            try {
                dao.cadastro(user);
                btnCadastro.setVisible(false);
                btnCancel.setVisible(false);
                btnLogin.setVisible(true);
                AlertDialog.SimpleDialog("Sucesso","Cadastro realizado!");
            } catch (SQLException e) {
                AlertDialog.SimpleDialog("Erro","Não foi possivel realizar o cadastro!");
                txtUser.getScene().getWindow().hide();
                //log não foi possivel cadastrar
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void handleCancel(ActionEvent event) {
        txtUser.getScene().getWindow().hide();
        try {
            app.OpenScreen("Login");
        } catch (IOException e) {
            // log não conseguiu abrir tela
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleLogin(ActionEvent event) {
        boolean login  = dao.login(txtUser.getText(), txtSenha.getText());
        if (login){
            try {
                app.OpenScreen("Home");
            } catch (IOException e) {
                // log não conseguiu abrir tela
                throw new RuntimeException(e);
            }
        }
    }

    private static boolean checkValidyUser(String username, String email){
        boolean validyUser = true;
        try {
            if(dao.verificaUsuario(username)){
                AlertDialog.SimpleDialog("Nome de usuário","O nome de usuário "+username+" já está em uso.");
                validyUser = false;
            }

            if(dao.verificaEmail(email)){
                validyUser = false;
                AlertDialog.SimpleDialog("","E-mail já está cadastrado!");
            }
        } catch (SQLException e) {
            //log Não foi possivel validar dados
            throw new RuntimeException(e);
        }

        return validyUser;
    }

}
