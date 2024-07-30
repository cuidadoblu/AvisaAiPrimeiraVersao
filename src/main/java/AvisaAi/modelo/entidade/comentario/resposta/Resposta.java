package AvisaAi.modelo.entidade.comentario.resposta;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "resposta")
public class Resposta implements Serializable {
	
	/**
	 * 
	 */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resposta")
    private Long id;

    @Column(name = "conteudo_resposta", length = 950, nullable = false)
    private String conteudo;

    @Column(name = "data_hora_resposta", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comentario_pai", nullable = false)
    private Comentario comentarioPai;

    public Resposta() {}

    public Resposta(String conteudo, LocalDateTime dataHora, Usuario usuario, Comentario comentarioPai) {
        this.conteudo = conteudo;
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.comentarioPai = comentarioPai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comentario getComentarioPai() {
        return comentarioPai;
    }

    public void setComentarioPai(Comentario comentarioPai) {
        this.comentarioPai = comentarioPai;
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
        Resposta other = (Resposta) obj;
        return Objects.equals(id, other.id);
    }
}