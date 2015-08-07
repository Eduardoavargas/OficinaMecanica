/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Veiculo;
import cgd.VeiculoDao;
import cgd.VeiculoDaoHibernate;
import dto.VeiculoDTO;
import java.util.List;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class VeiculoRN {
    private final Fabrica fabrica;
    private final VeiculoDao veiculoDAO;

    public VeiculoRN() {
        this.veiculoDAO = new VeiculoDaoHibernate();
        fabrica = new Fabrica();
    }

    // Função para criação de um objeto persistivel e inserção no banco de dados.
    public void salvar(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = (Veiculo) fabrica.criar(veiculoDTO);
        veiculoDAO.salvar(veiculo);
        veiculoDTO.setId(veiculo.getId());  
    }
    
    // Função para atualizar um objeto.
    public void atualizar(VeiculoDTO veiculoDTO) {
        veiculoDAO.atualizar((Veiculo) fabrica.criar(veiculoDTO));
    }

    // Função que busca veiculo no banco de dados e depois remove o veiculo do banco.
    public void remover(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoDAO.buscarPorId(veiculoDTO.getId());
        veiculoDAO.remover(veiculo);
    }

    // Busca todos os veiculos do banco de dados e converte para o tipo DTO.
    public List<VeiculoDTO> listar() {
        List<Veiculo> veiculos = veiculoDAO.listar();
        return this.fabrica.criarListaVeiculoDTO(veiculos);
    }
    
    // Busca veiculo especifica pelo seu id e converte em um DTO.
    public VeiculoDTO buscarPorId(VeiculoDTO v) {
        Veiculo veiculo = veiculoDAO.buscarPorId(v.getId());
        return this.fabrica.criarVeiculoDTO(veiculo);
    }
    
    // Busca veiculo especifica pela sua placa e converte em um DTO.
    public VeiculoDTO buscarPorPlaca(VeiculoDTO v) {
        Veiculo veiculo = veiculoDAO.buscarPorPlaca(v.getPlaca());
        return this.fabrica.criarVeiculoDTO(veiculo);
    }
    
    // Lista os carros e os converte para DTO.
    public List<VeiculoDTO> listarCarros(){
        List<Veiculo> veiculos = veiculoDAO.listarCarros();
        return this.fabrica.criarListaVeiculoDTO(veiculos);
    }

    // Lista as motos e os converte para DTO.
    public List<VeiculoDTO> listarMotos(){
        List<Veiculo> veiculos = veiculoDAO.listarMotos();
        return this.fabrica.criarListaVeiculoDTO(veiculos);
    }

    // Lista os Caminhoes e os converte para DTO.
    public List<VeiculoDTO> listarCaminhoes(){
        List<Veiculo> veiculos = veiculoDAO.listarCaminhoes();
        return this.fabrica.criarListaVeiculoDTO(veiculos);
    }
}
