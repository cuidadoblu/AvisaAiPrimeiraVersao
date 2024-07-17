package modelo.entidade.incidente;

import java.time.LocalDateTime;

import modelo.entidade.comunidade.Comunidade;

public class Incidente extends Comunidade{
	
	private int idIncidente;
	private String descricao;
	private LocalDateTime data;
	private Categoria categoria;
	private Comunidade comunidade;
	private Usuario usuario;
	private Localidade localidade;
	private Situacao situacao;
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData (LocalDateTime data) {
		this.data = data;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria (Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Comunidade getComunidade() {
		return comunidade;
	}
	
	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	

}
