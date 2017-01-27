/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.generic;

import com.grupo2.srcdh.exception.UnableToSaveException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface GenericDAO<Entity, PK extends Serializable> {
    Long Guardar(Entity t) throws UnableToSaveException;
    void Actualizar(Entity t) throws UnableToSaveException;
    Entity Buscar(PK id);
    void Eliminar(Entity t);
    List<Entity> Listar();
}
