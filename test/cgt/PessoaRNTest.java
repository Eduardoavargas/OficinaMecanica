/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;


import dto.PessoaDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RafaelBroedel
 */
public class PessoaRNTest {

    /**
     * Test of salvar method, of class PessoaRN.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(11);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        assertNotNull(dto.getId());
        System.out.println(dto.getId());
        
        pessoaRN.remover(dto);
    }

    /**
     * Test of atualizar method, of class PessoaRN.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(12);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        dto.setNome("nome4");
        pessoaRN.atualizar(dto);
        
        PessoaDTO pessoaDtoTest = pessoaRN.buscarPorId(dto.getId());
        
        assertEquals(dto.getNome(), pessoaDtoTest.getNome());
        assertEquals(dto.getId(), pessoaDtoTest.getId());
        
        pessoaRN.remover(dto);
    }

    /**
     * Test of listar method, of class PessoaRN.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(13);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        List<PessoaDTO> lista = pessoaRN.listar();
        assertNotSame(0, lista.size());
        
        pessoaRN.remover(dto);
    }

    /**
     * Test of buscarPorId method, of class PessoaRN.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(14);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        PessoaDTO resultado = pessoaRN.buscarPorId(dto.getId());
        assertEquals(resultado.getId(), dto.getId());
        assertEquals(resultado.getNome(), dto.getNome());
        
        pessoaRN.remover(dto);
    }

    /**
     * Test of listarClientes method, of class PessoaRN.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(15);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        List<PessoaDTO> lista = pessoaRN.listarClientes();
        assertEquals(dto.getTipo().name(), lista.get(0).getTipo().name());
        
        pessoaRN.remover(dto);
    }

    /**
     * Test of listarVendedores method, of class PessoaRN.
     */
    @Test
    public void testListarVendedores() {
        System.out.println("listarVendedores");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dto.setCpf(16);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        List<PessoaDTO> lista = pessoaRN.listarVendedores();
        assertEquals(dto.getTipo().name(), lista.get(0).getTipo().name());
        
        pessoaRN.remover(dto);
    }

    /**
     * Test of listarGerentes method, of class PessoaRN.
     */
    @Test
    public void testListarGerentes() {
        System.out.println("listarGerentes");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.GERENTE);
        dto.setCpf(17);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        List<PessoaDTO> lista = pessoaRN.listarGerentes();
        System.out.println(lista);
        assertEquals(dto.getTipo().name(), lista.get(0).getTipo().name());
        
        pessoaRN.remover(dto);
    }
    
}
