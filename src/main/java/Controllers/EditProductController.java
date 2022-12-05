package Controllers;

import Class.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.DAO.ProdutoDAO;
import util.AlertDialog;
import util.Logs;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import Class.ErrorLog;
/**
 *
 * @author Erick Nagoski
 */
public class EditProductController {

    @FXML
    private TextField txtFornecedor;

    @FXML
    private Text lblEndereco;

    @FXML
    private Text lblDescricao;

    @FXML
    private TextField txtCusto;

    @FXML
    private TextField txtEndereco;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtCode;

    @FXML
    private Text lblFornecedor;

    @FXML
    private TextField txtDescricao;

    @FXML
    private Text lblEstoque;

    @FXML
    private TextField txtEstoque;

    @FXML
    private Text lblIpi;

    @FXML
    private Text lblUm;

    @FXML
    private Text lblPreco;

    @FXML
    private TextField txtIpi;

    @FXML
    private Text lblCusto;

    @FXML
    private TextField txtUm;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtPreco;

    @FXML
    private Pane pane;

    @FXML
    void handleSearch(ActionEvent event) throws SQLException, IOException {
        String codigo = txtCode.getText();
        ProdutoDAO dao = new ProdutoDAO();

        Produto p = null;
        try {
            p = dao.buscarProduto(codigo);
        } catch (SQLException e) {
            Logs.writeLog(new ErrorLog("Não foi possivel buscar o produto"));

            throw new RuntimeException(e);
        }

        if (p != null){
            pane.setVisible(true);
            txtCusto.setText(String.valueOf(p.getPreco_custo()));
            txtDescricao.setText(p.getDescricao());
            txtEndereco.setText(p.getEndereco());
            txtEstoque.setText(String.valueOf(p.getEstoque()));
            txtIpi.setText(String.valueOf(p.getIpi()));
            txtFornecedor.setText(p.getCodigo_fornecedor());
            txtPreco.setText(String.valueOf(p.getPreco_venda()));
            txtUm.setText(p.getUnidade_media());
        }else{
            AlertDialog.SimpleDialog("","Nenhum produto encontrado!");
        }
    }
    @FXML
    void submit(ActionEvent event) throws SQLException {
        Produto p = new Produto(
                txtCode.getText(),
                txtDescricao.getText(),
                Float.parseFloat(txtCusto.getText()),
                Float.parseFloat(txtPreco.getText()),
                Float.parseFloat(txtIpi.getText()),
                txtFornecedor.getText(),
                Float.parseFloat(txtEstoque.getText()),
                txtEndereco.getText(),
                txtUm.getText());
        ProdutoDAO dao = new ProdutoDAO();

        dao.atualizaProduto(p);
        AlertDialog.SimpleDialog("Sucesso", "Produto Atualizado com sucesso.");
        txtCode.getScene().getWindow().hide();
    }

}
