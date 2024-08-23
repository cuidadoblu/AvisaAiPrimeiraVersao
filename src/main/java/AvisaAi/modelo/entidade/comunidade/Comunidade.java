package AvisaAi.modelo.entidade.comunidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import AvisaAi.modelo.entidade.foto.Foto;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "comunidade")
public class Comunidade implements Serializable {

	private static final long serialVersionUID = -9216497520338583127L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comunidade")
	private Long id;
	
	@Column(name = "nome_comunidade", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "descricao_comunidade", length = 950)
	private String descricao;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_localidade", referencedColumnName = "id_localidade")
	private Localidade localidade;
	
	@Column(name = "foto_perfil_comunidade")
	private Foto fotoPerfil;
	
	@OneToMany(mappedBy = "comunidade")
	private List<Incidente> incidentes;
	
	@ManyToMany(mappedBy = "comunidadesAcompanhadas")
	private List<Usuario> usuarios;
	
	public Comunidade() {}
	
	public Comunidade(String nome, String descricao, Localidade localidade, Foto fotoPerfil) {
		setNome(nome);
		setDescricao(descricao);
		setLocalidade(localidade);
		setFotoPerfil(fotoPerfil); 
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	public Foto getFotoPerfil() {
		return fotoPerfil;
	}
	
	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
//	public List<Incidente> getIncidente() {
//		return incidentes;
//	}
//	
//	public List<Usuario> getUsuario() {
//		return usuarios;
//	}

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
