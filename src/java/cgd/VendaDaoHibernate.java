/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgd;

import cdp.Venda;
import cdp.VendaPrototipo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author RafaelBroedel
 */
public class VendaDaoHibernate implements VendaDao {
    
    public void salvar(Venda objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(objeto);
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível inserir uma venda. Erro: " + e.getMessage());
        }
    }

    public void remover(Venda objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(objeto);
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível remover uma venda. Erro: " + e.getMessage());
        }
    }
    
    public void atualizar(Venda objeto) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.merge(objeto);
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível atualizar uma venda. Erro: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    /**
     *
     * @return List<Veiculo>
     *
     * Método retorna uma lista de usuarios
     */
    public List<Venda> listar() {
        Session sessao = null;
        Transaction transacao = null;
        List<Venda> resultado = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            resultado = sessao.createCriteria(VendaPrototipo.class).list();
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível listar as vendas. Erro: " + e.getMessage());
        }
        return resultado;
    }
    /*
     * Busca um usuário pelo código
     */

    public Venda buscarPorId(long id) {
        Venda objeto = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            objeto = (Venda) sessao.get(VendaPrototipo.class, id);
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível buscar a venda. Erro: " + e.getMessage());
        }
        return objeto;
    }
}
