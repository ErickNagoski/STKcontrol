package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.ProdutoDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProdutosController implements Initializable {

    @FXML
    private TableColumn<ProductTable, String> codigo;

    @FXML
    private TableColumn<ProductTable, String> endereco;

    @FXML
    private TableColumn<ProductTable, Double> quantidade;

    @FXML
    private TableView<ProductTable> table;

    @FXML
    private TableColumn<ProductTable, String> descricao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProdutoDAO dao = null;
        try {
            dao = new ProdutoDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<ProductTable> produtos = dao.carregaProdutos();

        codigo.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("codigo"));
        descricao.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("descricao"));
        endereco.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("endereco"));
        quantidade.setCellValueFactory(new PropertyValueFactory<ProductTable,Double>("quantidade"));

        table.setItems(produtos);
    }
}
