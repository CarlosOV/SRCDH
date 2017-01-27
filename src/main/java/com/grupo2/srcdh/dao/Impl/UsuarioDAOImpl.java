/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao.Impl;

import com.grupo2.srcdh.dao.IUsuarioDAO;
import com.grupo2.srcdh.generic.GenericDAOImpl;
import com.grupo2.srcdh.model.Usuario;
import com.grupo2.srcdh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Long> implements IUsuarioDAO {

    @Override
    public Usuario BuscarPorEmail(String email) {
        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario usuarioDevuelto = null;
        
        try{
            trns = session.beginTransaction();
            try{
               usuarioDevuelto = (Usuario) session.createQuery("select ud from Usuario ud where ud.email = :email")
                    .setParameter("email", email).list().get(0); 
            }
            catch(RuntimeException e){
                e.printStackTrace();
            }
            
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        
        return usuarioDevuelto;
        
    }
    
}  

