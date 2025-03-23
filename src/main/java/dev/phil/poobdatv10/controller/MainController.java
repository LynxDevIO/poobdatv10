package dev.phil.poobdatv10.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField formularioNome;
    @FXML
    private TextField formularioSobrenome;
    @FXML
    private TextField formularioEmail;
    @FXML
    private TextField formularioTelefone;
    @FXML
    private ChoiceBox<String> formularioAssunto;
    @FXML
    private TextArea formularioMensagem;

    @FXML
    private void formularioEnviarOnClick() {
        // TODO: falta implementar
    }
}