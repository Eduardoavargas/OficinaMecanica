/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Ordem;
import cdp.OrdemDeServico;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author RafaelBroedel
 */
public class OrdemDaoHibernate implements OrdemDao {
    
    public void salvar(Ordem objeto) {
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

    public void remover(Ordem objeto) {
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
    
    public void atualizar(Ordem objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(objeto);
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível atualizar uma ordem. Erro: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    /**
     *
     * @return List<Veiculo>
     *
     * Método retorna uma lista de usuarios
     */
    public List<Ordem> listar() {
        Session sessao = null;
        Transaction transacao = null;
        List<Ordem> resultado = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            resultado = sessao.createCriteria(OrdemDeServico.class).list();
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

    public Ordem buscarPorId(long id) {
        Ordem objeto = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            objeto = (Ordem) sessao.get(OrdemDeServico.class, id);
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
}
