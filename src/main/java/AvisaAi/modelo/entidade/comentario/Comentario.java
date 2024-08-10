package AvisaAi.modelo.entidade.comentario;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.comentario.resposta.Resposta;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id;

    @Column(name = "conteudo_comentario", length = 950, nullable = false)
    private String conteudo;

    @Column(name = "data_hora_comentario", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_incidente", nullable = false)
    private Incidente incidente;

    @Column(name = "avaliacoes_comentario")
    private int avaliacoes;

    @OneToMany(mappedBy = "comentarioPai", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Resposta> respostas = new ArrayList<>();

    public Comentario() {}

    public Comentario(String conteudo, LocalDateTime dataHora, Usuario usuario, Incidente incidente) {
        this.conteudo = conteudo;
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.incidente = incidente;
        this.avaliacoes = 0;
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

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarAvaliacao() {
        this.avaliacoes++;
    }

    public void removerAvaliacao() {
        if (this.avaliacoes > 0) {
            this.avaliacoes--;
        }
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public void adicionarResposta(Resposta resposta) {
        respostas.add(resposta);
        resposta.setComentarioOrigem(this);
    }

    public void removerResposta(Resposta resposta) {
        respostas.remove(resposta);
        resposta.setComentarioOrigem(null);
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
        Comentario other = (Comentario) obj;
        return Objects.equals(id, other.id);
    }
}