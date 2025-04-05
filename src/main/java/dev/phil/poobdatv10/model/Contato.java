package dev.phil.poobdatv10.model;

public class Contato {

    private final String nome;
    private final String sobrenome;
    private final String email;
    private final String telefone;
    private final String assunto;
    private final String mensagem;

    private Contato(ContatoBuilder builder) {
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.email = builder.email;
        this.telefone = builder.telefone;
        this.assunto = builder.assunto;
        this.mensagem = builder.mensagem;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    // Classe Interna Construtora
    public static class ContatoBuilder {

        private String nome;
        private String sobrenome;
        private String email;
        private String telefone;
        private String assunto;
        private String mensagem;

        public ContatoBuilder() {
            // vazio
        }

        public ContatoBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ContatoBuilder setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public ContatoBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ContatoBuilder setTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ContatoBuilder setAssunto(String assunto) {
            this.assunto = assunto;
            return this;
        }

        public ContatoBuilder setMensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public Contato build() {
            return new Contato(this);
        }
    }
}
