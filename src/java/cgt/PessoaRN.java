/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Pessoa;
import cgd.PessoaDao;
import cgd.PessoaDaoHibernate;
import dto.PessoaDTO;
import java.util.List;
import util.Fabrica;

/**
 * CLasse na camada de regras de negócio para
 * realização de tarefas CRUD de pessoas.
 */
public class PessoaRN {

    private final Fabrica fabrica;
    private final PessoaDao pessoaDAO;

    public PessoaRN() {
        this.pessoaDAO = new PessoaDaoHibernate();
        fabrica = new Fabrica();
    }

    // Função para criação de um objeto persistivel e inserção no banco de dados.
    public void salvar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = (Pessoa) fabrica.criar(pessoaDTO);
        pessoaDAO.salvar(pessoa);
        pessoaDTO.setId(pessoa.getId());  
    }
    
    // Função para atualizar um objeto.
    public void atualizar(PessoaDTO pessoaDTO) {
        pessoaDAO.atualizar((Pessoa) fabrica.criar(pessoaDTO));
    }

    // Função que busca pessoa no banco de dados e depois remove a pessoa do banco.
    public void remover(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDAO.buscarPorId(pessoaDTO.getId());
        pessoaDAO.remover(pessoa);
    }

    // Busca todos as pessoas do banco de dados e converte para o tipo DTO.
    public List<PessoaDTO> listar() {
        List<Pessoa> pessoas = pessoaDAO.listar();
        return this.fabrica.criarListaPessoaDTO(pessoas);
    }
    
    // Busca pessoa especifica pelo seu id e converte em um DTO.
    public PessoaDTO buscarPorId(long id) {
        Pessoa pessoa = pessoaDAO.buscarPorId(id);
        return this.fabrica.criarPessoaDTO(pessoa);
    }
    
    // Lista os CLientes e os converte para DTO.
    public List<PessoaDTO> listarClientes(){
        List<Pessoa> pessoas = pessoaDAO.listarClientes();
        return this.fabrica.criarListaPessoaDTO(pessoas);
    }

    // Lista os Vendedores e os converte para DTO.
    public List<PessoaDTO> listarVendedores(){
        List<Pessoa> pessoas = pessoaDAO.listarVendedores();
        return this.fabrica.criarListaPessoaDTO(pessoas);
    }

    // Lista os Gerentes e os converte para DTO.
    public List<PessoaDTO> listarGerentes(){
        List<Pessoa> pessoas = pessoaDAO.listarGerentes();
        return this.fabrica.criarListaPessoaDTO(pessoas);
    }

}
