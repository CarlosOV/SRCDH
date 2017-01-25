/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao.Impl;

import com.grupo2.srcdh.dao.ICicloAcademicoDAO;
import com.grupo2.srcdh.generic.GenericDAOImpl;
import com.grupo2.srcdh.model.CicloAcademico;
/*import com.grupo2.srcdh.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;*/

/**
 *
 * @author carlos
 */
public class CicloAcademicoDAOImpl extends GenericDAOImpl<CicloAcademico, Long> implements ICicloAcademicoDAO {
    
    /* public List<CicloAcademico> ListarCiclosAcademicos() {
        List<CicloAcademico> users = new ArrayList<CicloAcademico>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from CicloAcademico").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    } */ 
    
    }  

