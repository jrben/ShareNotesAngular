package shareNotes.modelo.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="USUARIO")
public class Usuario implements Serializable{
	
	
	@Id	
	@Column (name="IDUSUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idUsuario;
	
	@Column (name="USERNAME")
	private String username;
	
	@Column (name="NOMBREUSUARIO")
	private String nombreUsuario;
	
	@Column (name="PASSWORD")
	private String password;
	
	@Column (name="MODERADOR")
	private boolean moderador;
	
	public Usuario(){
		//idUsuario=5;
		username="";
		nombreUsuario="";
		password="";
		moderador=false;
	}

	public final int getIdUsuario() {
		return idUsuario;
	}

	public final void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public final String getNombreUsuario() {
		return nombreUsuario;
	}

	public final void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final boolean isModerador() {
		return moderador;
	}

	public final void setModerador(boolean moderador) {
		this.moderador = moderador;
	}


		
}