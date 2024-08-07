package AvisaAi.modelo.entidade.usuario.contato;

import java.io.Serializable;
import java.util.Objects;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name = "contato")
public class Contato implements Serializable{
	
	private static final long serialVersionUID = -6243156960143903528L;

	@Id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;
	
	@Column(name = "telefone_contato", length = 13, nullable = false)
	private String telefone;
	
	@Column(name = "email_contato", length = 45, nullable = false)
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
		Contato other = (Contato) obj;
		return id == other.id;
	}
	
	
}
