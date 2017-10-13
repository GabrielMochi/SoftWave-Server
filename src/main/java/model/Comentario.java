package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comentario database table.
 * 
 */
@Entity
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComentarioPK id;

	private String texto;

	//bi-directional many-to-one association to Postagem
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="postagem_areaConhecimento_id", referencedColumnName="areaConhecimento_id"),
		@JoinColumn(name="postagem_id", referencedColumnName="id"),
		@JoinColumn(name="postagem_usuario_prontuario", referencedColumnName="usuario_prontuario")
		})
	private Postagem postagem;

	public Comentario() {
	}

	public ComentarioPK getId() {
		return this.id;
	}

	public void setId(ComentarioPK id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Postagem getPostagem() {
		return this.postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

}