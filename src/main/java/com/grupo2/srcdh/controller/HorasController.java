/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.model.DisponibilidadHoraria;
import com.grupo2.srcdh.model.DocenteCicloAcademico;
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
        get("/api/ciclo/:idCiclo/horas", (req, res) -> {
            long idCiclo = 0;
            
            try{
                idCiclo = Long.parseLong(req.params(":idCiclo"));
            }catch(NumberFormatException e){
                System.out.println("NumberFormatException: " + e.getMessage());
                halt(400, "{\"status\":\"400\",\"message\":\"Bad request\"}");
            }
            System.out.println("before");

            Token token = tokenService.getByToken(req.headers("token"));
            System.out.println("Token: "+token);
            Usuario user = token.getUsuario();
            System.out.println("Usuario: "+user);
            List<DisponibilidadHoraria> horarios = horasService.getHorasByCiclo(user, idCiclo);
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
