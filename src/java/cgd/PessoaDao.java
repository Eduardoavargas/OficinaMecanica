/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Pessoa;
import java.util.List;

/**
 *
 * @author RafaelBroedel
 */
public interface PessoaDao {
    
    public void salvar(Pessoa pessoa);
    
    public void remover(Pessoa pessoa);
    
    public List<Pessoa> listar();
    
    public Pessoa buscarPorId(long id);
    
    public List<Pessoa> listarClientes();
    
    public List<Pessoa> listarVendedores();
    
    public List<Pessoa> listarGerentes();
    
    public void atualizar(Pessoa pessoa);
    
    public Pessoa buscarPorCpf(long cpf);
}
