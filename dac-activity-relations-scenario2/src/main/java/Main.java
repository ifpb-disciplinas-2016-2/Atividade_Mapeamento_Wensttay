
import br.edu.ifpb.ads.dac.activity.relations.scenario2.Conserto;
import br.edu.ifpb.ads.dac.activity.relations.scenario2.Endereco;
import br.edu.ifpb.ads.dac.activity.relations.scenario2.Funcao;
import br.edu.ifpb.ads.dac.activity.relations.scenario2.Funcionario;
import br.edu.ifpb.ads.dac.activity.relations.scenario2.Oficina;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 17:12:12
 */
public class Main {

    public static void main(String[] args) {
        Oficina oficina = criandoOficina();
        Funcionario funcionario = criandoFuncionario();
        oficina.addFuncionario(funcionario);
        salvandoOficinal(oficina);

        Conserto conserto = new Conserto(new Double(1000.0), new Date(), funcionario);

        ConsertoDao consertoDao = new ConsertoDao();
        consertoDao.persist(conserto);

        oficina.addConserto(conserto);

        salvandoOficinal(oficina);
        System.out.println(conserto.toString());
        
//        System.out.println("Removeu conserto: " + 
//                consertoDao.remove(conserto));

    }

    private static Oficina criandoOficina() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("relations-scenario2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Oficina oficina = new Oficina("OFICINA DO BAIRRO", fillEndereco());
        entityManager.persist(oficina);
        entityManager.getTransaction().commit();
        return oficina;
    }

    private static Funcionario criandoFuncionario() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("relations-scenario2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf("111-111-111-22");
        funcionario.setFuncao(Funcao.EMPREGADO);
        funcionario.setNome("Wensttay");
        funcionario.setRg("13-33-33.1");
        funcionario.setSalario(new Double(1000.0));
        entityManager.persist(funcionario);
        entityManager.getTransaction().commit();
        return funcionario;
    }

    private static Endereco fillEndereco() {
        Endereco endereco = new Endereco();
        endereco.setBairro("centro");
        endereco.setCep("111111-111");
        endereco.setCidade("Cidade Grande");
        endereco.setEstado("Solido");
        endereco.setNumero("333");
        endereco.setPais("BR");
        endereco.setRua("Rua sem saida");
        return endereco;
    }

    private static void salvandoOficinal(Oficina oficina) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("relations-scenario2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oficina);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
