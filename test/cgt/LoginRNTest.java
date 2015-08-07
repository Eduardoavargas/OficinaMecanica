/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import dto.PessoaDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RafaelBroedel
 */
public class LoginRNTest {
    
    public LoginRNTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of realizarLogin method, of class LoginRN.
     */
    @Test
    public void testRealizarLoginCliente() {
        System.out.println("realizarLogin Cliente");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(20);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        PessoaDTO dtoLogin = new PessoaDTO();
        dtoLogin.setCpf(20);
        dtoLogin.setSenha("123");
        
        LoginRN login = new LoginRN();
        PessoaDTO result = login.realizarLogin(dtoLogin);
        
        pessoaRN.remover(dto);
        
        assertEquals(dto.getCategoria().name(), result.getCategoria().name());
    }
    
    @Test
    public void testRealizarLoginVendedor() {
        System.out.println("realizarLogin Vendedor");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dto.setCpf(21);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        PessoaDTO dtoLogin = new PessoaDTO();
        dtoLogin.setCpf(21);
        dtoLogin.setSenha("123");
        
        LoginRN login = new LoginRN();
        PessoaDTO result = login.realizarLogin(dtoLogin);
        
        pessoaRN.remover(dto);
        
        assertEquals(dto.getCategoria().name(), result.getCategoria().name());
    }
    
    @Test
    public void testRealizarLoginGerente() {
        System.out.println("realizarLogin Gerente");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.GERENTE);
        dto.setCpf(22);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome3");
        
        PessoaRN pessoaRN = new PessoaRN();
        pessoaRN.salvar(dto);
        
        PessoaDTO dtoLogin = new PessoaDTO();
        dtoLogin.setCpf(22);
        dtoLogin.setSenha("123");
        
        LoginRN login = new LoginRN();
        PessoaDTO result = login.realizarLogin(dtoLogin);
        
        pessoaRN.remover(dto);
        
        assertEquals(dto.getCategoria().name(), result.getCategoria().name());
    }
    
}
