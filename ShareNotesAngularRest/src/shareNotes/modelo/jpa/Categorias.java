package shareNotes.modelo.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CATEGORIA")
public class Categorias implements Serializable {
	@Id	
	@Column (name="IDCATEGORIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idCategoria;
	
	@Column (name="NOMBRECATEGORIA")
	private String nombreCategoria;
	
	public Categorias(){
		nombreCategoria="";
	}

	public final int getIdCategoria() {
		return idCategoria;
	}

	public final void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public final String getNombreCategoria() {
		return nombreCategoria;
	}

	public final void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	

}