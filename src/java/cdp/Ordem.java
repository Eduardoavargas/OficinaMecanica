/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

import java.util.List;



/**
 *
 * @author RafaelBroedel
 */
public interface Ordem {
    public String getDataInicio();

    public void setDataInicio(String dataInicio);

    public String getDataFim();

    public void setDataFim(String dataFim);

    public Pessoa getCliente();

    public void setCliente(Pessoa cliente);
    
    public long getId();
     
    public void setId(long id);
    
    public Veiculo getVeiculo();

    public void setVeiculo(Veiculo veiculo);
    
    public List<Venda> getVendasProduto();

    public void setVendasProduto(List<Venda> vendasProduto);

    public List<Venda> getVendasServico();

    public void setVendasServico(List<Venda> vendasServico);
    
    public void addVendaProduto(Venda venda);
    
    public void addVendaServico(Venda venda);
}
