package AvisaAi.modelo.entidade.foto;

@Entity
@Table(name = "foto")
public class Foto {
	
    @Id
    @Column(name = "id_foto")
    private int id;

    @Column(name = "conteudo_foto")
    private byte[] conteudo;

    @Column(name = "extensao_foto")
    private String extensao;

    public Foto(int id, byte[] conteudo, String extensao) {
        setId(id);
        setConteudo(conteudo);
        setExtensao(extensao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}