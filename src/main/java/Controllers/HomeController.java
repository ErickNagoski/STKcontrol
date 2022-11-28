package Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import Class.Produto;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.ProdutoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomeController {
    @FXML
    private TableView<Produto> table;
    @FXML
    private TableColumn<Produto,String> colCodigo;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<Produto,String> colEndereco;

    @FXML
    private TableColumn<Produto,String> colDescricao;

    @FXML
    private Button btnExportar;

    @FXML
    private TableColumn<Produto,String> ColMovimento;

    @FXML
    private TableColumn<Produto,String> colQuantidade;

    @FXML
    void handleEditar(ActionEvent event) {

    }

    @FXML
    void handleVenda(ActionEvent event) {

    }

    @FXML
    void handleCadastro(ActionEvent event) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        ArrayList<Produto> produtos = dao.buscarTodosProdutos();
        System.out.println(produtos.size());
       // colCodigo.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));
        //colDescricao.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));
       // colEndereco.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));
        //colQuantidade.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));

      //  table.setItems(FXCollections.observableArrayList(produtos));
       // table.getColumns().addAll(colCodigo,colDescricao,colQuantidade,colEndereco);
    }

    @FXML
    void exportTable(ActionEvent event) {

    }

}

