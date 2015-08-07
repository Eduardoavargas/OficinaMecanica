/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Pessoa;
import cdp.PessoaPrototipo;
import dto.PessoaDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class PessoaDaoTest {
    

    /**
     * Test of salvar method, of class PessoaDAO.
     */
    @Test
    public void testSalvarCliente() {
        System.out.println("salvar CLIENTE");
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(3);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        
        Fabrica fabrica = new Fabrica();
        PessoaPrototipo pessoa = (PessoaPrototipo) fabrica.criar(dto);
        
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        
        assertNotNull(pessoa.getId());
        
        dao.remover(pessoa);
    }
    
    /**
     * Test of salvar method, of class PessoaDAO.
     */
    @Test
    public void testSalvarVendedor() {
        System.out.println("salvar VENDEDOR");
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dto.setCpf(4);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        dto.setCarteiraDeTrabalho(111);
        dto.setSalarioFixo(100.10);
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dto);
        assertNotNull(pessoa);
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        assertNotNull(pessoa.getId());
        
        dao.remover(pessoa);
    }
    
    /**
     * Test of salvar method, of class PessoaDAO.
     */
    @Test
    public void testSalvarGerente() {
        System.out.println("salvar GERENTE");
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.GERENTE);
        dto.setCpf(5);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        dto.setCarteiraDeTrabalho(111);
        dto.setSalarioFixo(100.10);
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dto);
        
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        
        assertNotNull(pessoa.getId());
        
        dao.remover(pessoa);
    }

    /**
     * Test of listar method, of class PessoaDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(6);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dto);
        
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        
        dto.setCategoria(PessoaDTO.Categoria.GERENTE);
        dto.setCpf(7);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        dto.setCarteiraDeTrabalho(111);
        dto.setSalarioFixo(100.10);
        
        Pessoa pessoa2 = (Pessoa) fabrica.criar(dto);
        dao.salvar(pessoa2);
        
        List<Pessoa> pessoas = dao.listar();
        
        assertNotSame(0, pessoas.size());
        
        dao.remover(pessoa);
        dao.remover(pessoa2);
        
    }

    /**
     * Test of buscarPessoa method, of class PessoaDAO.
     */
    @Test
    public void testBuscarPessoa() {
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(8);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dto);
        
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        
        Pessoa resultado = null;
        resultado = dao.buscarPorId(pessoa.getId());
        
        assertNotNull(resultado);
        
        dao.remover(pessoa);
    }
    
    @Test
    public void testListarClientes() {
        System.out.println("listar");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(9);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dto);
        
        
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        dto.setCpf(10);
        
        Pessoa pessoa3 = (Pessoa) fabrica.criar(dto);
        dao.salvar(pessoa3);
        
        dto.setCategoria(PessoaDTO.Categoria.GERENTE);
        dto.setCpf(1);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        dto.setCarteiraDeTrabalho(111);
        dto.setSalarioFixo(100.10);
        
        Pessoa pessoa2 = (Pessoa) fabrica.criar(dto);
        dao.salvar(pessoa2);
        
        List<Pessoa> pessoas = dao.listarClientes();
        System.out.println(pessoas);
        assertNotSame(0, pessoas.size());
        
        dao.remover(pessoa);
        dao.remover(pessoa2);
        dao.remover(pessoa3);
        
    }
    
    @Test
    public void atualizarCliente() {
        System.out.println("atualizar CLIENTE");
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(2);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dto);
        
        PessoaDao dao = new PessoaDaoHibernate();
        dao.salvar(pessoa);
        
        pessoa.setNome("novoNome");
        
        dao.atualizar(pessoa);
        
        Pessoa resultado = dao.buscarPorId(pessoa.getId());
        
        assertEquals(pessoa.getNome(), resultado.getNome());
        assertEquals(pessoa.getId(), resultado.getId());
        
        dao.remover(pessoa);
    }
    
}
