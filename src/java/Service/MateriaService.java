/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Service;

/**
*
* @author hoffhenrypereiradasilva
*/

import Controller.HibernateUtil;
import Model.EAD;
import java.util.List;
import Model.Materia;
import Model.Presencial;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MateriaService {
    
    
    public static EAD insereEAD(EAD materia) {
        //atributos de métodos
        //sessao de conexao com o banco de dados
        SessionFactory sf = null;
        Session session = null;
        //objeto temporario do tipo EAD
        EAD localEAD = null;
        //objeto temporario do tipo Presencial
        Presencial presencial = null;
        
        try {
            //pegando a sessao la do hibernate util que utiliza os dados do hibernate config
            sf = HibernateUtil.getSessionFactory();
            //abrindo a conexao
            session = sf.openSession();
            //iniciando a transacao no banco de dados
            session.beginTransaction();
            //salvando o objeto no banco de dados
            session.save(materia);
            //confirmando a transacao
            session.getTransaction().commit();
            //utilizando a materia inserida no banco de dados para devolve-la para a tela
            localEAD = materia;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null)
                //encerrando a sessao.
                session.close();
        }
        //devolvendo a materia para a tela
        return localEAD;
    }
    
    //este método tem o mesmo comportamento do insereEAD, mas utiliza a materia do tipo Presencial
    public static Presencial inserePresencial(Presencial materia) {
        SessionFactory sf = null;
        Session session = null;
        EAD localEAD = null;
        Presencial presencial = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            session.beginTransaction();
            session.save(materia);
            session.getTransaction().commit();
            presencial = materia;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        
        return presencial;
    }
    
    public static List<Materia> getMaterias() {
        SessionFactory sf = null;
        Session session = null;
        
        List<Materia> materias = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("select c from Cliente c");
            materias = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (session != null)
                session.close();
        }
        
        return materias;
    }
    
    
    public static Materia getMateria(String nome) {
        SessionFactory sf = null;
        Session session = null;
        
        Materia materia = null;
        
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("from Materia where nome= :nome");
            query.setParameter("nome", nome);
            List list = query.list();
            materia = (Materia)list.get(0);
            materia.getCurso();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (session != null)
                session.close();
        }
        
        return materia;
    }
}

