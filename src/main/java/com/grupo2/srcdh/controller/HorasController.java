/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.dao.Impl.DisponibilidadHorariaDAOImpl;
import com.grupo2.srcdh.dao.Impl.DocenteDAOImpl;
import com.grupo2.srcdh.model.DisponibilidadHoraria;
import com.grupo2.srcdh.model.Docente;
import com.grupo2.srcdh.model.Token;
import com.grupo2.srcdh.model.Usuario;
import com.grupo2.srcdh.service.HorasService;
import com.grupo2.srcdh.service.TokenService;
import com.grupo2.srcdh.service.UsuarioService;
import com.grupo2.srcdh.util.JsonUtil;
import static com.grupo2.srcdh.util.JsonUtil.json;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;

/**
 *
 * @author carlos
 */
public class HorasController {
    
    private DisponibilidadHorariaDAOImpl disponibilidadHorariaDAO = new DisponibilidadHorariaDAOImpl();

    public HorasController(final HorasService horasService, final TokenService tokenService, final UsuarioService usuarioService) {
        get("/api/horas", (req, res) -> {

            Token token = tokenService.getByToken(req.headers("token"));
            Usuario user = token.getUsuario();
 
            List<DisponibilidadHoraria> horarios = horasService.getHoras(user);
            
            System.out.println("Horarios: "+horarios);
            DisponibilidadHoraria horario = null;
            
            String salida = "{\"status\":\"200\",\"data\":[";
            for(int i = 0 ; i < horarios.size() ; i++){
                if(i!=0)salida+=",";
                horario = disponibilidadHorariaDAO.Buscar(horarios.get(i).getId());
                salida += "{\"id\":\""+ horario.getId() +"\","
                        + "\"hora\":\""+ horario.getHora() +"\","
                        + "\"dia\":\""+ horario.getDia() +"\"}";
            }
            
            salida +="]}";
            
            halt(200, salida);
            return null;
        }, json());
        
        post("/api/horas", (req, res) -> {
            boolean flag = false;
            Token token = tokenService.getByToken(req.headers("token"));
            Usuario user = usuarioService.getUser(token.getUsuario().getId());
            Docente docente = user.getDocente();
            if(!docente.getDisponibilidadHorarias().isEmpty()){
                halt(403, "{\"status\":\"403\",\"message\":\"Forbidden\"}");
            }
            try{
                List<DisponibilidadHoraria> dispo = new ArrayList<DisponibilidadHoraria>();
                List<String> arrString = new ArrayList<String>(Arrays.asList(req.body().replaceAll(" ","").replaceAll("}.","}69,").replaceAll("^\\[|]$", "").split("69,")));
                Map<String, String> map = null;

                for (String string : arrString) {
                    System.out.println("string: "+string);
                    map = JsonUtil.parse(string);
                    System.out.println("map: "+map);
                    dispo.add(new DisponibilidadHoraria(map.get("dia"), map.get("hora"), docente));
                }
                if(!dispo.isEmpty()){
                    System.out.println("before update");
                    horasService.createListHoras(dispo);
                    System.out.println("after update");
                    flag = true;
                }else{
                    halt(400, "{\"status\":\"400\",\"message\":\"Bad Request1\"}");
                }
            }
            catch(Exception e){
                System.out.println("e: "+e);
                halt(400, "{\"status\":\"400\",\"message\":\"Bad Request2\"}");
            }
            
            if(flag){
                String salida = "{\"status\":\"200\",\"message\":\"Guardado Correctamente\"}";
                halt(200, salida);
            }
            return null;
        }, json());
    }
    
}
