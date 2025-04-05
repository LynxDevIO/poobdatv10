package dev.phil.poobdatv10.service;

import dev.phil.poobdatv10.model.Contato;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public final class GerenciadorDeContatos {
    private static GerenciadorDeContatos instance;

    private GerenciadorDeContatos() {
        iniciar();
    }

    private static void iniciar() {
        if (!Files.exists(Paths.get("contatos.csv"))) {
            try {
                Files.createFile(Paths.get("contatos.csv"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Arquivo contatos.csv já existe.");
        }
    }

    public static GerenciadorDeContatos getInstance() {
        if (instance == null) {
            synchronized (GerenciadorDeContatos.class) {
                if (instance == null) {
                    instance = new GerenciadorDeContatos();
                }
            }
        }
        return instance;
    }

    public void registrar(Contato contato) {
        StringBuilder str = new StringBuilder();
        str.append("\"").append(contato.getNome()).append("\"").append(",");
        str.append("\"").append(contato.getSobrenome()).append("\"").append(",");
        str.append("\"").append(contato.getEmail()).append("\"").append(",");
        str.append("\"").append(contato.getTelefone()).append("\"").append(",");
        str.append("\"").append(contato.getAssunto()).append("\"").append(",");
        str.append("\"").append(contato.getMensagem()).append("\"").append(",");
        str.append("\n");

        Path path = Paths.get("contatos.csv");
        if (Files.exists(path)) {
            try {
                Files.writeString(path, str.toString(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
