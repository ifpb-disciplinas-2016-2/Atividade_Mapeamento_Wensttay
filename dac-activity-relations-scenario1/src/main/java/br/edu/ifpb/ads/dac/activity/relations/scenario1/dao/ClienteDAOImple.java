package br.edu.ifpb.ads.dac.activity.relations.scenario1.dao;

import br.edu.ifpb.ads.dac.activity.relations.scenario1.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 12:07:20
 */
public class ClienteDAOImple implements ClienteDAO {

    private EntityManager entityManager;

    public ClienteDAOImple() {
        entityManager = Persistence.createEntityManagerFactory("relations-scenario1").createEntityManager();
    }

    @Override
    public boolean persist(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Cliente find(Long codigo) {
        return entityManager.find(Cliente.class, codigo);
    }

    @Override
    public Cliente realizarLogin(String login, String password) {
        String consulta = "SELECT c FROM Cliente c WHERE c.login=:login AND c.conta.senha=:password";
        TypedQuery<Cliente> createQuery = entityManager.createQuery(consulta, Cliente.class);
        createQuery.setParameter("login", login);
        createQuery.setParameter("password", password);
        return createQuery.getSingleResult();
    }

}
