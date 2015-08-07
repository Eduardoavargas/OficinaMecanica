/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cgt.PessoaRN;
import java.io.IOException;
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
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

    private String login;
    private String password;
    private String type;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {

    }

    public void login() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute("usuario", this.login);
        session.setAttribute("type", this.type);
        int tipo = Integer.parseInt(type);
        try {
            if (tipo == 1) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/cliente/pedido.jsf");
            }
            if (tipo == 2) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/gerencial/pedido.jsf");
            }
            if (tipo == 3) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/gerencial/funcionario.jsf");
            }
        } catch (IOException ex) {
            Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sair() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/PedroniAutoPecasV2/login.jsf");
        } catch (IOException ex) {
            Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
