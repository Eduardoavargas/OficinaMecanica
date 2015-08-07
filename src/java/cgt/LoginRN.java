/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Pessoa;
import cgd.PessoaDao;
import cgd.PessoaDaoHibernate;
import dto.PessoaDTO;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class LoginRN {
    private final PessoaDao dao;
    private final Fabrica fabrica;
    
    public LoginRN() {
        this.dao = new PessoaDaoHibernate();
        this.fabrica = new Fabrica();
    }
    
    public PessoaDTO realizarLogin(PessoaDTO login){
        PessoaDTO resultado = null;
        Pessoa pessoa = dao.buscarPorCpf(login.getCpf());
        resultado = this.fabrica.criarPessoaDTO(pessoa);
        return resultado;
    }
    
    
}
