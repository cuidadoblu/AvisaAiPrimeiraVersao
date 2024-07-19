package modelo.entidade.comunidade;

import java.util.List;

import modelo.entidade.incidente.Incidente;

public class Comunidade  {
	
	private int idComunidade;
	private String nome;
	private Localidade localidade;
	private List<Incidente> incidentes;
	private List<Usuario> usuarios;
	
	public Comunidade(String nome, Localidade localidade) {
		setNome(nome);
		setLocalidade(localidade);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	public List<Incidente> getIncidente() {
		return incidentes;
	}
	
	public List<Usuario> getUsuario() {
		return usuarios;
	}
 
}
