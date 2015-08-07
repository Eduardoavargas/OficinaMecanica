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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "officialBean")
@RequestScoped
public class OfficialBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1545L;
    /**
     * Creates a new instance of MenuOfficeBean
     */
    private List<PessoaDTO> funcionarios;
    private PessoaDTO funcionario = new PessoaDTO();
    private String cpf;
    private String nomep;
    PessoaRN tarefa = new PessoaRN();

    public OfficialBean() {

    }

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        String type = (String) session.getAttribute("type");
        Integer tipo = Integer.parseInt(type);
        if (tipo == 1 || tipo == 2) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/gerencial/cliente.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            funcionarios = tarefa.listarVendedores();
        }
    }
    public String pesquisar(){
        tarefa.buscarPorId(serialVersionUID);
        return null;
    }
    public List<PessoaDTO> getFuncionarios() {
        return funcionarios;
    }

    public String salvar() {
        tarefa.salvar(funcionario);
        return funcionario.toString();
    }

    public void setFuncionarios(List<PessoaDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public PessoaDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(PessoaDTO funcionario) {
        this.funcionario = funcionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomep() {
        return nomep;
    }

    public void setNomep(String nomep) {
        this.nomep = nomep;
    }
    

}
