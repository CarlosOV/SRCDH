/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.google.gson.Gson;
import com.grupo2.srcdh.model.Docente;
import com.grupo2.srcdh.model.Token;
import com.grupo2.srcdh.model.Usuario;
import com.grupo2.srcdh.service.TokenService;
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
 
    public UsuarioController(final UsuarioService usuarioService, final TokenService tokenService){
    
        post("/api/login", (req, res) -> usuarioService.login(req, res), json());
        
        post("/api/register", (req, res) -> {
            Map<String, String> map = JsonUtil.parse(req.body());
            String usuario = map.get("user");
            String pass = map.get("pass");
            Usuario us = usuarioService.createUser(usuario, pass);
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
        
        get("/api/user", (req, res) -> {
            String token = req.headers("token");
            Token tokenObj = tokenService.getByToken(token); 
            Usuario user = tokenObj.getUsuario();
            Docente docente = user.getDocente();

            String salida = "{\"status\":\"200\""
                    + ",\"email\":\""+ user.getEmail() +"\"";
            if(docente != null){
                salida += ",\"nombre\":\""+ docente.getNombre() +"\""
                    + ",\"apellido\":\""+ docente.getApellido() +"\""
                    + ",\"dni\":\""+ docente.getDni() +"\""
                    + ",\"categoria\":\""+ docente.getCategoria().getNombre() +"\"";
            }
                            
                    salida+= "}";
                  
            System.out.println("salida: "+ salida);
            halt(200, salida);
            return null;
        }, json());
    }
    
}
