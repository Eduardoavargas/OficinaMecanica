/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Pessoa;
import cdp.Venda;
import cdp.VendaPrototipo;
import dto.PessoaDTO;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class VendaDaoTest {

    /**
     * Test of salvar method, of class VendaDao.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");

        PessoaDTO dtoVendedor = new PessoaDTO();
        dtoVendedor.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dtoVendedor.setCpf(4);
        dtoVendedor.setSenha("123");
        dtoVendedor.setNascimento("dataNascimento");
        dtoVendedor.setEmail("email");
        dtoVendedor.setEndereco("endereco");
        dtoVendedor.setNome("nome");
        dtoVendedor.setCarteiraDeTrabalho(111);
        dtoVendedor.setSalarioFixo(100.10);
        
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dtoVendedor);
        assertNotNull(pessoa);
        PessoaDao daoPessoa = new PessoaDaoHibernate();
        daoPessoa.salvar(pessoa);
        
        Venda venda = new VendaPrototipo(Venda.Tipo.PRODUTO);
        venda.setDataDaVenda("01/01/2015");
        venda.setDescricao("vendaTeste");
        venda.setQuantidade(1);
        venda.setStatus(Venda.Status.CONCLUIDO);
        venda.setValorUnitario(100.00);
        venda.setVendedor(pessoa);
        
        VendaDao daoVenda = new VendaDaoHibernate();
        daoVenda.salvar(venda);
        daoVenda.remover(venda);
        daoPessoa.remover(pessoa);
        assertNotNull(venda.getId());
        assertNotSame(0, venda.getId());
        
    }

    /**
     * Test of remover method, of class VendaDao.
     */
    @Test
    public void testRemover() {
        System.out.println("remover");
    }

    /**
     * Test of atualizar method, of class VendaDao.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
    }

    /**
     * Test of listar method, of class VendaDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
    }

    /**
     * Test of buscarPorId method, of class VendaDao.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
    }

}
