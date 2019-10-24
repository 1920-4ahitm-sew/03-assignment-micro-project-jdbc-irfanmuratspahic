package at.htl.drivingschool.boundary;

import at.htl.drivingschool.entity.Fahrstunde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/")
public class FahrstundeEndpoint {
    @PersistenceContext
    EntityManager em;

    public void init() {
        System.out.println("********FAHRSTUNDEN ENDPOINT****************");
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Fahrstunde getLesson(@PathParam("id") long id) {
        return em.find(Fahrstunde.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fahrstunde> getAll() {
        return em.createNamedQuery("Fahrstunde.findAll", Fahrstunde.class).getResultList();
    }
}
