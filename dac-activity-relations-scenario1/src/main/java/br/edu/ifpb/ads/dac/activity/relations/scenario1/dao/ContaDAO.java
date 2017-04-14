/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.dac.activity.relations.scenario1.dao;

import br.edu.ifpb.ads.dac.activity.relations.scenario1.Cliente;
import br.edu.ifpb.ads.dac.activity.relations.scenario1.Conta;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 10:23:54
 */
public interface ContaDAO {

    public boolean persist(Conta conta);

    public boolean update(Conta conta);

    public boolean remove(Conta conta);
    
    public Conta find(Long codigo);

    public boolean alterarSenha(Conta conta, String password);

    public boolean sacar(Conta conta, Double value);

    public boolean depositar(Conta conta, Double value);
}
