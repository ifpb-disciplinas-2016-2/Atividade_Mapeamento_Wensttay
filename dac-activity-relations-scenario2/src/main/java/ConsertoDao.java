
import br.edu.ifpb.ads.dac.activity.relations.scenario2.Conserto;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 18:10:49
 */
public class ConsertoDao {

    private EntityManager entityManager;

    public ConsertoDao() {
        entityManager = Persistence.createEntityManagerFactory("relations-scenario2").createEntityManager();
    }

    public boolean persist(Conserto conserto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(conserto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Conserto find(long id) {
        entityManager.getTransaction().begin();
        Conserto find = entityManager.find(Conserto.class, id);
        entityManager.getTransaction().commit();
        return find;
    }

    public boolean remove(Conserto conserto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(conserto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
