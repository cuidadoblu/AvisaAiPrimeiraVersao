package AvisaAi.modelo.entidade.usuario;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.foto.Foto;
import AvisaAi.modelo.entidade.usuario.contato.Contato;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	@JoinTable(name = "usuarios_membros_comunidades", 
	joinColumns = @JoinColumn(name = "id_usuario"), 
	inverseJoinColumns = @JoinColumn(name = "id_comunidade"))
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_foto", referencedColumnName = "id_foto")
	private Foto fotoPerfil;
	
	@Column(name = "nome_usuario", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "sobrenome_usuario", length =30, nullable = false)
	private String sobrenome;
	
	@Column(name = "senha", length = 16, nullable = true)
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contato", referencedColumnName = "id_contato")
	private Contato contato;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Comunidade> comunidadesAcompanhadas;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Comentario> comentariosFeitos;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Incidente> incidentesCadastrados;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Incidente> incidentesAcompanhados;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "usuario_papel",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_papel")
    )
	private List<Papel> papeis = new ArrayList<Papel>();
	
	public Usuario() {}

	public Usuario(String nome, String sobrenome, String senha, Contato contato) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.contato = contato;
//		this.comunidadesAcompanhadas = new ArrayList<Comunidade>();
//		this.comentariosFeitos = new ArrayList<Comentario>();
//		this.incidentesCadastrados = new ArrayList<Incidente>();
//		this.incidentesAcompanhados = new ArrayList<Incidente>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Foto getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	public void adicionarPapel(Papel papel) {
		this.papeis.add(papel);
	}
	
	public void removerPapel (Papel papel) {
		this.papeis.remove(papel);
	}

//	public List<Comunidade> getComunidadesAcompanhadas() {
//		return comunidadesAcompanhadas;
//	}
//
//	public List<Comentario> getComentariosFeitos() {
//		return comentariosFeitos;
//	}
//
//	public List<Incidente> getIncidentesCadastrados() {
//		return incidentesCadastrados;
//	}
//
//	public List<Incidente> getIncidentesAcompanhados() {
//		return incidentesAcompanhados;
//	}
//
//	public void entrarNaComunidade(Comunidade comunidade) {
//		
//		comunidadesAcompanhadas.add(comunidade);
//	}
//
//	public void sairDaComunidade(Comunidade comunidade) {
//		comunidadesAcompanhadas.remove(comunidade);
//	}
//
//	public void acompanharIncidente(Incidente incidente) {
//		incidentesAcompanhados.add(incidente);
//	}
//
//	public void desacompanharIncidente(Incidente incidente) {
//		incidentesAcompanhados.remove(incidente);
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id;
	}
}
