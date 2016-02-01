package shareNotes.modelo.servicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import shareNotes.modelo.jpa.Usuario;
import shareNotes.modelo.vo.Objeto;


@Path("ServicioUsuario")
@Produces("application/json")
@Consumes("application/json")
public class ServicioUsuario {
	
	@GET
	@Path("ingresarUsuario/{nombreUsuario}/{username}/{password1}/{password2}")
	public String ingresarUsuario(
			@PathParam("nombreUsuario") String nombreUsuario,
			@PathParam("username") String Username,
			@PathParam("password1") String password1,
			@PathParam("password2") String password2){
		
		if(password1.equals(password2)){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
	    	EntityManager em = emf.createEntityManager();
	    	
	    	if(existeUsuario(Username)==false){
	    		em.getTransaction().begin();
	    		Usuario usuario = new Usuario();
	    		usuario.setUsername(Username);
	    		usuario.setNombreUsuario(nombreUsuario);
	    		usuario.setPassword(password1);
	    		usuario.setModerador(false);
	    		em.persist(usuario);
	    		em.flush();
	    		em.getTransaction().commit();
	    		return "true";
	    	}
	    	else{
	    		return "false";
	    	}
		}
		else
		{
			return "false";
		}
	}

	public int datosUsuario(String username, String password)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = '"+username+"' AND u.password = '"+ password+"'");    	
    	if(query.getResultList().isEmpty())
    	{
    		return -1;
    	}
    	else
    	{
    		int id=-1;
    		List<Usuario> lista=(List<Usuario>)query.getResultList( );
    	    for( Usuario u:lista )
    	    {    	    	
    	    	id=u.getIdUsuario();
    	    }
    	    return id;
    	}    	    	
	}
	

	
	public boolean existeUsuario(String username)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = '"+username+"'");
    	if(query.getResultList().isEmpty())
    	{
    		return false;
    	}
    	else
    	{    	    
    	    return true;
    	}    	    	
	}
	
	public boolean esMod(String username)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = '"+username+"' AND u.moderador = 'TRUE'");    	
    	if(query.getResultList().isEmpty())
    	{
    		return false;
    	}
    	else
    	{
    	    return true;
    	}    	    	
	}
	
	public String consultaUsuario(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotesAngularRest" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = "+id);
    	Usuario u = (Usuario) query.getSingleResult();
    	String nombre=u.getNombreUsuario();
		return nombre;
	}
	
	
}
