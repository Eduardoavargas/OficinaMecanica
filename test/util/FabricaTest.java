/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import cdp.Ordem;
import cdp.Pessoa;
import cdp.Veiculo;
import cdp.Venda;
import dto.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RafaelBroedel
 */
public class FabricaTest {

    /**
     * Test of criar method, of class Fabrica.
     */
    @Test
    public void testCriarCLIENTE() {
        System.out.println("--------  criar CLIENTE");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.CLIENTE);
        dto.setCpf(123);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        
        Fabrica instance = new Fabrica();
        Pessoa result = (Pessoa) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getCpf(), result.getCpf());
        assertEquals(dto.getNascimento(), result.getNascimento());
        assertEquals(dto.getEmail(), result.getEmail());
        assertEquals(dto.getEndereco(), result.getEndereco());
        assertEquals(dto.getNome(), result.getNome());
        assertEquals(dto.getSenha(), result.getSenha());
        
        System.out.println("--------  fim criar CLIENTE");
    }
    
    /**
     * Test of criar method, of class Fabrica.
     */
    @Test
    public void testCriarVENDEDOR() {
        System.out.println("--------  criar VENDEDOR");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dto.setCpf(123);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        dto.setCarteiraDeTrabalho(1);
        dto.setSalarioFixo(1);
        
        Fabrica instance = new Fabrica();
        Pessoa result = (Pessoa) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getCpf(), result.getCpf());
        assertEquals(dto.getSenha(), result.getSenha());
        assertEquals(dto.getNascimento(), result.getNascimento());
        assertEquals(dto.getEmail(), result.getEmail());
        assertEquals(dto.getEndereco(), result.getEndereco());
        assertEquals(dto.getNome(), result.getNome());
        
        assertEquals(dto.getCarteiraDeTrabalho(), result.getCarteiraDeTrabalho());
        assertEquals(dto.getSalarioFixo(), result.getSalarioFixo(),0);
        
        System.out.println("--------  fim criar VENDEDOR");
    }
    
    /**
     * Test of criar method, of class Fabrica.
     */
    @Test
    public void testCriarGERENTE() {
        System.out.println("--------  criar GERENTE");
        
        PessoaDTO dto = new PessoaDTO();
        dto.setCategoria(PessoaDTO.Categoria.GERENTE);
        dto.setCpf(123);
        dto.setSenha("123");
        dto.setNascimento("dataNascimento");
        dto.setEmail("email");
        dto.setEndereco("endereco");
        dto.setNome("nome");
        dto.setCarteiraDeTrabalho(1);
        dto.setSalarioFixo(1);
        
        Fabrica instance = new Fabrica();
        Pessoa result = (Pessoa) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getCpf(), result.getCpf());
        assertEquals(dto.getNascimento(), result.getNascimento());
        assertEquals(dto.getEmail(), result.getEmail());
        assertEquals(dto.getEndereco(), result.getEndereco());
        assertEquals(dto.getNome(), result.getNome());
        assertEquals(dto.getSenha(), result.getSenha());
        
        assertEquals(dto.getCarteiraDeTrabalho(), result.getCarteiraDeTrabalho());
        assertEquals(dto.getSalarioFixo(), result.getSalarioFixo(),0);
        
        System.out.println("--------  fim criar GERENTE");
    }
    
    /**
     * Test of criar method, of class Fabrica.
     */
    @Test
    public void testCriarCARRO() {
        System.out.println("--------  criar CARRO");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("placa");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica instance = new Fabrica();
        Veiculo result = (Veiculo) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getCor(), result.getCor());
        assertEquals(dto.getModelo(), result.getModelo());
        assertEquals(dto.getPlaca(), result.getPlaca());
        
        System.out.println("--------  fim criar CARRO");
    }
    
    /**
     * Test of criar method, of class Fabrica.
     */
    @Test
    public void testCriarMOTO() {
        System.out.println("--------  criar MOTO");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.MOTO);
        dto.setPlaca("placa");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica instance = new Fabrica();
        Veiculo result = (Veiculo) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getCor(), result.getCor());
        assertEquals(dto.getModelo(), result.getModelo());
        assertEquals(dto.getPlaca(), result.getPlaca());
        
        System.out.println("--------  fim criar MOTO");
    }
    
    /**
     * Test of criar method, of class Fabrica.
     */
    @Test
    public void testCriarCAMINHAO() {
        System.out.println("--------  criar CAMINHAO");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("placa");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica instance = new Fabrica();
        Veiculo result = (Veiculo) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getCor(), result.getCor());
        assertEquals(dto.getModelo(), result.getModelo());
        assertEquals(dto.getPlaca(), result.getPlaca());
        
        System.out.println("--------  fim criar CAMINHAO");
    }
    
    @Test
    public void testCriarVendaProduto() {
        System.out.println("--------  criar VendaProduto");
        
        PessoaDTO dtoVendedor = new PessoaDTO();
        dtoVendedor.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dtoVendedor.setCpf(123);
        dtoVendedor.setSenha("123");
        dtoVendedor.setNascimento("dataNascimento");
        dtoVendedor.setEmail("email");
        dtoVendedor.setEndereco("endereco");
        dtoVendedor.setNome("nome");
        dtoVendedor.setCarteiraDeTrabalho(1);
        dtoVendedor.setSalarioFixo(1);
        
        
        VendaDTO dto = new VendaDTO(VendaDTO.Categoria.PRODUTO);
        dto.setDataDaVenda("data");
        dto.setDescricao("descricao");
        dto.setQuantidade(1);
        dto.setStatus(VendaDTO.Status.ABERTO);
        dto.setValorUnitario(100.00);
        dto.setVendedor(dtoVendedor);
        
        Fabrica instance = new Fabrica();
        Venda result = (Venda) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getDescricao(), result.getDescricao());
        assertEquals(dto.getStatus().name(), result.getStatus().name());
        
        System.out.println("--------  fim criar VendaProduto");
    }
    
    @Test
    public void testCriarVendaServico() {
        System.out.println("--------  criar VendaServico");
        
        PessoaDTO dtoVendedor = new PessoaDTO();
        dtoVendedor.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dtoVendedor.setCpf(123);
        dtoVendedor.setSenha("123");
        dtoVendedor.setNascimento("dataNascimento");
        dtoVendedor.setEmail("email");
        dtoVendedor.setEndereco("endereco");
        dtoVendedor.setNome("nome");
        dtoVendedor.setCarteiraDeTrabalho(1);
        dtoVendedor.setSalarioFixo(1);
        
        
        VendaDTO dto = new VendaDTO(VendaDTO.Categoria.SERVICO);
        dto.setDataDaVenda("data");
        dto.setDescricao("descricao");
        dto.setQuantidade(1);
        dto.setStatus(VendaDTO.Status.CONCLUIDO);
        dto.setValorUnitario(100.00);
        dto.setVendedor(dtoVendedor);
        
        Fabrica instance = new Fabrica();
        Venda result = (Venda) instance.criar(dto);
        
        assertNotNull(result);
        assertEquals(dto.getCategoria().name(), result.getTipo().name());
        assertEquals(dto.getDescricao(), result.getDescricao());
        assertEquals(dto.getStatus().name(), result.getStatus().name());
        
        System.out.println("--------  fim criar VendaServico");
    }
    
    @Test
    public void testCriarOS() {
        System.out.println("--------  criar CriarOS");
        
        VeiculoDTO dtoVeiculo = new VeiculoDTO();
        dtoVeiculo.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dtoVeiculo.setPlaca("placa");
        dtoVeiculo.setModelo("modelo");
        dtoVeiculo.setCor("cor");
        
        PessoaDTO dtoVendedor = new PessoaDTO();
        dtoVendedor.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        dtoVendedor.setCpf(123);
        dtoVendedor.setSenha("123");
        dtoVendedor.setNascimento("dataNascimento");
        dtoVendedor.setEmail("email");
        dtoVendedor.setEndereco("endereco");
        dtoVendedor.setNome("nome");
        dtoVendedor.setCarteiraDeTrabalho(1);
        dtoVendedor.setSalarioFixo(1);
        
        VendaDTO dtoVenda = new VendaDTO(VendaDTO.Categoria.SERVICO);
        dtoVenda.setDataDaVenda("data");
        dtoVenda.setDescricao("descricao");
        dtoVenda.setQuantidade(1);
        dtoVenda.setStatus(VendaDTO.Status.CONCLUIDO);
        dtoVenda.setValorUnitario(100.00);
        dtoVenda.setVendedor(dtoVendedor);
        assertNotNull(dtoVenda);
        OrdemDTO dto = new OrdemDTO();
        
        dto.addVendaServico(dtoVenda);
        
        dto.setDataFim("data fim");
        dto.setDataInicio("data inicio");
        dto.setCliente(dtoVendedor);
        dto.setVeiculo(dtoVeiculo);
        
        Fabrica instance = new Fabrica();
        Ordem ordem = (Ordem) instance.criar(dto);
        
        System.out.println(ordem.getVendasServico());
        System.out.println(ordem.getVendasProduto());
        assertNotNull(ordem);
        assertNotNull(ordem.getCliente());
        assertNotNull(ordem.getVeiculo());
        assertNotNull(ordem.getVendasServico());
        assertNotNull(ordem.getVendasServico().get(0));
        assertNotSame(0, ordem.getVendasServico().size());
        
        System.out.println("--------  fim criar CriarOS");
    }
    
}
