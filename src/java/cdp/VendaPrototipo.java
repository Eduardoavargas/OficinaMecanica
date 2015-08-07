/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author RafaelBroedel
 */
@Entity
@Table(name = "venda")
public class VendaPrototipo extends Model implements Venda {
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(name = "descricao", length = 255, nullable = true)
    private String descricao;
    @Column(name = "valorUnitario", length = 255, nullable = true)
    private Double valorUnitario;
    @Column(name = "quantidade", length = 255, nullable = true)
    private int quantidade;
    @Column(name = "dataDaVenda", length = 40, nullable = true)
    private String dataDaVenda;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(targetEntity = PessoaPrototipo.class)
    @JoinColumn(name = "id_vendedor", referencedColumnName="id")
    private Pessoa vendedor;

    public VendaPrototipo() {
    }

    @Override
    public Pessoa getVendedor() {
        return vendedor;
    }

    @Override
    public void setVendedor(Pessoa vendedor) {
            this.vendedor = vendedor;
    }

    public VendaPrototipo(Tipo tipo) {
        this.tipo = tipo;
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
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Double getValorUnitario() {
        return valorUnitario;
    }

    @Override
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String getDataDaVenda() {
        return dataDaVenda;
    }

    @Override
    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Venda clone() {
        Venda obj = null;
        try {
            obj = (Venda) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(VendaPrototipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
}
