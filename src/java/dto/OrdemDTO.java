/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RafaelBroedel
 */
public class OrdemDTO extends AbstractDTO {
    private String dataInicio;
    private String dataFim;
    private PessoaDTO cliente;
    private VeiculoDTO veiculo;
    private List<VendaDTO> vendasProduto = new ArrayList<VendaDTO>();
    private List<VendaDTO> vendasServico = new ArrayList<VendaDTO>();

    public OrdemDTO() {
        this.setTipo(Tipo.ORDEMSERVICO);
    }
 
    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public PessoaDTO getCliente() {
        return cliente;
    }

    public void setCliente(PessoaDTO cliente) {
        this.cliente = cliente;
    }

    public VeiculoDTO getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoDTO veiculo) {
        this.veiculo = veiculo;
    }

    public List<VendaDTO> getVendasProduto() {
        return vendasProduto;
    }

    public void setVendasProduto(List<VendaDTO> vendasProduto) {
        this.vendasProduto = vendasProduto;
    }

    public List<VendaDTO> getVendasServico() {
        return vendasServico;
    }

    public void setVendasServico(List<VendaDTO> vendasServico) {
        this.vendasServico = vendasServico;
    }
    
    public void addVendaProduto(VendaDTO venda) {
        this.vendasProduto.add(venda);
    }
    
    public void addVendaServico(VendaDTO venda) {
        this.vendasServico.add(venda);
    }
}
