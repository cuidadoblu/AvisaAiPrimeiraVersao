package modelo.entidade.incidente;

import java.time.LocalDateTime;

import modelo.entidade.comunidade.Comunidade;

@Entity
@Table(name = "incidente")
public class Incidente extends Comunidade{
	
	@Id
	@Column(name = "id_incidente")
	private int idIncidente;
	
	@Column(name = "descricao_incidente")
	private String descricao;
	
	@Column(name = "data_incidente")
	private LocalDateTime data;
	
	@Column(name = "id_categoria")
	private Categoria categoria;
	
	@Column(name = "id_comunidade")
	private Comunidade comunidade;
	
	@Column(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name = "id_localidade")
	private Localidade localidade;
	
	@Column(name = "id_situacao")
	private Situacao situacao;
	
	public Incidente(String descricao, LocalDateTime data, Categoria categoria, Comunidade comunidade, Usuario usuario, Localidade localidade, Situacao situacao) {
		setDescricao(descricao);
		setData(data);
		setCategoria(categoria);
		setComunidade(comunidade);
		setUsuario(usuario);
		setLocalidade(localidade);
		setSituacao(situacao);
	}
	
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
