/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Veiculo;
import cdp.VeiculoPrototipo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author RafaelBroedel
 */
public class VeiculoDaoHibernate implements VeiculoDao{
    /*
     * Método que salva um usuário no banco de dados
     */

    public void salvar(Veiculo objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(objeto);
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível inserir um veiculo. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de salvar de veiculo. Erro: " + e.getMessage());
            }
        }
    }

    public void remover(Veiculo objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(objeto);
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível inserir um veiculo. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de salvar de veiculo. Erro: " + e.getMessage());
            }
        }
    }
    
    public void atualizar(Veiculo objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.merge(objeto);
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível inserir uma pessoa. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de salvar de pessoa. Erro: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    /**
     *
     * @return List<Veiculo>
     *
     * Método retorna uma lista de usuarios
     */
    public List<Veiculo> listar() {
        Session sessao = null;
        Transaction transacao = null;
        List<Veiculo> resultado = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            resultado = sessao.createCriteria(VeiculoPrototipo.class).list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível listar os veiculos. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta em veiculo. Erro: " + e.getMessage());
            }
        }
    }
    /*
     * Busca um usuário pelo código
     */

    public Veiculo buscarPorId(long id) {
        Veiculo objeto = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            objeto = (Veiculo) sessao.get(VeiculoPrototipo.class, id);
            transacao.commit();

        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível buscar o veiculo. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação buscar em veiculo. Erro: " + e.getMessage());
            }
        }
        return objeto;
    }

    public List<Veiculo> listarCarros() {
        List<Veiculo> objetos = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from VeiculoPrototipo u where u.tipo = :tipo";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("tipo", VeiculoPrototipo.Tipo.CARRO.toString());
            objetos = consulta.list();

            transacao.commit();

        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível buscar a pessoa. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação buscar em pessoa. Erro: " + e.getMessage());
            }
        }
        return objetos;
    }
    
    public List<Veiculo> listarMotos() {
        List<Veiculo> objetos = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from VeiculoPrototipo u where u.tipo = :tipo";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("tipo", VeiculoPrototipo.Tipo.MOTO.toString());
            objetos = consulta.list();

            transacao.commit();

        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível buscar veiculo. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação buscar em pessoa. Erro: " + e.getMessage());
            }
        }
        return objetos;
    }
    
    public List<Veiculo> listarCaminhoes() {
        List<Veiculo> objetos = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from VeiculoPrototipo u where u.tipo = :tipo";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("tipo", VeiculoPrototipo.Tipo.CAMINHAO.toString());
            objetos = consulta.list();

            transacao.commit();

        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível buscar veiculo. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação buscar veiculo. Erro: " + e.getMessage());
            }
        }
        return objetos;
    }
    
    public Veiculo buscarPorPlaca(String placa) {
        Veiculo objeto = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from VeiculoPrototipo u where u.placa = :placa";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("placa", placa);
            objeto = (Veiculo) consulta.uniqueResult();
            
            transacao.commit();

        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível buscar a pessoa. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação buscar em pessoa. Erro: " + e.getMessage());
            }
        }
        return objeto;
    }
}
