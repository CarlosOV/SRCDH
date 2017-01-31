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
import com.grupo2.srcdh.service.DocenteService;
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
 
    private final Gson gson = new Gson();
    
    public UsuarioController(final UsuarioService usuarioService, final TokenService tokenService, final DocenteService docenteService){
    
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
                    + ",\"horarioSeleccionado\":\""+ docente.isHorarioSeleccionado() +"\""
                    + ",\"categoria\":{"
                        + "\"id\":\""+ docente.getCategoria().getId() +"\""
                        + ",\"nombre\":\""+ docente.getCategoria().getNombre()+"\""
                        + ",\"horas\":\""+ docente.getCategoria().getHoras()+"\""
                        + "}";
            }
                            
                    salida+= "}";
                  
            System.out.println("salida: "+ salida);
            halt(200, salida);
            return null;
        }, json());
       
        put("/api/user", (req, res) -> {
 
            String token = req.headers("token");
            Token tokenObj = tokenService.getByToken(token); 
            Usuario user = usuarioService.getUser(tokenObj.getUsuario().getId());
            System.out.println("user: "+user);
            String nombre = null;
            String apellido = null;
            String dni = null;
            try{
                Map<String, String> map = JsonUtil.parse(req.body());
                System.out.println("map: "+map);
                nombre = map.get("nombre");
                apellido = map.get("apellido");
                dni = map.get("dni");
                System.out.println("query");
            }catch(Exception e){
                halt(200, "{\"status\":\"400\", \"message\":\"Bad Request\"}");
            }
            
            Docente docenteAux = user.getDocente();
            Docente docente = null;
            System.out.println("docente: "+docenteAux);
            
            docente = docenteService.updateDocente(docenteAux.getId(), nombre, apellido, dni);
            System.out.println("Docente 2");
            String salida = "{\"status\":\"200\""
                    + ",\"email\":\""+ user.getEmail() +"\"";
            if(docente != null){
                salida += ",\"nombre\":\""+ docente.getNombre() +"\""
                    + ",\"apellido\":\""+ docente.getApellido() +"\""
                    + ",\"dni\":\""+ docente.getDni() +"\""
                    + ",\"horarioSeleccionado\":\""+ docente.isHorarioSeleccionado() +"\""
                    + ",\"categoria\":{"
                        + "\"id\":\""+ docente.getCategoria().getId() +"\""
                        + ",\"nombre\":\""+ docente.getCategoria().getNombre()+"\""
                        + ",\"horas\":\""+ docente.getCategoria().getHoras()+"\""
                        + "}";
            }
                            
                    salida+= "}";
                  
            System.out.println("salida: "+ salida);
            halt(200, salida);
            
            return null;
            
        }, json());
        
    }
    
}
