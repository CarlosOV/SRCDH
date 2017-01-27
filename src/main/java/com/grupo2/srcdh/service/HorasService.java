/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.CicloAcademicoDAOImpl;
import com.grupo2.srcdh.dao.Impl.DocenteCicloAcademicoDAOImpl;
import com.grupo2.srcdh.exception.UnableToSaveException;
import com.grupo2.srcdh.model.CicloAcademico;
import com.grupo2.srcdh.model.DisponibilidadHoraria;
import com.grupo2.srcdh.model.Docente;
import com.grupo2.srcdh.model.DocenteCicloAcademico;
import com.grupo2.srcdh.model.Usuario;
import java.util.List;

/**
 *
 * @author carlos
 */
public class HorasService {
    
    private final DocenteCicloAcademicoDAOImpl docenteCicloAcademicoDAO = new DocenteCicloAcademicoDAOImpl();
    
    public DocenteCicloAcademico getDocenteCicloAcademico(List<DocenteCicloAcademico> dca, CicloAcademico ciclo){

        for (DocenteCicloAcademico dca1 : dca) {
            if(dca1.getCicloAcademico().getId() == ciclo.getId()){
                return dca1;
            }
        }
        
        return null;
    }
    
    public List<DisponibilidadHoraria> getHorasByCiclo(Usuario user, long idCiclo) throws UnableToSaveException{
        
        Docente docente = user.getDocente();
        System.out.println("docente: "+docente);
        
        List<DocenteCicloAcademico> dca = (List<DocenteCicloAcademico>) docente.getDocenteCicloAcademico();
        System.out.println("dca: "+dca);
        
        CicloAcademicoDAOImpl cicloDAO = new CicloAcademicoDAOImpl();
        CicloAcademico ciclo = cicloDAO.Buscar(idCiclo);
        
        DocenteCicloAcademico docCicAcaAux = this.getDocenteCicloAcademico(dca, ciclo);
        
        if(docCicAcaAux == null){
            DocenteCicloAcademico dcanew = new DocenteCicloAcademico(ciclo, docente);
            long id = (Long)docenteCicloAcademicoDAO.Guardar(dcanew);
            docCicAcaAux = docenteCicloAcademicoDAO.Buscar(id);
        }
        
        return docCicAcaAux.getDisponibilidadHoraria();
    }
}
