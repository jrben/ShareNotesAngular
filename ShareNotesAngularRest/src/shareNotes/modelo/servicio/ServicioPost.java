package shareNotes.modelo.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import shareNotes.modelo.jpa.Post;
import shareNotes.modelo.vo.PostDTO;


@Path("ServicioPost")
@Produces("application/json")
@Consumes("application/json")
public class ServicioPost {
	@GET
	@Path("ingresarPost/{tituloPost}/{idCategoria}/{descripcionPost}")
	public void ingresarPost(
			@PathParam("tituloPost")String tituloPost,
			@PathParam("idCategoria")int idCategoria,
			@PathParam("descripcionPost")String descripcionPost){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	Post post = new Post();
    	post.setIdUsuario(1);
    	post.setIdCategoria(idCategoria);
    	post.setTitulo(tituloPost);
    	post.setDescripcion(descripcionPost);
    	post.setFecha(new Date().toString());
    	em.persist(post);
		em.flush();
		em.getTransaction().commit();    	
	}
	
	@GET
	@Path("actualizarPost/{idPost}/{tituloPost}/{idCategoria}/{descripcionPost}")
	public void actualizarPost(
			@PathParam("idPost")int idPost,
			@PathParam("tituloPost")String tituloPost,
			@PathParam("idCategoria")int idCategoria,
			@PathParam("descripcionPost")String descripcionPost){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	
		Post post = em.find(Post.class, idPost);		 
		em.getTransaction().begin();
		post.setTitulo(tituloPost);
		post.setDescripcion(descripcionPost);
		post.setFecha(new Date().toString());
		post.setIdCategoria(idCategoria);
		em.getTransaction().commit();
	}
	
	@GET
	@Path("eliminarPost/{idPost}")
	public void eliminarPost(@PathParam("idPost")int idPost){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	
		Post post = em.find(Post.class, idPost);				 
		em.getTransaction().begin();
		em.remove(post);
		em.getTransaction().commit();
	}

	@GET
	@Path("listarPosts")
	public List<Post> listarPosts(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p");
		
		List<Post> posts = new ArrayList<Post>();
		List<Post> lista = (List<Post>)query.getResultList( );
		 for(Post p:lista){
			 Post post = new Post();
			 post.setTitulo(p.getTitulo());
			 post.setIdPost(p.getIdPost());
			 posts.add(post);
		 }

		return posts;		
	}

	
	public List<Post> listarPostsCategoria(int id){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.idCategoria="+id);
		
		List<Post> posts = new ArrayList<Post>();
		List<Post> lista = (List<Post>)query.getResultList( );
		 for(Post p:lista){
			 Post post = new Post();
			 post.setTitulo(p.getTitulo());
			 post.setIdPost(p.getIdPost());
			 posts.add(post);
		 }	
		
		return posts;		
	}
	
@GET
@Path("buscarPostTitulo/{titulopost}")
public List<Post> listarPostsTitulo(@PathParam("titulopost")String titulo){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.titulo LIKE '"+"%"+titulo+"%"+"'");
		
		List<Post> posts = new ArrayList<Post>();
		List<Post> lista = (List<Post>)query.getResultList( );
		 for(Post p:lista){
			 Post post = new Post();
			 post.setTitulo(p.getTitulo());
			 post.setIdPost(p.getIdPost());
			 posts.add(post);
			 
			 
		 }	
		
		return posts;		
	}
	

	@GET
	@Path("post")
	public PostDTO obtenerPost(@QueryParam("id")int id){
		
	
		PostDTO post = new PostDTO();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
		EntityManager em = emf.createEntityManager();
		TypedQuery<PostDTO> query = em.createQuery("SELECT NEW shareNotes.modelo.vo.PostDTO"
				+ "(p.idPost, p.idUsuario, p.idCategoria, u.username, c.nombreCategoria, "
				+ "p.fecha, p.titulo, p.descripcion)"
				+ " FROM Post p, Usuario u, Categorias c "
				+ "WHERE p.idPost="+id+" AND p.idUsuario=u.idUsuario "
				+ "AND p.idCategoria=c.idCategoria", PostDTO.class);	
		post = (PostDTO) query.getSingleResult();
	
		return post;
	}
	
	

}
