/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cgt.PessoaRN;
import dto.PessoaDTO;
import java.io.IOException;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "customerBean")
@RequestScoped
public class CustomerBean implements Serializable {

    private static final long serialVersionUID = 1234510L;
    ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    private List<PessoaDTO> clientes;
    private PessoaDTO customer = new PessoaDTO();
    private String cpf;
    private String nome;
    PessoaRN tarefa = new PessoaRN();
    public CustomerBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        String type = (String) session.getAttribute("type");
        Integer tipo = Integer.parseInt(type);
        if (tipo == 1) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/login.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            clientes = tarefa.listarClientes();
        }

    }
    public String pesquisar(){
        PessoaDTO cliente = new PessoaDTO();
        
//        tarefa.
        return null;
    }
    public String salvar() {
         tarefa.salvar(customer);
         return null;
    }

    public List<PessoaDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<PessoaDTO> clientes) {
        this.clientes = clientes;
    }

    public PessoaDTO getCustomer() {
        return customer;
    }

    public void setCustomer(PessoaDTO customer) {
        this.customer = customer;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
