package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the areaconhecimento database table.
 * 
 */
@Entity
@NamedQuery(name="Areaconhecimento.findAll", query="SELECT a FROM Areaconhecimento a")
public class Areaconhecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Postagem
	@OneToMany(mappedBy="areaconhecimento")
	private List<Postagem> postagems;

	public Areaconhecimento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Postagem> getPostagems() {
		return this.postagems;
	}

	public void setPostagems(List<Postagem> postagems) {
		this.postagems = postagems;
	}

	public Postagem addPostagem(Postagem postagem) {
		getPostagems().add(postagem);
		postagem.setAreaconhecimento(this);

		return postagem;
	}

	public Postagem removePostagem(Postagem postagem) {
		getPostagems().remove(postagem);
		postagem.setAreaconhecimento(null);

		return postagem;
	}

}