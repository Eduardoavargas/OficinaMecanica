/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Ordem;
import cgd.OrdemDao;
import cgd.OrdemDaoHibernate;
import dto.OrdemDTO;
import java.util.List;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class OrdemRN {
    private Fabrica fabrica = new Fabrica();
    private OrdemDao dao = new OrdemDaoHibernate();
    
    public void salvar(OrdemDTO objeto){
        Ordem ordem = (Ordem) fabrica.criar(objeto);
        dao.salvar(ordem);
    }
    
    public void remover(OrdemDTO objeto){
        Ordem ordem = (Ordem) fabrica.criar(objeto);
        dao.remover(ordem);
    }
    
    public void remover(long id){
        Ordem ordem = dao.buscarPorId(id);
        dao.remover(ordem);
    }
    
    public void atualizar(OrdemDTO objeto){
        Ordem ordem = (Ordem) fabrica.criar(objeto);
        dao.atualizar(ordem);
    }
    
    public List<OrdemDTO> listar(){
        List<Ordem> ordens = dao.listar();
        return fabrica.criarListaOrdensDTO(ordens);
    }
    
    public OrdemDTO buscarPorId(long id){
        Ordem ordem = dao.buscarPorId(id);
        return fabrica.criarOrdemDTO(ordem);
    }
}
