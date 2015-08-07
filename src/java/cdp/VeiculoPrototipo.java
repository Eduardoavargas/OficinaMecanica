/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


/**
 *
 * @author RafaelBroedel
 */
@Entity
@Table(name = "veiculo")
public class VeiculoPrototipo extends Model implements Veiculo{
    
    /**
    * 
    */
    private static final long serialVersionUID = 12312312312466L;
    @Column(name = "placa",unique = true, length = 40, nullable = false)
    private String placa;
    @Column(name = "modelo", length = 40, nullable = true)
    private String modelo;
    @Column(name = "cor", length = 40, nullable = true)
    private String cor;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public VeiculoPrototipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public VeiculoPrototipo() {
        super();
    }

    @Override
    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + '}';
    }

    @Override
    public Veiculo clone(){
        Veiculo obj = null;
        try {
            obj = (Veiculo) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(VeiculoPrototipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
}
