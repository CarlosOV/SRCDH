/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.service.HorasService;
import com.grupo2.srcdh.service.UsuarioService;
import static com.grupo2.srcdh.util.JsonUtil.json;
import static spark.Spark.get;

/**
 *
 * @author carlos
 */
public class HorasController {

    public HorasController(final HorasService horasService, final UsuarioService usuarioService) {
        get("/api/cursos", (req, res) -> {
            
            return null;
        }, json());
    }
    
}
