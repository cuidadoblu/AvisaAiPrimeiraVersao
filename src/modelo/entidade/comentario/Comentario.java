package modelo.entidade.comentario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.incidente.Incidente;

public class Comentario {
    private int id_comentario;
    private String conteudo;
    private LocalDate data;
    private Usuario usuario;
    private Incidente incidente;
    private List<Resposta> respostas;

    public Comentario(int id_comentario, String conteudo, LocalDate data, Usuario usuario,Incidente incidente) {
        this.id_comentario = id_comentario;
        this.conteudo = conteudo;
        this.data = data;
        this.usuario = usuario;
        this.setIncidente(incidente);
        this.respostas = new ArrayList<>();
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

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void addResposta(Resposta resposta) {
        respostas.add(resposta);
    }

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}
	
	public void cadastrarComentario() {
    }

    public boolean deletarComentario() {
    }

    public boolean editarComentario() {
    }
}
