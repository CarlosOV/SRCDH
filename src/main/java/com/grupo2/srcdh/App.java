/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh;

import static spark.Spark.*;

import com.grupo2.srcdh.controller.UsuarioController;
import com.grupo2.srcdh.model.CicloAcademico;
import com.grupo2.srcdh.dao.CicloAcademicoDAOLegacy;
import com.grupo2.srcdh.service.UsuarioService;

/**
 *
 * @author carlos
 */
public class App {
    public static void main(String[] args){
        
        CicloAcademicoDAOLegacy cicloAcademicoDAO = new CicloAcademicoDAOLegacy();
        CicloAcademico cicloAcademicoRecuperado = null;
        long idAEliminar = 0;
        
        CicloAcademico cicloAcademico1 = new CicloAcademico("Primer Ciclo");
        CicloAcademico cicloAcademico2 = new CicloAcademico("Segundo Ciclo");
        CicloAcademico cicloAcademico3 = new CicloAcademico("Tercer Ciclo");
        
        System.out.println("Object: "+cicloAcademico1);
        
        idAEliminar = cicloAcademicoDAO.guardaCicloAcademico(cicloAcademico1);
        cicloAcademicoDAO.guardaCicloAcademico(cicloAcademico2);
        cicloAcademicoDAO.guardaCicloAcademico(cicloAcademico3);
        
        cicloAcademicoRecuperado = cicloAcademicoDAO.obtenCicloAcademico(idAEliminar); 
        System.out.println("Recuperamos a " + cicloAcademicoRecuperado.getNombre()); 
       
        new UsuarioController(new UsuarioService());
        get("/hello2", (req, res) -> "Hola wii :D");
    }
}
