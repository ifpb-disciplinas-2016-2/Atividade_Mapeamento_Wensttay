/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.dac.activity.relations.scenario1.dao;

import br.edu.ifpb.ads.dac.activity.relations.scenario1.Cliente;

/**
 *
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 14/04/2017, 10:20:03
 */
public interface ClienteDAO {

    public boolean persist(Cliente cliente);

    public boolean remove(Cliente cliente);

    public boolean update(Cliente cliente);

    public Cliente find(Long codigo);
    
    public Cliente realizarLogin(String login, String password);
}
