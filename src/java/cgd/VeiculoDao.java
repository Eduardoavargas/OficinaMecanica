/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Veiculo;
import java.util.List;

/**
 *
 * @author RafaelBroedel
 */
public interface VeiculoDao {
    
    public void salvar(Veiculo objeto);
    
    public void remover(Veiculo objeto);
    
    public List<Veiculo> listar();
    
    public Veiculo buscarPorId(long id);
    
    public List<Veiculo> listarCarros();
    
    public List<Veiculo> listarMotos();
    
    public List<Veiculo> listarCaminhoes();

    public void atualizar(Veiculo veiculo);
    
    public Veiculo buscarPorPlaca(String placa);
}
