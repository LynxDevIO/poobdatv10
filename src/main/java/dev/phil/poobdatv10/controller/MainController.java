package dev.phil.poobdatv10.controller;

import dev.phil.poobdatv10.model.Contato;
import dev.phil.poobdatv10.service.GerenciadorDeContatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Assunto 1", "Assunto 2", "Assunto 3", "Assunto 4", "Assunto 5"
        );
        formularioAssunto.setItems(options);
        formularioAssunto.getSelectionModel().selectFirst();
    }

    @FXML
    private void formularioEnviarOnClick() {
        if (!validarCampos()) return;
        Contato contato = new Contato.ContatoBuilder()
                .setNome(formularioNome.getText())
                .setSobrenome(formularioSobrenome.getText())
                .setEmail(formularioEmail.getText())
                .setTelefone(formularioTelefone.getText())
                .setAssunto(formularioAssunto.getValue())
                .setMensagem(formularioMensagem.getText())
                .build();

        GerenciadorDeContatos.getInstance().registrar(contato);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Enviado!");
        alert.setHeaderText(null);
        alert.setContentText("Contato registrado com sucesso!");
        alert.showAndWait();

        limparCampos();
    }

    private void apararCampos() {
        formularioNome.setText(formularioNome.getText().trim().toUpperCase());
        formularioSobrenome.setText(formularioSobrenome.getText().trim().toUpperCase());
        formularioEmail.setText(formularioEmail.getText().trim().toLowerCase());
        formularioTelefone.setText(formularioTelefone.getText().trim());
        formularioAssunto.setValue(formularioAssunto.getValue());
        formularioMensagem.setText(formularioMensagem.getText().trim());
    }

    private boolean validarCampos() {
        StringBuilder erros = new StringBuilder();
        apararCampos();

        if (formularioNome.getText().isEmpty()
                || formularioSobrenome.getText().isEmpty()
                || formularioEmail.getText().isEmpty()
                || formularioTelefone.getText().isEmpty()
                || formularioAssunto.getValue().isEmpty()
                || formularioMensagem.getText().isEmpty()) {
            erros.append("Os campos devem ser preenchidos!");
            erros.append("\n");
        }

        if (formularioTelefone.getText().contains("[0-9]+") && formularioTelefone.getText().length() != 11) {
            erros.append("O campo de telefone deve ter 11 digitos sem caracteres especiais!");
            erros.append("\n");
        }

        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(formularioEmail.getText());
        if (!matcher.matches()) {
            erros.append("O email está num formato incorreto!");
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText(null);
        alert.setContentText(erros.toString());

        if (erros.toString().isEmpty()) {
            return true;
        } else {
            alert.showAndWait();
            return false;
        }
    }

    private void limparCampos() {
        formularioNome.clear();
        formularioSobrenome.clear();
        formularioEmail.clear();
        formularioTelefone.clear();
        formularioAssunto.getSelectionModel().selectFirst();
        formularioMensagem.clear();
    }
}