package shareNotes.modelo.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="DENUNCIA")
public class Denuncia implements Serializable{
	@Id	
	@Column (name="IDDENUNCIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idDenuncia;
	
	@Column (name="IDPOST")
	private int idPost;
	
	@Column (name="IDUSUARIO")
	private int idUsuario;
	
	@Column (name="MOTIVO")
	private String motivo;
	
	public Denuncia(){
		motivo="";
	}

	public final int getIdDenuncia() {
		return idDenuncia;
	}

	public final void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
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

	public final String getMotivo() {
		return motivo;
	}

	public final void setMotivo(String motivo) {
		this.motivo = motivo;
	}


}