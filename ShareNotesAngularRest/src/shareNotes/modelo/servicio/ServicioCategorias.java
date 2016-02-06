package shareNotes.modelo.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import shareNotes.modelo.jpa.Categorias;
import shareNotes.modelo.jpa.Post;

@Path("ServicioCategorias")
@Produces("application/json")
@Consumes("application/json")
public class ServicioCategorias {
	@GET
	@Path("listarCategorias")
	public List<Categorias> listarCategorias() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Categorias c");
		
		List<Categorias> categorias = new ArrayList<Categorias>();
		List<Categorias> lista=(List<Categorias>)query.getResultList( );
	    for( Categorias c:lista )
	    {   
	    	Categorias cat = new Categorias();
	    	cat.setIdCategoria(c.getIdCategoria());
	    	cat.setNombreCategoria(c.getNombreCategoria());	    	
	    	categorias.add(cat);
	    }
	    return categorias;		
	}
	
	public String consultaCategoria(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT c FROM Categorias c WHERE c.idCategoria = "+id);
    	Categorias c = (Categorias) query.getSingleResult();
    	String nombre=c.getNombreCategoria();
		return nombre;
	}
	
	@GET
	@Path("ingresarCategoria/{nombrecategoria}")
	public void ingresarCategoria(@PathParam ("nombrecategoria")String nombrecategoria){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	Categorias categoria= new Categorias();
    	categoria.setNombreCategoria(nombrecategoria);
    	
    	em.persist(categoria);
		em.flush();
		em.getTransaction().commit();    	
	}

	
	@GET
	@Path("editarCategoria/{idCategoria}/{nombrecategoria}")
	public void actualizarPost(@PathParam("idCategoria")int idCategoria,
			
			@PathParam("nombrecategoria")String nombrecategoria){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	
    	
    	Categorias categoria= em.find(Categorias.class, idCategoria) ;
    	
    	em.getTransaction().begin();    	
    	categoria.setNombreCategoria(nombrecategoria);
		em.getTransaction().commit();
	}
	
	
	@GET
	@Path("eliminarCategoria/{idCategoria}")
	public void eliminarCategoria(@PathParam("idCategoria")int idCategoria){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	
		Categorias categEliminar = em.find(Categorias.class, idCategoria);				 
		em.getTransaction().begin();
		em.remove(categEliminar);
		em.getTransaction().commit();
	}
	
	
}
