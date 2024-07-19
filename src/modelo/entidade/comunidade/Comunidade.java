package modelo.entidade.comunidade;

import java.util.List;

import modelo.entidade.incidente.Incidente;

@Entity
@Table(name = "Comunidade")
public class Comunidade  {
	
	@Id
	@Column(name = "id_comunidade")
	private int idComunidade;
	
	@Column(name = "nome_comunidade")
	private String nome;
	
	@Column(name = "id_localidade")
	private Localidade localidade;
	
	@Column(name = "id_incidente")
	private List<Incidente> incidentes;
	
	@Column(name = "id_usuario")
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
