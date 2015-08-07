/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

/**
 *
 * @author RafaelBroedel
 */
public interface Venda extends Cloneable{
    
    public enum Tipo {PRODUTO, SERVICO};
    public enum Status {ABERTO, CONCLUIDO, INSTALADO, EMEXECUCAO, NAFILA};
    
    public Tipo getTipo();
    public void setTipo(Tipo tipo);
    public String getDescricao();
    public void setDescricao(String descricao);
    public Double getValorUnitario();
    public void setValorUnitario(Double valorUnitario);
    public int getQuantidade();
    public void setQuantidade(int quantidade);
    public String getDataDaVenda();
    public void setDataDaVenda(String dataDaVenda);
    public Status getStatus();
    public void setStatus(Status status);
    public long getId();
    public void setId(long id);
    public Pessoa getVendedor();
    public void setVendedor(Pessoa vendedor);
    
    public Venda clone();
}
