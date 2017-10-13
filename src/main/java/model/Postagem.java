package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the postagem database table.
 * 
 */
@Entity
@NamedQuery(name="Postagem.findAll", query="SELECT p FROM Postagem p")
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostagemPK id;

	private byte visivel;

	//bi-directional many-to-one association to Blog
	@OneToMany(mappedBy="postagem")
	private List<Blog> blogs;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="postagem")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Forum
	@OneToMany(mappedBy="postagem")
	private List<Forum> forums;

	//bi-directional many-to-one association to Areaconhecimento
	@ManyToOne
	private Areaconhecimento areaconhecimento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Postagem() {
	}

	public PostagemPK getId() {
		return this.id;
	}

	public void setId(PostagemPK id) {
		this.id = id;
	}

	public byte getVisivel() {
		return this.visivel;
	}

	public void setVisivel(byte visivel) {
		this.visivel = visivel;
	}

	public List<Blog> getBlogs() {
		return this.blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public Blog addBlog(Blog blog) {
		getBlogs().add(blog);
		blog.setPostagem(this);

		return blog;
	}

	public Blog removeBlog(Blog blog) {
		getBlogs().remove(blog);
		blog.setPostagem(null);

		return blog;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setPostagem(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setPostagem(null);

		return comentario;
	}

	public List<Forum> getForums() {
		return this.forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public Forum addForum(Forum forum) {
		getForums().add(forum);
		forum.setPostagem(this);

		return forum;
	}

	public Forum removeForum(Forum forum) {
		getForums().remove(forum);
		forum.setPostagem(null);

		return forum;
	}

	public Areaconhecimento getAreaconhecimento() {
		return this.areaconhecimento;
	}

	public void setAreaconhecimento(Areaconhecimento areaconhecimento) {
		this.areaconhecimento = areaconhecimento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}