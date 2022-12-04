package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.DAO.ProdutoDAO;
import Class.Produto;
import util.AlertDialog;

import java.sql.SQLException;

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
    void search(ActionEvent event) throws SQLException {
        String codigo = txtCode.getText();
        System.out.println(codigo);
        ProdutoDAO dao = new ProdutoDAO();

        Produto p = null;
        try {
            System.out.println("aqui");
            p = dao.buscarProduto(codigo);
            System.out.println(p);
        } catch (SQLException e) {
            //log não foi possivel buscar produto
            throw new RuntimeException(e);
        }
        System.out.println("produto"+p);
        System.out.println(p.getCodigo());

        if (p != null){
            txtCusto.setText(String.valueOf(p.getPreco_custo()));
            txtDescricao.setText(p.getDescricao());
            txtEndereco.setText(p.getEndereco());
            txtEstoque.setText(String.valueOf(p.getEstoque()));
            txtIpi.setText(String.valueOf(p.getIpi()));
            txtFornecedor.setText(p.getCodigo_fornecedor());
            txtPreco.setText(String.valueOf(p.getPreco_venda()));
            txtUm.setText(p.getUnidade_media());
        }

    }

    @FXML
    void handleSearch(ActionEvent event) throws SQLException {
        String codigo = txtCode.getText();
        System.out.println(codigo);
        ProdutoDAO dao = new ProdutoDAO();

        Produto p = null;
        try {
            System.out.println("aqui");
            p = dao.buscarProduto(codigo);
            System.out.println(p);
        } catch (SQLException e) {
            //log não foi possivel buscar produto
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
