/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import cdp.*;
import dto.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RafaelBroedel
 */
public class Fabrica {

    private Model objeto = null;

    public Model criar(DTO dto) {

        if (dto.getTipo() == DTO.Tipo.PESSOA) {
            objeto = (Model) this.criarPessoa(dto);

        } else if (dto.getTipo() == DTO.Tipo.VEICULO) {
            objeto = (Model) this.criarVeiculo(dto);
        } else if (dto.getTipo() == DTO.Tipo.VENDA) {
            objeto = (Model) this.criarVenda(dto);
        } else if (dto.getTipo() == DTO.Tipo.ORDEMSERVICO) {
            objeto = (Model) this.criarOS(dto);
        } else {
            throw new TypeNotPresentException(dto.getTipo().name(), null);
        }

        return objeto;
    }

    //funcao para converter um objeto pessoa da CDP em DTO.
    public PessoaDTO criarPessoaDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();

        if (null != pessoa.getTipo().name()) {
            switch (pessoa.getTipo().name()) {
                case "CLIENTE":
                    pessoaDTO.setCategoria(PessoaDTO.Categoria.CLIENTE);
                    break;
                case "VENDEDOR":
                    pessoaDTO.setCategoria(PessoaDTO.Categoria.VENDEDOR);
                    break;
                case "GERENTE":
                    pessoaDTO.setCategoria(PessoaDTO.Categoria.GERENTE);
                    break;
                default:
                    throw new TypeNotPresentException(pessoa.getTipo().name(), null);
            }
        }

        pessoaDTO.setCarteiraDeTrabalho(pessoa.getCarteiraDeTrabalho());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setNascimento(pessoa.getNascimento());
        pessoaDTO.setEmail(pessoa.getEmail());
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setSalarioFixo(pessoa.getSalarioFixo());
        pessoaDTO.setSenha(pessoa.getSenha());

        return pessoaDTO;
    }

    // Funcao interna para converter uma lista de objetos pessoa da CDP em DTO.
    public List<PessoaDTO> criarListaPessoaDTO(List<Pessoa> pessoas) {
        List<PessoaDTO> pessoasDTO = new ArrayList<PessoaDTO>();

        for (Pessoa pessoa : pessoas) {
            pessoasDTO.add(this.criarPessoaDTO(pessoa));
        }
        return pessoasDTO;
    }

    private Pessoa criarPessoa(DTO dto) {
        PessoaDTO pessoaDTO = (PessoaDTO) dto;
        Pessoa pessoa;
        if (pessoaDTO.getCategoria() == PessoaDTO.Categoria.CLIENTE) {
            pessoa = new PessoaPrototipo(Pessoa.Tipo.CLIENTE);
        } else if (pessoaDTO.getCategoria() == PessoaDTO.Categoria.GERENTE) {
            pessoa = new PessoaPrototipo(Pessoa.Tipo.GERENTE);
        } else if (pessoaDTO.getCategoria() == PessoaDTO.Categoria.VENDEDOR) {
            pessoa = new PessoaPrototipo(Pessoa.Tipo.VENDEDOR);
        } else {
            throw new TypeNotPresentException(dto.getTipo().name(), null);
        }

        pessoa.setId(pessoaDTO.getId());

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSenha(pessoaDTO.getSenha());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setNascimento(pessoaDTO.getNascimento());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setCarteiraDeTrabalho(pessoaDTO.getCarteiraDeTrabalho());
        pessoa.setSalarioFixo(pessoaDTO.getSalarioFixo());

        return pessoa;
    }

    private Veiculo criarVeiculo(DTO dto) {
        VeiculoDTO veiculoDTO = (VeiculoDTO) dto;
        Veiculo veiculo;
        if (veiculoDTO.getCategoria() == VeiculoDTO.Categoria.CARRO) {
            veiculo = new VeiculoPrototipo(Veiculo.Tipo.CARRO);
        } else if (veiculoDTO.getCategoria() == VeiculoDTO.Categoria.MOTO) {
            veiculo = new VeiculoPrototipo(Veiculo.Tipo.MOTO);
        } else if (veiculoDTO.getCategoria() == VeiculoDTO.Categoria.CAMINHAO) {
            veiculo = new VeiculoPrototipo(Veiculo.Tipo.CAMINHAO);
        } else {
            throw new TypeNotPresentException(dto.getTipo().name(), null);
        }

        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setCor(veiculoDTO.getCor());

        return veiculo;
    }

    public List<VeiculoDTO> criarListaVeiculoDTO(List<Veiculo> objetos) {
        List<VeiculoDTO> objetosDTO = new ArrayList<VeiculoDTO>();

        for (Veiculo objeto : objetos) {
            objetosDTO.add(this.criarVeiculoDTO(objeto));
        }
        return objetosDTO;
    }

    public VeiculoDTO criarVeiculoDTO(Veiculo objeto) {
        VeiculoDTO objetoDTO = new VeiculoDTO();

        if (null != objeto.getTipo().name()) {
            switch (objeto.getTipo().name()) {
                case "CARRO":
                    objetoDTO.setCategoria(VeiculoDTO.Categoria.CARRO);
                    break;
                case "MOTO":
                    objetoDTO.setCategoria(VeiculoDTO.Categoria.MOTO);
                    break;
                case "CAMINHAO":
                    objetoDTO.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
                    break;
                default:
                    throw new TypeNotPresentException(objeto.getTipo().name(), null);
            }
        }

        objetoDTO.setCor(objeto.getCor());
        objetoDTO.setId(objeto.getId());
        objetoDTO.setModelo(objeto.getModelo());
        objetoDTO.setPlaca(objeto.getPlaca());

        return objetoDTO;
    }

    private Venda criarVenda(DTO dto) {
        VendaDTO vendaDTO = (VendaDTO) dto;
        Venda venda;

        switch (vendaDTO.getCategoria().name()) {
            case "PRODUTO":
                venda = new VendaPrototipo(Venda.Tipo.PRODUTO);
                break;
            case "SERVICO":
                venda = new VendaPrototipo(Venda.Tipo.SERVICO);
                break;
            default:
                throw new TypeNotPresentException(vendaDTO.getStatus().name(), null);
        }

        switch (vendaDTO.getStatus().name()) {
            case "ABERTO":
                venda.setStatus(Venda.Status.ABERTO);
                break;
            case "CONCLUIDO":
                venda.setStatus(Venda.Status.CONCLUIDO);
                break;
            case "EMEXECUCAO":
                venda.setStatus(Venda.Status.EMEXECUCAO);
                break;
            case "INSTALADO":
                venda.setStatus(Venda.Status.INSTALADO);
                break;
            case "NAFILA":
                venda.setStatus(Venda.Status.NAFILA);
                break;
            default:
                throw new TypeNotPresentException(vendaDTO.getStatus().name(), null);
        }

        venda.setDataDaVenda(vendaDTO.getDataDaVenda());
        venda.setDescricao(vendaDTO.getDescricao());
        venda.setId(vendaDTO.getId());
        venda.setQuantidade(vendaDTO.getQuantidade());
        venda.setValorUnitario(vendaDTO.getValorUnitario());

        DTO vendedorDTO = vendaDTO.getVendedor();
        venda.setVendedor((Pessoa) this.criar(vendedorDTO));

        return venda;
    }

    private Ordem criarOS(DTO dto) {
        OrdemDTO ordemDTO = (OrdemDTO) dto;
        Ordem ordem = new OrdemDeServico();

        ordem.setDataFim(ordemDTO.getDataFim());
        ordem.setDataInicio(ordemDTO.getDataInicio());
        ordem.setId(ordemDTO.getId());

        DTO clienteDTO = ordemDTO.getCliente();
        ordem.setCliente((Pessoa) this.criar(clienteDTO));
        DTO veiculoDTO = ordemDTO.getVeiculo();
        ordem.setVeiculo((Veiculo) this.criar(veiculoDTO));
        List<Venda> vendasP = new ArrayList<>();

        for (VendaDTO venda : ordemDTO.getVendasProduto()) {
            vendasP.add((Venda) this.criar(venda));
        }
        ordem.setVendasProduto(vendasP);

        List<Venda> vendasS = new ArrayList<>();

        for (VendaDTO venda : ordemDTO.getVendasServico()) {
            vendasS.add((Venda) this.criar(venda));
        }
        ordem.setVendasServico(vendasS);

        return ordem;
    }

    public VendaDTO criarVendaDTO(Venda objeto) {
        VendaDTO objetoDTO = new VendaDTO();
            
        switch (objeto.getTipo().name()) {
            case "PRODUTO":
                objetoDTO.setCategoria(VendaDTO.Categoria.PRODUTO);
                break;
            case "SERVICO":
                objetoDTO.setCategoria(VendaDTO.Categoria.SERVICO);
                break;
            default:
                throw new TypeNotPresentException(objeto.getTipo().name(), null);
        }

        switch (objeto.getStatus().name()) {
            case "ABERTO":
                objetoDTO.setStatus(VendaDTO.Status.ABERTO);
                break;
            case "CONCLUIDO":
                objetoDTO.setStatus(VendaDTO.Status.CONCLUIDO);
                break;
            case "EMEXECUCAO":
                objetoDTO.setStatus(VendaDTO.Status.EMEXECUCAO);
                break;
            case "INSTALADO":
                objetoDTO.setStatus(VendaDTO.Status.INSTALADO);
                break;
            case "NAFILA":
                objetoDTO.setStatus(VendaDTO.Status.NAFILA);
                break;
            default:
                throw new TypeNotPresentException(objeto.getTipo().name(), null);
        }

        objetoDTO.setDataDaVenda(objeto.getDataDaVenda());
        objetoDTO.setDescricao(objeto.getDescricao());
        objetoDTO.setId(objeto.getId());
        objetoDTO.setQuantidade(objeto.getQuantidade());
        objetoDTO.setValorUnitario(objeto.getValorUnitario());
        
        Pessoa pessoa = objeto.getVendedor();
        objetoDTO.setVendedor(this.criarPessoaDTO(pessoa));

        return objetoDTO;
    }
    
    public OrdemDTO criarOrdemDTO(Ordem objeto) {
        OrdemDTO objetoDTO = new OrdemDTO();
        
        objetoDTO.setCliente(this.criarPessoaDTO(objeto.getCliente()));
        objetoDTO.setDataFim(objeto.getDataFim());
        objetoDTO.setDataInicio(objeto.getDataInicio());
        objetoDTO.setId(objeto.getId());
        objetoDTO.setVeiculo(this.criarVeiculoDTO(objeto.getVeiculo()));
        objetoDTO.setVendasProduto(this.criarListaVendasDTO(objeto.getVendasProduto()));
        objetoDTO.setVendasServico(this.criarListaVendasDTO(objeto.getVendasServico()));

        return objetoDTO;
    }

    public List<VendaDTO> criarListaVendasDTO(List<Venda> objetos) {
        List<VendaDTO> objetosDTO = new ArrayList<VendaDTO>();

        for (Venda objeto : objetos) {
            objetosDTO.add(this.criarVendaDTO(objeto));
        }
        return objetosDTO;
    }

    public List<OrdemDTO> criarListaOrdensDTO(List<Ordem> objetos) {
        List<OrdemDTO> objetosDTO = new ArrayList<OrdemDTO>();

        for (Ordem objeto : objetos) {
            objetosDTO.add(this.criarOrdemDTO(objeto));
        }
        return objetosDTO;
    }

}
