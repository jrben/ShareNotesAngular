package shareNotes.modelo.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="POST")
public class Post implements Serializable {
	@Id	
	@Column (name="IDPOST")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idPost;
	
	@Column (name="IDUSUARIO")
	private int idUsuario;
	
	@Column (name="IDCATEGORIA")
	private int idCategoria;
	
	@Column (name="FECHA")
	private String fecha;

	@Column (name="TITULO")
	private String titulo;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	public Post(){
		fecha="";
		titulo="";
		descripcion="";
	}

	public final int getIdPost() {
		return idPost;
	}

	public final void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public final int getIdUsuario() {
		return idUsuario;
	}

	public final void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public final int getIdCategoria() {
		return idCategoria;
	}

	public final void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public final String getFecha() {
		return fecha;
	}

	public final void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public final String getTitulo() {
		return titulo;
	}

	public final void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
