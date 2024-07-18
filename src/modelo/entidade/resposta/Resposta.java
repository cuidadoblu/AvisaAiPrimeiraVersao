package modelo.entidade.resposta;

import java.time.LocalDate;

public class Resposta {
    private int id_resposta;
    private String conteudo;
    private LocalDate data;
    private Usuario usuario;

    public Resposta(int id_resposta, String conteudo, LocalDate data, Usuario usuario) {
        this.id_resposta = id_resposta;
        this.conteudo = conteudo;
        this.data = data;
        this.usuario = usuario;
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void cadastrarResposta(Resposta resposta) {
    }

    public boolean deletarResposta(Resposta resposta) {
    }

    public void editarResposta(String novoConteudo) {
        this.conteudo = novoConteudo;
    }
}
