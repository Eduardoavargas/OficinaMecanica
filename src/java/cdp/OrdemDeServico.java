/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author RafaelBroedel
 */
@Entity
@Table(name = "ordemdeservico")
public class OrdemDeServico extends Model implements Ordem {

    @Column(name = "dataInicio", length = 40, nullable = true)
    private String dataInicio;
    @Column(name = "dataFim", length = 40, nullable = true)
    private String dataFim;

    @ManyToOne(targetEntity = PessoaPrototipo.class)
    @JoinColumn(name = "id_cliente", referencedColumnName="id")
    private Pessoa cliente;
    
    @ManyToOne(targetEntity = VeiculoPrototipo.class)
    @JoinColumn(name = "id_veiculo", referencedColumnName="id")
    private Veiculo veiculo;
    
    @OneToMany(targetEntity = VendaPrototipo.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="VendasProduto", joinColumns={@JoinColumn(name="id_venda_prod", referencedColumnName="id")})
    private List<Venda> vendasProduto;
    @OneToMany(targetEntity = VendaPrototipo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="VendasServico", joinColumns={@JoinColumn(name="id_venda_serv", referencedColumnName="id")})
    private List<Venda> vendasServico;

    public OrdemDeServico() {
        this.vendasProduto = new ArrayList<Venda>();
        this.vendasServico = new ArrayList<Venda>();
    }
    
    
    public List<Venda> getVendasProduto() {
        return vendasProduto;
    }

    public void setVendasProduto(List<Venda> vendasProduto) {
        this.vendasProduto = vendasProduto;
    }

    public List<Venda> getVendasServico() {
        return vendasServico;
    }

    public void setVendasServico(List<Venda> vendasServico) {
        this.vendasServico = vendasServico;
    }
    
    public void addVendaProduto(Venda venda) {
        this.vendasProduto.add(venda);
    }
    
    public void addVendaServico(Venda venda) {
        this.vendasProduto.add(venda);
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

}
