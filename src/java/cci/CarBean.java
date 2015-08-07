/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cgt.VeiculoRN;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dto.VeiculoDTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "carBean")
@RequestScoped

public class CarBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 231L;
    /**
     * Creates a new instance of CarBean
     */
    private List<VeiculoDTO> veiculos;
    private VeiculoDTO veiculoadd = new VeiculoDTO();
    private VeiculoDTO veiculoalt = new VeiculoDTO();
    private String tipo;
    private String placap;
    private VeiculoRN tarefa = new VeiculoRN();

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
//            veiculos = tarefa.listar();
        }

    }

    public String salvar() {
        try {

            tarefa.salvar(veiculoadd);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/gerencial/veiculo.jsf");

        } catch (IOException ex) {
            Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String editar() {
        return veiculoalt.toString();
    }

    public String pesquisar() {
        VeiculoDTO veiculo = new VeiculoDTO();
        veiculo.setPlaca(placap);
        tarefa.buscarPorPlaca(veiculo);
        return null;
    }

    public List<VeiculoDTO> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoDTO> veiculos) {
        this.veiculos = veiculos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public VeiculoDTO getVeiculoadd() {
        return veiculoadd;
    }

    public void setVeiculoadd(VeiculoDTO veiculoadd) {
        this.veiculoadd = veiculoadd;
    }

    public VeiculoDTO getVeiculoalt() {
        return veiculoalt;
    }

    public void setVeiculoalt(VeiculoDTO veiculoalt) {
        this.veiculoalt = veiculoalt;
    }

    public String getPlacap() {
        return placap;
    }

    public void setPlacap(String placap) {
        this.placap = placap;
    }

}
