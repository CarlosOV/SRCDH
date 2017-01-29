/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.model.DisponibilidadHoraria;
import com.grupo2.srcdh.model.Token;
import com.grupo2.srcdh.model.Usuario;
import com.grupo2.srcdh.service.HorasService;
import com.grupo2.srcdh.service.TokenService;
import static com.grupo2.srcdh.util.JsonUtil.json;
import java.util.List;
import static spark.Spark.get;
import static spark.Spark.halt;

/**
 *
 * @author carlos
 */
public class HorasController {

    public HorasController(final HorasService horasService, final TokenService tokenService) {
        get("/api/horas", (req, res) -> {

            Token token = tokenService.getByToken(req.headers("token"));
            Usuario user = token.getUsuario();
 
            List<DisponibilidadHoraria> horarios = horasService.getHoras(user);
            
            System.out.println("Horarios: "+horarios);
            DisponibilidadHoraria horario = null;
            
            String salida = "{\"status\":\"200\",\"data\":[";
            for(int i = 0 ; i < horarios.size() ; i++){
                horario = horarios.get(i);
                salida += "{\"id\":\""+ horario.getId() +"\","
                        + "\"inicioHora\":\""+ horario.getInicioHora() +"\","
                        + "\"finHora\":\""+ horario.getFinHora() +"\","
                        + "\"dia\":\""+ horario.getDia() +"\"}";
            }
            
            salida +="]}";
            
            halt(200, salida);
            return null;
        }, json());
    }
    
}
