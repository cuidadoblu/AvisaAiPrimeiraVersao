package modelo.entidade.usuario.contato;

@Entity
@Table(name = "contato")
public class Contato{
	
	@Id;
	@Column(name = "id_contato")
	private int Id;
	
	@Column(name = "telefone_contato")
	private String telefone;
	
	@Column(name = "email_contato")
	private String email;
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
