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
import Model.Presencial;
import java.util.List;
import Model.Materia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EADService {
    
    
    public static EAD insere(EAD ead) {
        SessionFactory sf = null;
        Session session = null;
        EAD localEad = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            session.beginTransaction();
            session.save(ead);
            session.getTransaction().commit();
            localEad = ead;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        
        return localEad;
    }
}

