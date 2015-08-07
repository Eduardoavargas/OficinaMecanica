/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Ordem;
import java.util.List;

/**
 *
 * @author RafaelBroedel
 */
public interface OrdemDao {
    
    public void salvar(Ordem objeto);
    
    public void remover(Ordem objeto);
    
    public void atualizar(Ordem objeto);
    
    public List<Ordem> listar();
    
    public Ordem buscarPorId(long id);
}
