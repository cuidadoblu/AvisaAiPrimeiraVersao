package AvisaAi.modelo.entidade.comunidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "comunidade")
public class Comunidade implements Serializable {

	private static final long serialVersionUID = -9216497520338583127L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTIFY)
	@Column(name = "id_comunidade")
	private Long id;
	
	@Column(name = "nome_comunidade", lenght = 30, nullable = false)
	private String nome;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_localidade", nullable = false)
	private Localidade localidade;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_incidente", nullable = false)
	private List<Incidente> incidentes;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private List<Usuario> usuarios;
	
	public Comunidade() {}
	
	public Comunidade(String nome, Localidade localidade) {
		setNome(nome);
		setLocalidade(localidade);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comunidade other = (Comunidade) obj;
		return Objects.equals(id, other.id);
	}
 
}
