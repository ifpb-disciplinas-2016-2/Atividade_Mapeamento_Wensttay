
import br.edu.ifpb.ads.dac.activity.relations.scenario3.Aluno;
import br.edu.ifpb.ads.dac.activity.relations.scenario3.Endereco;
import br.edu.ifpb.ads.dac.activity.relations.scenario3.Pessoa;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 19:32:50
 */
public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("relations-scenario3")
                .createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Aluno("1222"
                , new Date()
                , "301"
                , "AlunoName"
                , "111-111-111-111"
                , 10
                , new Date()
                , new Endereco("Rua name", "Centro", "Cajazeiras", "102020-000")));
        entityManager.getTransaction().commit();
    }
}
