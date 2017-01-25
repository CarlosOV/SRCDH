/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import static com.grupo2.srcdh.util.JsonUtil.*;
import static spark.Spark.*;

import com.grupo2.srcdh.service.UsuarioService;


/**
 *
 * @author carlos
 */
public class UsuarioController {
 
    public UsuarioController(final UsuarioService userService){
    
        get("/users", (req, res) -> userService.getAllUsers(), json());
    
    }
    
}
