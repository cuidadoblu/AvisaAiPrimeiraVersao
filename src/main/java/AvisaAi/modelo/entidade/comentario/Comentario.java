package AvisaAi.modelo.entidade.comentario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comentario")
public class Comentario {
	
    @Id
    @Column(name = "id_comentario")
    private int id;

    @Column(name = "conteudo_comentario")
    private String conteudo;

    @Column(name = "data_hora_comentario")
    private LocalDateTime dataHora;

    @Column(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "id_incidente")
    private Incidente incidente;

    @Column(name = "avaliacoes_comentario")
    private int avaliacoes;
    
    @column(name = "id_resposta")
    private List<Resposta> respostas = new ArrayList<>();

    public Comentario(String conteudo, LocalDateTime dataHora, Usuario usuario, Incidente incidente) {
        setConteudo(conteudo);
        setDataHora(dataHora);
        setUsuario(usuario);
        setIncidente(incidente);
        this.avaliacoes = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public LocalDateTime setDataHora(LocalDateTime dataHora) {
    	return this.dataHora = dataHora;
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
        resposta.setComentarioPai(this);
    }

    public void removerResposta(Resposta resposta) {
        respostas.remove(resposta);
        resposta.setComentarioPai(null);
    }
}