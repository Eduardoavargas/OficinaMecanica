
import cgt.PessoaRN;
import dto.PessoaDTO;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RafaelBroedel
 */
public class InserirUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PessoaRN pessoaRN = new PessoaRN();
        
        PessoaDTO cliente1 = new PessoaDTO();
        cliente1.setCategoria(PessoaDTO.Categoria.CLIENTE);
        cliente1.setCpf(1111);
        cliente1.setSenha("123");
        cliente1.setNascimento("01/02/1990");
        cliente1.setEmail("rafael@");
        cliente1.setEndereco("endereco");
        cliente1.setNome("Rafael_CLIENTE");
        pessoaRN.salvar(cliente1);
        
        PessoaDTO cliente2= new PessoaDTO();
        cliente2.setCategoria(PessoaDTO.Categoria.CLIENTE);
        cliente2.setCpf(2222);
        cliente2.setSenha("123");
        cliente2.setNascimento("02/03/1990");
        cliente2.setEmail("pedro@");
        cliente2.setEndereco("endereco");
        cliente2.setNome("Pedro_CLIENTE");
        pessoaRN.salvar(cliente2);
        
        PessoaDTO cliente3= new PessoaDTO();
        cliente3.setCategoria(PessoaDTO.Categoria.CLIENTE);
        cliente3.setCpf(3333);
        cliente3.setSenha("123");
        cliente3.setNascimento("02/03/1990");
        cliente3.setEmail("joao@");
        cliente3.setEndereco("endereco");
        cliente3.setNome("Joao_CLIENTE");
        pessoaRN.salvar(cliente3);
        
        PessoaDTO cliente4= new PessoaDTO();
        cliente4.setCategoria(PessoaDTO.Categoria.CLIENTE);
        cliente4.setCpf(4444);
        cliente4.setSenha("123");
        cliente4.setNascimento("02/03/1990");
        cliente4.setEmail("carlos@");
        cliente4.setEndereco("endereco");
        cliente4.setNome("Carlos_CLIENTE");
        pessoaRN.salvar(cliente4);
        
        PessoaDTO cliente5= new PessoaDTO();
        cliente5.setCategoria(PessoaDTO.Categoria.CLIENTE);
        cliente5.setCpf(5555);
        cliente5.setSenha("123");
        cliente5.setNascimento("02/03/1990");
        cliente5.setEmail("emanuel@");
        cliente5.setEndereco("endereco");
        cliente5.setNome("Emanuel_CLIENTE");
        pessoaRN.salvar(cliente5);
        
        PessoaDTO vendedor1= new PessoaDTO();
        vendedor1.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        vendedor1.setCpf(6666);
        vendedor1.setSenha("123");
        vendedor1.setNascimento("02/03/1990");
        vendedor1.setEmail("camila@");
        vendedor1.setEndereco("endereco");
        vendedor1.setNome("Camila_Vendedor");
        vendedor1.setCarteiraDeTrabalho(000);
        vendedor1.setSalarioFixo(1000);
        pessoaRN.salvar(vendedor1);
        
        PessoaDTO vendedor2= new PessoaDTO();
        vendedor2.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        vendedor2.setCpf(7777);
        vendedor2.setSenha("123");
        vendedor2.setNascimento("02/03/1990");
        vendedor2.setEmail("jordan@");
        vendedor2.setEndereco("endereco");
        vendedor2.setNome("Jordan_Vendedor");
        vendedor2.setCarteiraDeTrabalho(111);
        vendedor2.setSalarioFixo(1000);
        pessoaRN.salvar(vendedor2);
        
        PessoaDTO vendedor3= new PessoaDTO();
        vendedor3.setCategoria(PessoaDTO.Categoria.VENDEDOR);
        vendedor3.setCpf(8888);
        vendedor3.setSenha("123");
        vendedor3.setNascimento("02/03/1990");
        vendedor3.setEmail("marcelo@");
        vendedor3.setEndereco("endereco");
        vendedor3.setNome("Marcelo_Vendedor");
        vendedor3.setCarteiraDeTrabalho(222);
        vendedor3.setSalarioFixo(1000);
        pessoaRN.salvar(vendedor3);
        
        PessoaDTO gerente1= new PessoaDTO();
        gerente1.setCategoria(PessoaDTO.Categoria.GERENTE);
        gerente1.setCpf(9999);
        gerente1.setSenha("123");
        gerente1.setNascimento("02/03/1960");
        gerente1.setEmail("pedroni@");
        gerente1.setEndereco("endereco");
        gerente1.setNome("Pedroni_Gerente");
        gerente1.setCarteiraDeTrabalho(444);
        gerente1.setSalarioFixo(3000);
        pessoaRN.salvar(gerente1);
        
        System.exit(0);
    }
    
}
