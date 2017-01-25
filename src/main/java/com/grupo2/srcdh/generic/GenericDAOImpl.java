/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.generic;

import com.grupo2.srcdh.exception.UnableToSaveException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
   getHibernateTemplate().update(t);
    session.getTransaction().commit();
   } catch (HibernateException e) {
    throw new UnableToSaveException(e);
  }
 }
  
 @Override
 public void Guardar(Entity t) throws UnableToSaveException {
   try {
    getHibernateTemplate().save(t);
    session.getTransaction().commit();
   } catch (HibernateException e) {
    throw new UnableToSaveException(e);
   }
 }
 @Override
 public void Eliminar(Entity t) {
   getHibernateTemplate().delete(t);
   session.getTransaction().commit();
 }
 
}
