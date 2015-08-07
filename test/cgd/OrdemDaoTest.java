/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Ordem;
import cdp.OrdemDeServico;
import cdp.Pessoa;
import cdp.PessoaPrototipo;
import cdp.Veiculo;
import cdp.VeiculoPrototipo;
import cdp.Venda;
import cdp.VendaPrototipo;
import dto.PessoaDTO;
import dto.VeiculoDTO;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class OrdemDaoTest {

    /**
     * Test of salvar method, of class OrdemDao.
     */
    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        
        PessoaDTO dtoPessoa = new PessoaDTO();
        dtoPessoa.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dtoPessoa.setCpf(3333);
        dtoPessoa.setSenha("123");
        dtoPessoa.setNascimento("dataNascimento");
        dtoPessoa.setEmail("email");
        dtoPessoa.setEndereco("endereco");
        dtoPessoa.setNome("nome");
        Fabrica fabrica = new Fabrica();
        Pessoa pessoa = (Pessoa) fabrica.criar(dtoPessoa);
        PessoaDao daoPessoa = new PessoaDaoHibernate();
        daoPessoa.salvar(pessoa);
        
        VeiculoDTO dtoVeiculo = new VeiculoDTO();
        dtoVeiculo.setCategoria(VeiculoDTO.Categoria.CARRO);
        dtoVeiculo.setPlaca("ooo00");
        dtoVeiculo.setModelo("modelo");
        dtoVeiculo.setCor("cor");
        Veiculo veiculo = (Veiculo) fabrica.criar(dtoVeiculo);
        VeiculoDao daoVeiculo = new VeiculoDaoHibernate();
        daoVeiculo.salvar(veiculo);
        
        Ordem os = new OrdemDeServico();
        os.setDataInicio("01/01/2015");
        os.setVeiculo(veiculo);
        os.setCliente(pessoa);
        OrdemDao daoOrdem = new OrdemDaoHibernate();
        daoOrdem.salvar(os);
        
        daoOrdem.remover(os);
        daoPessoa.remover(pessoa);
        daoVeiculo.remover(veiculo);
        
        assertNotNull(os.getId());
        assertNotSame(0, os.getId());
    }


    /**
     * Test of atualizar method, of class OrdemDao.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        
        Pessoa cliente = new PessoaPrototipo(Pessoa.Tipo.CLIENTE);
        cliente.setCpf(8763);
        cliente.setEmail("email@");
        cliente.setEndereco("endereco");
        cliente.setNascimento("nascimento");
        cliente.setNome("nomeVendedor");
        cliente.setSenha("123");
        PessoaDao pessoaDao = new PessoaDaoHibernate();
        pessoaDao.salvar(cliente);
        
        Pessoa vendedor = new PessoaPrototipo(Pessoa.Tipo.VENDEDOR);
        vendedor.setCpf(4654);
        vendedor.setEmail("email@");
        vendedor.setEndereco("endereco");
        vendedor.setNascimento("nascimento");
        vendedor.setNome("nomeCliente");
        vendedor.setSenha("123");
        pessoaDao.salvar(vendedor);
        
        Venda venda = new VendaPrototipo(Venda.Tipo.PRODUTO);
        venda.setDataDaVenda("dataVenda");
        venda.setDescricao("descr");
        venda.setQuantidade(1);
        venda.setStatus(Venda.Status.ABERTO);
        venda.setValorUnitario(100.00);
        venda.setVendedor(vendedor);
        VendaDao vendaDao = new VendaDaoHibernate();
        vendaDao.salvar(venda);
        
        Veiculo veiculo = new VeiculoPrototipo(Veiculo.Tipo.MOTO);
        veiculo.setCor("cor");
        veiculo.setModelo("modelo");
        veiculo.setPlaca("56753");
        VeiculoDao veiculoDao = new VeiculoDaoHibernate();
        veiculoDao.salvar(veiculo);
        
        Ordem ordem = new OrdemDeServico();
        ordem.setCliente(cliente);
        ordem.setDataInicio("inicio");
        ordem.setVeiculo(veiculo);
        OrdemDao ordemDao = new OrdemDaoHibernate();
        ordemDao.salvar(ordem);
        
        ordem.addVendaProduto(venda);
        ordem.setDataFim("dFim");
        ordemDao.atualizar(ordem);
        
        //ordemDao.remover(ordem);
        //veiculoDao.remover(veiculo);
        //pessoaDao.remover(vendedor);
        //pessoaDao.remover(cliente);
    }
    
    //@Test
    public void testSalvar2() {
        System.out.println("atualizar");
        
        Pessoa cliente = new PessoaPrototipo(Pessoa.Tipo.CLIENTE);
        cliente.setCpf(8763);
        cliente.setEmail("email@");
        cliente.setEndereco("endereco");
        cliente.setNascimento("nascimento");
        cliente.setNome("nomeVendedor");
        cliente.setSenha("123");
        PessoaDao pessoaDao = new PessoaDaoHibernate();
        pessoaDao.salvar(cliente);
        
        Pessoa vendedor = new PessoaPrototipo(Pessoa.Tipo.VENDEDOR);
        vendedor.setCpf(4654);
        vendedor.setEmail("email@");
        vendedor.setEndereco("endereco");
        vendedor.setNascimento("nascimento");
        vendedor.setNome("nomeCliente");
        vendedor.setSenha("123");
        pessoaDao.salvar(vendedor);
        
        Venda venda = new VendaPrototipo(Venda.Tipo.PRODUTO);
        venda.setDataDaVenda("dataVenda");
        venda.setDescricao("descr");
        venda.setQuantidade(1);
        venda.setStatus(Venda.Status.ABERTO);
        venda.setValorUnitario(100.00);
        venda.setVendedor(vendedor);
        VendaDao vendaDao = new VendaDaoHibernate();
        vendaDao.salvar(venda);
        
        Veiculo veiculo = new VeiculoPrototipo(Veiculo.Tipo.MOTO);
        veiculo.setCor("cor");
        veiculo.setModelo("modelo");
        veiculo.setPlaca("56753");
        VeiculoDao veiculoDao = new VeiculoDaoHibernate();
        veiculoDao.salvar(veiculo);
        
        Ordem ordem = new OrdemDeServico();
        ordem.setCliente(cliente);
        ordem.setDataInicio("inicio");
        ordem.setVeiculo(veiculo);
        OrdemDao ordemDao = new OrdemDaoHibernate();
        
        
        ordem.addVendaProduto(venda);
        ordem.setDataFim("dFim");
        ordemDao.salvar(ordem);
        
        
        ordemDao.remover(ordem);
        veiculoDao.remover(veiculo);
        pessoaDao.remover(cliente);
        pessoaDao.remover(vendedor);
        
    }


}
