/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author RafaelBroedel
 */
public interface DTO {
    public enum Tipo{
        PESSOA, VEICULO, VENDA, ORDEMSERVICO;
    }
    
    public Tipo getTipo();
    public void setTipo(Tipo tipo);
    
}
