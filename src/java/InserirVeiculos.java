
import cgt.VeiculoRN;
import dto.VeiculoDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RafaelBroedel
 */
public class InserirVeiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VeiculoRN veiculoRN = new VeiculoRN();
        
        VeiculoDTO veiculo1 = new VeiculoDTO();
        veiculo1.setCategoria(VeiculoDTO.Categoria.CARRO);
        veiculo1.setPlaca("XXX-000");
        veiculo1.setModelo("Corsa");
        veiculo1.setCor("Azul");
        veiculoRN.salvar(veiculo1);
        
        VeiculoDTO veiculo2 = new VeiculoDTO();
        veiculo2.setCategoria(VeiculoDTO.Categoria.CARRO);
        veiculo2.setPlaca("JJJ-1111");
        veiculo2.setModelo("Voyage");
        veiculo2.setCor("Cinza");
        veiculoRN.salvar(veiculo2);
        
        VeiculoDTO veiculo3 = new VeiculoDTO();
        veiculo3.setCategoria(VeiculoDTO.Categoria.CARRO);
        veiculo3.setPlaca("ABC-0123");
        veiculo3.setModelo("Combi");
        veiculo3.setCor("Branco");
        veiculoRN.salvar(veiculo3);
        
        VeiculoDTO veiculo4 = new VeiculoDTO();
        veiculo4.setCategoria(VeiculoDTO.Categoria.MOTO);
        veiculo4.setPlaca("XYZ-4444");
        veiculo4.setModelo("CG 150");
        veiculo4.setCor("Preto");
        veiculoRN.salvar(veiculo4);
        
        VeiculoDTO veiculo5 = new VeiculoDTO();
        veiculo5.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        veiculo5.setPlaca("TTT-8888");
        veiculo5.setModelo("Volto T80");
        veiculo5.setCor("Azul");
        veiculoRN.salvar(veiculo5);
        
        System.exit(0);
    }
    
}
