package at.htl.drivingschool;

import at.htl.drivingschool.entity.Fahrstunde;

import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InitBean {
    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        em.persist(new Fahrstunde("Fahrstunde 1", 5));
        em.persist(new Fahrstunde("Fahrstunde 2", 10));
    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init) {

    }
}
