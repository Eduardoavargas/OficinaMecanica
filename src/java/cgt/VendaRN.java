/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Venda;
import cgd.VendaDao;
import cgd.VendaDaoHibernate;
import dto.VendaDTO;
import java.util.List;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class VendaRN {
    private final Fabrica fabrica = new Fabrica();
    private final VendaDao dao = new VendaDaoHibernate();
    
    public void salvar(VendaDTO vendaDTO){
        Venda venda = (Venda) fabrica.criar(vendaDTO);
        dao.salvar(venda);
    }
    
    public void remover(VendaDTO vendaDTO){
        Venda venda = (Venda) fabrica.criar(vendaDTO);
        dao.remover(venda);
    }
    
    public void remover(long id){
        Venda venda = dao.buscarPorId(id);
        dao.remover(venda);
    }
    
    public void atualizar(VendaDTO vendaDTO){
        Venda venda = (Venda) fabrica.criar(vendaDTO);
        dao.atualizar(venda);
    }
    
    public List<VendaDTO> listar(){
        List<Venda> vendasDTO = dao.listar();
        return fabrica.criarListaVendasDTO(vendasDTO);
    }
    
    public VendaDTO buscarPorId(long id){
        Venda venda = dao.buscarPorId(id);
        return fabrica.criarVendaDTO(venda);
    }
    
    public VendaDTO buscarPorId(VendaDTO vendaDTO){
        Venda venda = dao.buscarPorId(vendaDTO.getId());
        return fabrica.criarVendaDTO(venda);
    }
}
