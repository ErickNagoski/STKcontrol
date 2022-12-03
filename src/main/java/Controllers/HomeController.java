package Controllers;

import com.example.stkcontrol.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import Class.Produto;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.ProdutoDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Class.TableEstoque;

public class HomeController implements Initializable {
    @FXML
    private TableView<TableEstoque> table;
    @FXML
    private TableColumn<TableEstoque,String> colCodigo;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<TableEstoque,String> colEndereco;

    @FXML
    private TableColumn<TableEstoque,String> colDescricao;

    @FXML
    private Button btnExportar;

    @FXML
    private TableColumn<TableEstoque,String> ColMovimento;

    @FXML
    private TableColumn<TableEstoque,String> colQuantidade;

    @FXML
    void handleEditar(ActionEvent event) {

    }

    @FXML
    void handleVenda(ActionEvent event) {

    }

    @FXML
    void handleCadastro(ActionEvent event) throws SQLException {
        Application app = new Application();
        try {
            app.OpenScreen("Produto");
        } catch (IOException e) {
            //log
            throw new RuntimeException(e);

        }

       // colCodigo.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));
        //colDescricao.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));
       // colEndereco.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));
        //colQuantidade.setCellValueFactory(new PropertyValueFactory<Produto,String>("codigo"));

      //  table.setItems(FXCollections.observableArrayList(produtos));
       // table.getColumns().addAll(colCodigo,colDescricao,colQuantidade,colEndereco);
    }

    @FXML
    void exportTable(ActionEvent event) throws SQLException {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProdutoDAO dao = null;
        try {
            dao = new ProdutoDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<TableEstoque> produtos = dao.carregaProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }
        //colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        //colCodigo.setCellValueFactory(new PropertyValueFactory<TableEstoque,String>("codigo"));
       // colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        //colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        //colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
       table.setItems(produtos);
    }

}

