/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cgt.OrdemRN;
import dto.OrdemDTO;
import dto.PessoaDTO;
import dto.VeiculoDTO;
import dto.VendaDTO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "orderBean")
@RequestScoped
public class OrderBean implements Serializable {

    private static final long serialVersionUID = 21231L;

    /**
     * Creates a new instance of OrderBean
     */
    private List<VendaDTO> vendas = new ArrayList<>();
    private VendaDTO vendaadd = new VendaDTO();
    private VendaDTO vendaalt = new VendaDTO();
    private PessoaDTO cliente = new PessoaDTO();
    private VeiculoDTO veiculo = new VeiculoDTO();
    private ArrayList<OrdemDTO> servicos = new ArrayList<>();
    private OrdemDTO servico = new OrdemDTO();
    private OrdemDTO servicoadd = new OrdemDTO();
    private String data;
    private String nomep;
    public OrderBean() {

    }

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        String type = (String) session.getAttribute("type");
        Integer tipo = Integer.parseInt(type);
        if (tipo == 1) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/cliente/pedido.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            OrdemRN ordem = new OrdemRN();
//            this.servicos = (ArrayList<OrdemDTO>) ordem.listar();

        }
    }
    public void adicionar(){
        
    }
    public List<VendaDTO> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaDTO> vendas) {
        this.vendas = vendas;
    }

    public VendaDTO getVendaadd() {
        return vendaadd;
    }

    public void setVendaadd(VendaDTO vendaadd) {
        this.vendaadd = vendaadd;
    }

    public VendaDTO getVendaalt() {
        return vendaalt;
    }

    public void setVendaalt(VendaDTO vendaalt) {
        this.vendaalt = vendaalt;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<OrdemDTO> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<OrdemDTO> servicos) {
        this.servicos = servicos;
    }

    public OrdemDTO getServico() {
        return servico;
    }

    public void setServico(OrdemDTO servico) {
        this.servico = servico;
    }
    public void pesquisar(){
        
    }

    public String getNomep() {
        return nomep;
    }

    public void setNomep(String nomep) {
        this.nomep = nomep;
    }

    public OrdemDTO getServicoadd() {
        return servicoadd;
    }

    public void setServicoadd(OrdemDTO servicoadd) {
        this.servicoadd = servicoadd;
    }
    
    
}
