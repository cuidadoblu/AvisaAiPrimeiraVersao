package AvisaAi.modelo.entidade.foto;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "foto")
public class Foto implements Serializable {
	
	/**
	 * 
	 */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Long id;

    @Column(name = "conteudo_foto", nullable = false)
    private byte[] conteudo;

    @Column(name = "extensao_foto", nullable = false)
    private String extensao;

    public Foto() {}

    public Foto(byte[] conteudo, String extensao) {
        this.conteudo = conteudo;
        this.extensao = extensao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Foto other = (Foto) obj;
        return Objects.equals(id, other.id);
    }
}