package dev.phil.poobdatv10.model;

public class Contato {

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String assunto;
    private String mensagem;

    private Contato(ContatoBuilder builder) {
        this.nome = builder.nome;
        this.sobrenome = builder.sobrenome;
        this.email = builder.email;
        this.telefone = builder.telefone;
        this.assunto = builder.assunto;
        this.mensagem = builder.mensagem;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    // Classe Interna Construtora
    public static class ContatoBuilder {

        private String nome;
        private String sobrenome;
        private String email;
        private String telefone;
        private String assunto;
        private String mensagem;

        public ContatoBuilder(String nome, String sobrenome, String email, String telefone, String assunto, String mensagem) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.email = email;
            this.telefone = telefone;
            this.assunto = assunto;
            this.mensagem = mensagem;
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
