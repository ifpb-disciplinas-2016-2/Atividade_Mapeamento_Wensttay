package br.edu.ifpb.ads.dac.activity.relations.scenario1.dao;

import br.edu.ifpb.ads.dac.activity.relations.scenario1.Cliente;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Conta;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Entrada;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.TipoDeEntrada;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 12:08:01
 */
public class ContaDAOImple implements ContaDAO {

    private EntityManager entityManager;

    public ContaDAOImple() {
        entityManager = Persistence.createEntityManagerFactory("relations-scenario1").createEntityManager();
    }

    @Override
    public boolean persist(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(conta);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(conta);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Conta conta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(conta);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Conta find(Long codigo) {
        return entityManager.find(Conta.class, codigo);
        
    }

    @Override
    public boolean alterarSenha(Conta conta, String password) {
        entityManager.getTransaction().begin();
        conta.setSenha(password);
        entityManager.merge(conta);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean sacar(Conta conta, Double value) {
        entityManager.getTransaction().begin();
        conta = find(conta.getCodigo());
        System.out.println(conta.toString());
        Double taxa = conta.getTipo().getTaxaDeDebito();
        conta.setSaldo(conta.getSaldo() - value - taxa);
        conta.addEntrada(new Entrada(value, taxa, TipoDeEntrada.SAQUE));
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean depositar(Conta conta, Double value) {
        entityManager.getTransaction().begin();
        conta = find(conta.getCodigo());
        Double taxa = conta.getTipo().getTaxaDeCredito();
        conta.setSaldo(conta.getSaldo() + value - taxa);
        conta.addEntrada(new Entrada(value, taxa, TipoDeEntrada.DEPOSITO));
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }
}
