/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.service.CursoService;
import static com.grupo2.srcdh.util.JsonUtil.json;
import static spark.Spark.get;
import static spark.Spark.halt;

/**
 *
 * @author carlos
 */
public class CursoController {

    public CursoController(final CursoService cursoService) {
        get("/api/cursos", (req, res) -> {
            System.out.println("/api/cursos");
            return cursoService.getAllCurso();
        }, json());
        
        get("/api/cursos/:id", (req, res) -> {
            long id = 0;
            try{
                id = Long.parseLong(req.params(":id"));
            }catch(NumberFormatException e){
                System.out.println("NumberFormatException: " + e.getMessage());
                halt(400, "{\"status\":\"400\",\"message\":\"Bad request\"}");
            }
            
            return cursoService.getCurso(id);
        }, json());
    }
    
}
