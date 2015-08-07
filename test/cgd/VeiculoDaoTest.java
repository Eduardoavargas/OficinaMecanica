/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Veiculo;
import dto.VeiculoDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Fabrica;

/**
 *
 * @author RafaelBroedel
 */
public class VeiculoDaoTest {
    
    /**
     * Test of salvar method, of class VeiculoDao.
     */
    @Test
    public void testSalvarCarro() {
        System.out.println("salvar Carro");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("1");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        assertNotNull(objeto.getId());
        
        dao.remover(objeto);
    }
    
    /**
     * Test of salvar method, of class VeiculoDao.
     */
    @Test
    public void testSalvarMoto() {
        System.out.println("salvar Moto");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.MOTO);
        dto.setPlaca("2");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        assertNotNull(objeto.getId());
        
        dao.remover(objeto);
    }
    
    /**
     * Test of salvar method, of class VeiculoDao.
     */
    @Test
    public void testSalvarCaminhao() {
        System.out.println("salvar Caminhao");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("3");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        assertNotNull(objeto.getId());
        
        dao.remover(objeto);
    }


    /**
     * Test of listar method, of class VeiculoDao.
     */
    @Test
    public void testListar() {
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("4");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        List<Veiculo> objetos = dao.listar();
        
        assertNotSame(0, objetos.size());
        
        dao.remover(objeto);
    }

    /**
     * Test of buscarPorId method, of class VeiculoDao.
     */
    @Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("5");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        Veiculo resultado = null;
        resultado = dao.buscarPorId(objeto.getId());
        
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        
        dao.remover(objeto);
    }

    /**
     * Test of listarCarros method, of class VeiculoDao.
     */
    @Test
    public void testListarCarros() {
        System.out.println("listarCarros");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("6");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("7");
        dto.setModelo("modelo");
        dto.setCor("cor");
        Veiculo objeto2 = (Veiculo) fabrica.criar(dto);
        
        dao.salvar(objeto2);
        
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("8");
        dto.setModelo("modelo");
        dto.setCor("cor");
        Veiculo objeto3 = (Veiculo) fabrica.criar(dto);
        
        dao.salvar(objeto3);
        
        List<Veiculo> objetos = dao.listarCarros();
        
        assertNotNull(objetos);
        assertNotSame(0, objetos.size());
        System.out.println(objetos);
        
        dao.remover(objeto);
        dao.remover(objeto2);
        dao.remover(objeto3);
    }

    /**
     * Test of listarMotos method, of class VeiculoDao.
     */
    @Test
    public void testListarMotos() {
        System.out.println("listar motos");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("9");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        dto.setCategoria(VeiculoDTO.Categoria.MOTO);
        dto.setPlaca("10");
        dto.setModelo("modelo");
        dto.setCor("cor");
        Veiculo objeto2 = (Veiculo) fabrica.criar(dto);
        
        dao.salvar(objeto2);
        
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("11");
        dto.setModelo("modelo");
        dto.setCor("cor");
        Veiculo objeto3 = (Veiculo) fabrica.criar(dto);
        
        dao.salvar(objeto3);
        
        List<Veiculo> objetos = dao.listarMotos();
        
        assertNotNull(objetos);
        assertNotSame(0, objetos.size());
        System.out.println(objetos);
        
        dao.remover(objeto);
        dao.remover(objeto2);
        dao.remover(objeto3);
        
    }

    /**
     * Test of listarCaminhoes method, of class VeiculoDao.
     */
    @Test
    public void testListarCaminhoes() {
        System.out.println("listarCaminhoes");
        
        VeiculoDTO dto = new VeiculoDTO();
        dto.setCategoria(VeiculoDTO.Categoria.CARRO);
        dto.setPlaca("12");
        dto.setModelo("modelo");
        dto.setCor("cor");
        
        Fabrica fabrica = new Fabrica();
        
        Veiculo objeto = (Veiculo) fabrica.criar(dto);
        
        VeiculoDao dao = new VeiculoDaoHibernate();
        dao.salvar(objeto);
        
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("13");
        dto.setModelo("modelo3");
        dto.setCor("cor");
        Veiculo objeto2 = (Veiculo) fabrica.criar(dto);
        
        dao.salvar(objeto2);
        
        dto.setCategoria(VeiculoDTO.Categoria.CAMINHAO);
        dto.setPlaca("14");
        dto.setModelo("modelo");
        dto.setCor("cor");
        Veiculo objeto3 = (Veiculo) fabrica.criar(dto);
        
        dao.salvar(objeto3);
        
        List<Veiculo> objetos = dao.listarCaminhoes();
        
        assertNotNull(objetos);
        assertNotSame(0, objetos.size());
        
        System.out.println(objetos);
        
        dao.remover(objeto);
        dao.remover(objeto2);
        dao.remover(objeto3);
    }

}
