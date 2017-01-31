/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.generic;

import com.grupo2.srcdh.exception.UnableToSaveException;
import com.grupo2.srcdh.util.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class GenericDAOImpl<Entity, K extends Serializable> implements GenericDAO<Entity, K> {

 public Class<Entity> domainClass = getDomainClass();
 private Session session;
  
 protected Class getDomainClass() {
   if (domainClass == null) {
   ParameterizedType thisType = (ParameterizedType) getClass()
     .getGenericSuperclass();
   domainClass = (Class) thisType.getActualTypeArguments()[0];
   }
  return domainClass;
 }
  
 private Session getHibernateTemplate() {
  session = com.grupo2.srcdh.util.HibernateUtil.getSessionFactory().openSession();
  session.beginTransaction();
  return session;
 }
  
 @Override
 public Entity Buscar(K id) {
  Entity returnValue = (Entity) getHibernateTemplate().load(domainClass, id);
  session.getTransaction().commit();
  return returnValue;
 }
  
 @Override
 public void Actualizar(Entity t) throws UnableToSaveException {
  try {
   System.out.println("antes update");
   getHibernateTemplate().update(t);
   System.out.println("después update");
    session.getTransaction().commit();
   } catch (HibernateException e) {
       System.out.println("e: "+ e);
    throw new UnableToSaveException(e);
  }
 }
  
 @Override
 public Long Guardar(Entity t) throws UnableToSaveException {
   long id = 0;
   try {
    id = (Long)getHibernateTemplate().save(t);
    session.getTransaction().commit();
   } catch (HibernateException e) {
    throw new UnableToSaveException(e);
   }
   return id;
 }
 @Override
 public void Eliminar(Entity t) {
   getHibernateTemplate().delete(t);
   session.getTransaction().commit();
 }

    @Override
    public List<Entity> Listar() {
        List<Entity> users = new ArrayList<Entity>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            System.out.println("this.getDomainClass(): "+ this.getDomainClass().getSimpleName());
            users = session.createQuery("from "+this.getDomainClass().getSimpleName()+"").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
}
