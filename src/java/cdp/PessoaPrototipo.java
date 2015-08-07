/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author RafaelBroedel
 */
@Entity
@Table(name = "pessoa")
public class PessoaPrototipo extends Model implements Pessoa {

    
    @Column(name = "cpf", length = 40, unique = true, nullable = false)
    private long cpf;
    @Column(name = "nome", length = 40, nullable = true)
    private String nome;
    @Column(name = "email", length = 40, nullable = true)
    private String email;
    @Column(name = "senha", length = 40, nullable = false)
    private String senha;
    @Column(name = "endereco", length = 40, nullable = true)
    private String endereco;
    @Column(name = "carteiraDeTrabalho", length = 40, nullable = true)
    private long carteiraDeTrabalho;
    @Column(name = "nascimento", length = 40, nullable = true)
    private String nascimento;
    @Column(name = "salarioFixo", length = 40, nullable = true)
    private double salarioFixo;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
 /*   
    @OneToMany(mappedBy="pessoa")
    private List<Ordem> ordens;
    
    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }
    
    public void addOrdem(Ordem ordem) {
        this.ordens.add(ordem);
    }
*/
    public PessoaPrototipo(Tipo tipo) {
    	super();
        this.tipo = tipo;
        //this.ordens = new ArrayList<>();
    }

    public PessoaPrototipo() {
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
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public long getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    @Override
    public void setCarteiraDeTrabalho(long carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    @Override
    public String getNascimento() {
        return nascimento;
    }

    @Override
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public double getSalarioFixo() {
        return salarioFixo;
    }

    @Override
    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public String getSenha() {
        return senha;
    }
    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa {" + "nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", carteiraDeTrabalho=" + carteiraDeTrabalho + ", nascimento=" + nascimento + ", salarioFixo=" + salarioFixo + ", tipo=" + tipo + '}';
    }

    @Override
    public Pessoa clone() {
        Pessoa obj = null;
        try {
            obj = (Pessoa) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PessoaPrototipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

}
