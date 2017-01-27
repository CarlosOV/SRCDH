/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.CursoDAOImpl;
import com.grupo2.srcdh.model.Curso;
import com.grupo2.srcdh.model.DCaCurso;
import com.grupo2.srcdh.util.JsonUtil;
import java.util.List;
import java.util.Map;
import static spark.Spark.halt;



/**
 *
 * @author carlos
 */
public class CursoService {
    private final CursoDAOImpl cursoDAO = new CursoDAOImpl();
    
    public List<Curso> getAllCurso(){
        List<Curso> cursos = cursoDAO.Listar();
        Curso curso = null;
        String salida = "[{\"status\":\"200\",\"message\":\"Cursos obtenidos\", \"data\":[";
        for(int x=0;x<cursos.size();x++) {
            curso = cursos.get(x);
            salida += "{\"id\":\""+ curso.getId() +"\""
                    + ",\"nombre\":\""+ curso.getNombre() +"\""
//                    + ",\"dcacurso\":\""+ curso.getdCaCurso() +"\""
                    + ",\"escuelaacademica\":\""+ curso.getEscuelaAcademica() +"\"}";
            if(x<cursos.size()-1)salida  += ",";
          }
        
        salida += "]}]";
        halt(200, salida);
        return cursos;
    }
    
    public Curso getCurso(long id){
        Curso curso = cursoDAO.Buscar(id);
        if(curso == null) halt(200, null);
        
        String salida = "{\"status\":\"200\",\"message\":\"Curso obtenido\","
                + "\"id\":\""+ curso.getId() +"\""
                + ",\"nombre\":\""+ curso.getNombre() +"\""
                + ",\"escuelaAcademica\":\""+ curso.getEscuelaAcademica() +"\""
                + ",\"dcacurso\":[";
        
        List<DCaCurso> dCaCursos = curso.getdCaCurso();
        DCaCurso dCaCurso = null;
        
        for(int x=0;x<dCaCursos.size();x++) {
            dCaCurso = dCaCursos.get(x);
            salida += "{\"id\":\""+ dCaCurso.getId() +"\""
                    + ",\"docenteCicloAcademico\":\""+ dCaCurso.getDocenteCicloAcademico() +"\""
                    + ",\"curso\":\""+ dCaCurso.getCurso() +"\"}";
            if(x<dCaCursos.size()-1)salida  += ",";
          }
        
        salida += "]}";
        halt(200, salida);
        return curso;
    }
    
    public Curso createCurso(){
        return null;
    }
    
    public Curso updateCurso(long id, String username, String password){
        return null;
    }

}
