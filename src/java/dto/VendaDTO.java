/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


/**
 *
 * @author RafaelBroedel
 */
public class VendaDTO extends AbstractDTO {
    
    public enum Categoria{SERVICO, PRODUTO;}
    public enum Status {ABERTO, CONCLUIDO, INSTALADO, EMEXECUCAO, NAFILA};
    
    private String descricao;
    private Double valorUnitario;
    private int quantidade;
    private String dataDaVenda;
    private Status status;
    private PessoaDTO vendedor;
    private Categoria categoria;
    
    public VendaDTO() {
        this.setTipo(Tipo.VENDA);
    }
    
    public VendaDTO(Categoria categoria) {
        this.setTipo(Tipo.VENDA);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PessoaDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(PessoaDTO vendedor) {
        this.vendedor = vendedor;
    }
    
    
}
