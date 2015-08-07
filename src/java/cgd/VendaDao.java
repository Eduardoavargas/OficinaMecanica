/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Venda;
import java.util.List;

/**
 *
 * @author RafaelBroedel
 */
public interface VendaDao {
    
    public void salvar(Venda objeto);
    
    public void remover(Venda objeto);
    
    public void atualizar(Venda objeto);
    
    public List<Venda> listar();
    
    public Venda buscarPorId(long id);
}
