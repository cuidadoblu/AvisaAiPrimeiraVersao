package AvisaAi.modelo.entidade.comentario.resposta;

@Entity
@Table(name = "resposta")
public class Resposta extends Comentario {

    @Column(name = "id_comentario_pai")
    private Comentario comentarioPai;

    public Resposta(String conteudo, LocalDateTime dataHora, Usuario usuario, Comentario comentarioPai) {
        super(conteudo, dataHora, usuario);
        setComentarioPai(comentarioPai);
    }

    public Comentario getComentarioPai() {
        return comentarioPai;
    }

    public void setComentarioPai(Comentario comentarioPai) {
        this.comentarioPai = comentarioPai;
    }
}