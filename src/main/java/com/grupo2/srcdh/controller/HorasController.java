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
import com.grupo2.srcdh.util.JsonUtil;
import static com.grupo2.srcdh.util.JsonUtil.json;
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

    public HorasController(final HorasService horasService, final TokenService tokenService) {
        get("/api/horas", (req, res) -> {

            Token token = tokenService.getByToken(req.headers("token"));
            Usuario user = token.getUsuario();
 
            List<DisponibilidadHoraria> horarios = horasService.getHoras(user);
            
            System.out.println("Horarios: "+horarios);
            DisponibilidadHoraria horario = null;
            
            String salida = "{\"status\":\"200\",\"data\":[";
            for(int i = 0 ; i < horarios.size() ; i++){
                horario = disponibilidadHorariaDAO.Buscar(horarios.get(i).getId());
                salida += "{\"id\":\""+ horario.getId() +"\","
                        + "\"inicioHora\":\""+ horario.getInicioHora() +"\","
                        + "\"finHora\":\""+ horario.getFinHora() +"\","
                        + "\"dia\":\""+ horario.getDia() +"\"}";
            }
            
            salida +="]}";
            
            halt(200, salida);
            return null;
        }, json());
        
        post("/api/horas", (req, res) -> {
            Token token = tokenService.getByToken(req.headers("token"));
            Usuario user = token.getUsuario();
            Docente docente = user.getDocente();
            boolean isHoursSelect = docente.isHorarioSeleccionado();
            try{
                List<DisponibilidadHoraria> dispo = null;
                List<String> arrString = JsonUtil.parseList(req.body());
                Map<String, String> map = null;


                for (String string : arrString) {
                    map = JsonUtil.parse(req.body());
                    dispo.add(new DisponibilidadHoraria(map.get("dia"), map.get("hora")));
                }

                docente.setDisponibilidadHorarias(dispo);
                DocenteDAOImpl docenteDAO = new DocenteDAOImpl();
                docenteDAO.update(docente);
            }
            catch(Exception e){
                System.out.println("Error: "+e);
            }
            if(isHoursSelect){
                halt(403, "{\"status\":\"403\",\"message\":\"Forbidden\"}");
            }
            else{
//                System.out.println("map: "+map);
            }
            System.out.println("isHoursSelect: "+isHoursSelect);
            return null;
        }, json());
    }
    
}
