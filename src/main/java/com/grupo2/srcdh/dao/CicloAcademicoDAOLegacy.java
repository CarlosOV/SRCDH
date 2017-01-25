/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao;

import com.grupo2.srcdh.util.HibernateUtil;
import com.grupo2.srcdh.model.CicloAcademico;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class CicloAcademicoDAOLegacy {
    
    private Session sesion; 
    private Transaction tx;  

    public long guardaCicloAcademico(CicloAcademico cicloAcademico) throws HibernateException 
    { 
        long id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(cicloAcademico); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return id; 
    }  

    public void actualizaCicloAcademico(CicloAcademico cicloAcademico) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(cicloAcademico); 
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

    public void eliminaCicloAcademico(CicloAcademico cicloAcademico) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(cicloAcademico); 
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

    public CicloAcademico obtenCicloAcademico(long idContacto) throws HibernateException 
    { 
        CicloAcademico cicloAcademico = null;  
        try 
        { 
            iniciaOperacion(); 
            cicloAcademico = (CicloAcademico) sesion.get(CicloAcademico.class, idContacto); 
        } finally 
        { 
            sesion.close(); 
        }  

        return cicloAcademico; 
    }  

    /*public List<Contacto> obtenListaContactos() throws HibernateException 
    { 
        List<Contacto> listaContactos = null;  

        try 
        { 
            iniciaOperacion(); 
            listaContactos = sesion.createQuery("from CicloAcademico").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaContactos; 
    }  */

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
