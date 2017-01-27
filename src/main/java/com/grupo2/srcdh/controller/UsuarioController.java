/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.google.gson.Gson;
import com.grupo2.srcdh.model.Usuario;
import static spark.Spark.*;

import com.grupo2.srcdh.service.UsuarioService;
import com.grupo2.srcdh.util.JsonUtil;
import static com.grupo2.srcdh.util.JsonUtil.json;
import java.util.Map;


/**
 *
 * @author carlos
 */
public class UsuarioController {
 
    public UsuarioController(final UsuarioService userService){
    
        post("/api/login", (req, res) -> userService.login(req, res), json());
        
        post("/api/register", (req, res) -> {
            Map<String, String> map = JsonUtil.parse(req.body());
            String usuario = map.get("user");
            String pass = map.get("pass");
            Usuario us = userService.createUser(usuario, pass);
            Gson gson = new Gson();
            String salida = "{\"usuario\":\""+us.getEmail()+"\"}";
            halt(200, salida);
            return salida;
        }, json());
        
        post("/api/logout", (req, res) -> {
            Map<String, String> map = JsonUtil.parse(req.body());
            String token = map.get("token");
            Gson gson = new Gson();
 
            String salida = "{\"status\":\"200\",\"message\":\"logut\"}";
            halt(200, salida);
            return salida;
        }, json());
        
    }
    
}
