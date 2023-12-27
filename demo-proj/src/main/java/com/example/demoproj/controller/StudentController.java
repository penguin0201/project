package com.example.demoproj.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentController {

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TextField addressField;

    @FXML
    private TableColumn<?, ?> birthdayColumn;

    @FXML
    private DatePicker birthdayPick;

    @FXML
    private TableColumn<?, ?> cardColumn;

    @FXML
    private TextField cardField;

    @FXML
    private TableColumn<?, ?> classNameColumn;

    @FXML
    private TextField classNameField;

    @FXML
    private TableView<?> dataTableView;

    @FXML
    private TableColumn<?, ?> deptColumn;

    @FXML
    private TextField deptField;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TextField emailField;

    @FXML
    private TableColumn<?, ?> genderColumn;

    @FXML
    private ComboBox<?> genderComboBox;

    @FXML
    private TableColumn<?, ?> majorColumn;

    @FXML
    private TextField majorField;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TableColumn<?, ?> numColumn;

    @FXML
    private TextField numField;

    @FXML
    private TextField numNameTextField;

    @FXML
    private TableColumn<?, ?> phoneColumn;

    @FXML
    private TextField phoneField;

    @FXML
    void onAddButtonClick(ActionEvent event) {

    }

    @FXML
    void onDeleteButtonClick(ActionEvent event) {

    }

    @FXML
    void onQueryButtonClick(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClick(ActionEvent event) {

    }

}
