package shareNotes.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import shareNotes.modelo.jpa.Categorias;

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
}
