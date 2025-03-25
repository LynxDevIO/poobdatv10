package dev.phil.poobdatv10.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

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
        // limita o telefone para 11 dígitos
        // TODO: não sei fazer ainda

        // inicializa o campo de assuntos
        List<String> assuntos = new ArrayList<>(){{
            add("Assunto 1");
            add("Assunto 2");
            add("Assunto 3");
            add("Assunto 4");
            add("Assunto 5");
        }};
        var obsAssuntos = FXCollections.observableArrayList(assuntos);
        formularioAssunto.setItems(obsAssuntos);
        formularioAssunto.setValue(obsAssuntos.getFirst());
    }

    @FXML
    private void formularioEnviarOnClick() {
        Alert alert;
        StringBuilder str = new StringBuilder();

        if (validarCampos(str)) {
            alert = new Alert(Alert.AlertType.INFORMATION, "Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Formulário enviado!");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao enviar formulário:\n" + str);
            alert.showAndWait();
        }
    }

    private boolean validarCampos(StringBuilder str) {
        boolean check = true;

        // se algum campo estiver vazio
        if (formularioNome.getText().isEmpty()
                || formularioSobrenome.getText().isEmpty()
                || formularioEmail.getText().isEmpty()
                || formularioTelefone.getText().isEmpty()
                || formularioMensagem.getText().isEmpty() ) {
            str.append("* Há algum campo vazio!\n");
            check = false;
        }
        // se nome não for feito apenas de letras
        if (!formularioNome.getText().matches("[\\p{L}\\s]+") || !formularioSobrenome.getText().matches("[\\p{L}\\s]+")) {
            str.append("* Nome e Sobrenome deve conter apenas letras!\n");
            check = false;
        }

        // valida o telefone 1
        if (!formularioTelefone.getText().matches("\\d+")) {
            str.append("Digite apenas números no campo Telefone!\n");
            check = false;
        }

        if (formularioTelefone.getText().length() < 10) {
            str.append("O telefone deve conter apenas 11 dígitos.");
        }

        // valida telefone 2

        // por último, valida o e-mail
        if (!validarEmail(formularioEmail.getText())) {
            str.append("* E-mail inválido.\n");
            check = false;
        }

        return check;
    }

    private boolean validarEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}