package cgd;

import cdp.Ordem;
import cdp.Pessoa;
import cdp.PessoaPrototipo;
import java.util.List;
import org.hibernate.*;
import util.HibernateUtil;

/**
 *
 * @author RafaelBroedel
 */
public class PessoaDaoHibernate implements PessoaDao{
    /*
     * Método que salva um usuário no banco de dados
     */

    public void salvar(Pessoa pessoa) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(pessoa);
            transacao.commit();
            sessao.close();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ExceptionInInitializerError("Não foi possível inserir uma pessoa. Erro: " + e.getMessage());
        } 
    }
    
    public void atualizar(Pessoa pessoa) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.merge(pessoa);
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

    public void remover(Pessoa pessoa) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(pessoa);
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
     * @return List<Pessoa>
     *
     * Método retorna uma lista de usuarios
     */
    public List<Pessoa> listar() {
        Session sessao = null;
        Transaction transacao = null;
        List<Pessoa> resultado = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            resultado = sessao.createCriteria(PessoaPrototipo.class).list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível listar as pessoas. Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta em pessoas. Erro: " + e.getMessage());
            }
        }
    }
    /*
     * Busca um usuário pelo código
     */

    public Pessoa buscarPorId(long id) {
        Pessoa pessoa = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            pessoa = (Pessoa) sessao.get(PessoaPrototipo.class, id);
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
        return pessoa;
    }

    public List<Pessoa> listarClientes() {
        List<Pessoa> pessoas = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from PessoaPrototipo u where u.tipo = :tipo";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("tipo", PessoaPrototipo.Tipo.CLIENTE.toString());
            pessoas = consulta.list();

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
        return pessoas;
    }
    
    public List<Pessoa> listarVendedores() {
        List<Pessoa> pessoas = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from PessoaPrototipo u where u.tipo = :tipo";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("tipo", PessoaPrototipo.Tipo.VENDEDOR.toString());
            pessoas = consulta.list();

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
        return pessoas;
    }
    
    public List<Pessoa> listarGerentes() {
        List<Pessoa> pessoas = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from PessoaPrototipo u where u.tipo = :tipo";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("tipo", PessoaPrototipo.Tipo.GERENTE.toString());
            pessoas = consulta.list();

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
        return pessoas;
    }
    
    public Pessoa buscarPorCpf(long cpf) {
        Pessoa pessoa = null;
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            String hql = "select u from PessoaPrototipo u where u.cpf = :cpf";
            Query consulta = sessao.createQuery(hql);
            consulta.setLong("cpf", cpf);
            pessoa = (Pessoa) consulta.uniqueResult();
            
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
        return pessoa;
    }
}
