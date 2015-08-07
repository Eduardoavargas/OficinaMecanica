/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import cdp.Veiculo;

/**
 *
 * @author RafaelBroedel
 */
public class VeiculoDTO extends AbstractDTO {
    private String placa, modelo, cor;
    private Categoria categoria;

    public enum Categoria{
        CARRO, MOTO, CAMINHAO;
    }

    public VeiculoDTO() {
        this.setTipo(DTO.Tipo.VEICULO);
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
