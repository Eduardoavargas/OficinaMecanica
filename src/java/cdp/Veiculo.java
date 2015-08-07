/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdp;

/**
 *
 * @author RafaelBroedel
 */
public interface Veiculo extends Cloneable{
    
    public enum Tipo {CARRO, MOTO, CAMINHAO};
    
    public String getPlaca();

    public void setPlaca(String placa);

    public String getModelo();

    public void setModelo(String modelo);

    public String getCor();

    public void setCor(String cor);

    @Override
    public String toString();
    
    public Veiculo clone();
    
    public Tipo getTipo();

    public void setTipo(Tipo tipo);
    
    public long getId();

    public void setId(long id);
}
