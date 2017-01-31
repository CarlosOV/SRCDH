/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao.Impl;

import com.grupo2.srcdh.dao.IDocenteDAO;
import com.grupo2.srcdh.generic.GenericDAOImpl;
import com.grupo2.srcdh.model.Docente;
import com.grupo2.srcdh.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author carlos
 */
public class DocenteDAOImpl extends GenericDAOImpl<Docente, Long> implements IDocenteDAO {

    private Session sesion; 		
    private Transaction tx;
    
    @Override
    public void update(Docente docente) throws HibernateException {
        try 		
         { 		
             iniciaOperacion(); 		
             sesion.update(docente); 		
             tx.commit(); 		
         } catch (HibernateException he) 		
         { 		
             manejaExcepcion(he); 		
             throw he; 		
         } finally 		
         { 		
             sesion.close(); 		
         } 
    }
    
    private void iniciaOperacion() throws HibernateException 		
     { 		
         sesion = HibernateUtil.getSessionFactory().openSession(); 		
         tx = sesion.beginTransaction(); 		
     }  		
 		
     private void manejaExcepcion(HibernateException he) throws HibernateException 		
     { 		
         tx.rollback(); 		
         throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 		
     } 
    
    }  

