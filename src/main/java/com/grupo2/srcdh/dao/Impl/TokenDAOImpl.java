/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao.Impl;

import com.grupo2.srcdh.dao.ITokenDAO;
import com.grupo2.srcdh.generic.GenericDAOImpl;
import com.grupo2.srcdh.model.Token;
import com.grupo2.srcdh.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class TokenDAOImpl extends GenericDAOImpl<Token, Long> implements ITokenDAO {

    @Override
    public Token BuscarPorToken(String token) {
        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Token tokenDevuelto = null;
        
        try{
            trns = session.beginTransaction();
            try{
               tokenDevuelto = (Token) session.createQuery("select td from Token td where td.token = :token")
                    .setParameter("token", token).list().get(0); 
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
        
        return tokenDevuelto;
        
    }

    @Override
    public Token getLastToken(long id) {
    Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Token> tokens;
        Token tokenDevuelto = null;
        
        try{
            trns = session.beginTransaction();
            try{
               tokens = (List<Token>)session.createQuery("select td from Token td where td.idUsuario = :id")
                       .setParameter("id", id).list();
               if(tokens.size()>0){
                   tokenDevuelto = tokens.get(tokens.size()-1);
               }
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
        
        return tokenDevuelto;
    }
    
}  

