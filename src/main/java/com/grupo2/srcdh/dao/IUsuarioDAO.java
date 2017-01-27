/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.dao;

import com.grupo2.srcdh.generic.GenericDAO;
import com.grupo2.srcdh.model.Usuario;

/**
 *
 * @author carlos
 */
public interface IUsuarioDAO extends GenericDAO<Usuario, Long>  {

    public Usuario BuscarPorEmail(String email);
    
}
