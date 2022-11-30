package Controllers;

        import com.example.stkcontrol.Application;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import Class.Usuario;
        import model.DAO.UserDAO;

        import java.sql.SQLException;

public class CadastroUsuarioController {

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtEmail;

    @FXML
    void handleCadastro(ActionEvent event) throws SQLException {
        Usuario user = new Usuario(txtUser.getText(),txtEmail.getText(),txtSenha.getText());
        UserDAO dao = new UserDAO();
        dao.cadastro(user);
    }

    @FXML
    void handleCancel(ActionEvent event) {
        txtUser.getScene().getWindow().hide();
    }

}
