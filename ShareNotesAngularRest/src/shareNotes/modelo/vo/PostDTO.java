package shareNotes.modelo.vo;

public class PostDTO{
	private int idPost;
	private int idUsuario;
	private int idCategoria;
	private String usuario;
	private String categoria;
	private String fecha;
	private String titulo;
	private String descripcion;
	
	public PostDTO(){
		super();
	}
	public PostDTO(int idPost, int idUsuario, int idCategoria, String usuario, String categoria, String fecha, String titulo, String descripcion){
		super();
		this.idPost=idPost;
		this.idUsuario=idUsuario;
		this.idCategoria=idCategoria;
		this.usuario=usuario;
		this.categoria=categoria;
		this.fecha=fecha;
		this.titulo=titulo;
		this.descripcion=descripcion;
	}

	public final int getIdPost() {
		return idPost;
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
	public final String getUsuario() {
		return usuario;
	}
	public final void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public final String getCategoria() {
		return categoria;
	}
	public final void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public final void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	
	

}
