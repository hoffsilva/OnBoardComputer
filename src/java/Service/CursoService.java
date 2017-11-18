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
import Model.Curso;
import java.util.List;
import Model.Materia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CursoService {
    
    
    public static Curso insere(Curso curso) {
        SessionFactory sf = null;
        Session session = null;
        Curso localCurso = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            session.beginTransaction();
            
            session.save(curso);
            session.getTransaction().commit();
            localCurso = curso;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        
        return curso;
    }
    
    public static List<Curso> getCursos() {
        SessionFactory sf = null;
        Session session = null;
        
        List<Curso> cursos = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("select c from Cliente c");
            cursos = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (session != null)
                session.close();
        }
        
        return cursos;
    }
    
    
    public static Materia getCurso(String nome) {
        SessionFactory sf = null;
        Session session = null;
        
        Materia materia = null;
        
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("from Curso where nome= :nome");
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

