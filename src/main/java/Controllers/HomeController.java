package Controllers;

import Class.ErrorLog;
import com.example.stkcontrol.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.ProdutoDAO;
import util.AlertDialog;
import util.Excel;
import util.Logs;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 *
 * @author Erick Nagoski
 */
public class HomeController implements Initializable {
    Application app = new Application();
    ProdutoDAO    dao = new ProdutoDAO();
    ObservableList<ProductTable> produtos;

    @FXML
    private TableColumn<ProductTable, String> codigo;

    @FXML
    private TableColumn<ProductTable, String> endereco;
    @FXML
    private TableColumn<ProductTable, String> unidMedida;
    @FXML
    private TableColumn<ProductTable, String> fornecedor;
    @FXML
    private TableColumn<ProductTable, String> movimento;

    @FXML
    private TableColumn<ProductTable, Double> quantidade;

    @FXML
    private TableView<ProductTable> table;

    @FXML
    private TableColumn<ProductTable, String> descricao;


    public HomeController() throws SQLException {
    }

    @FXML
    void handleEditar(ActionEvent event) {
        try {
            app.OpenScreen("EditProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleVenda(ActionEvent event) {
        int selectedId = table.getSelectionModel().getSelectedIndex();
        String productCode = produtos.get(selectedId).getCodigo();
        double quantidade = produtos.get(selectedId).getQuantidade();

        if(quantidade>0){
        dao.simulaVenda(productCode,quantidade/3);
        carregaTabela();
        }else{
            AlertDialog.SimpleDialog("Sem estoque", "Produto indisponivel.");
        }

    }

    @FXML
    void handleCadastro(ActionEvent event) throws SQLException {
        try {
            app.OpenScreen("Produto");
        } catch (IOException e) {
            ErrorLog error = new ErrorLog("Eror cadastrar produto!\n"+e.toString());
            try {
                Logs.writeLog(error);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);

        }
    }

    @FXML
    void exportTable(ActionEvent event) throws SQLException {
        ArrayList<ProductTable> produtos = dao.buscaProdutos();
        Excel.GeraExcel(produtos);
    }
    @FXML
    void handleRemover(ActionEvent event) throws IOException {
        int selectedId = table.getSelectionModel().getSelectedIndex();
        String productCode = produtos.get(selectedId).getCodigo();
        try {
            dao.removerProduto(productCode);
            produtos.remove(selectedId);
        } catch (SQLException e) {
            Logs.writeLog(new ErrorLog("Erro ao remover produto"));
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        codigo.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("codigo"));
        descricao.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("descricao"));
        endereco.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("endereco"));
        quantidade.setCellValueFactory(new PropertyValueFactory<ProductTable,Double>("quantidade"));
        unidMedida.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("unidadeMedida"));
        fornecedor.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("fornecedor"));
        movimento.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("movimento"));

        carregaTabela();
    }
    @FXML
    void handleExit(ActionEvent event) throws IOException {
        table.getScene().getWindow().hide();
        app.OpenScreen("Login");
    }
    @FXML
    void handleUpdate(ActionEvent event) {
        carregaTabela();
    }

    private void carregaTabela(){
        produtos = dao.carregaProdutos();
        table.setItems(produtos);
    }


}

