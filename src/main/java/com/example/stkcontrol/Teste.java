package com.example.stkcontrol;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Teste implements Initializable {

    @FXML
    private TableColumn<User, String> colName;

    @FXML
    private TableColumn<User, String> animal;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> colAge;

    ObservableList<User> list = FXCollections.observableArrayList(
            new User("erick", 20,"dog"),
            new User("abc", 21,"cat"),
            new User("mark", 21,"cat")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<User,Integer>("age"));
        animal.setCellValueFactory(new PropertyValueFactory<User,String>("animal"));

        table.setItems(list);
    }
}

