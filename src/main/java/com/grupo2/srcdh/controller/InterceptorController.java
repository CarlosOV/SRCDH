/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.controller;

import com.grupo2.srcdh.dao.Impl.TokenDAOImpl;
import com.grupo2.srcdh.model.Token;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.halt;

/**
 *
 * @author carlos
 */
public class InterceptorController {

    public InterceptorController() {

        before("/api/*", (request, response) -> {
            response.type("application/json");

            if (!request.pathInfo().equals("/api/login") && !request.pathInfo().equals("/api/register") && !request.pathInfo().equals("/api/logout")) {
                
                String token = request.headers("token");
                TokenDAOImpl tokenDao = new TokenDAOImpl();
                boolean authenticated = false;
                Token tokenDevuelto = tokenDao.BuscarPorToken(token);
 
                if (tokenDevuelto != null) {
                    Token tokenAux = tokenDao.getLastToken(tokenDevuelto.getUsuario().getId());
                    if (tokenDevuelto.getToken().equals(tokenAux.getToken()) && tokenDevuelto.isActivo()) {
                        authenticated = true;
                    }
                }
                
                if(!authenticated){
                    halt(401, "{\"status\":\"401\",\"message\":\"Unauthorized\"}");
                }

            }
        });
        
        after((request, response) -> {
            response.type("application/json");
        });
    }

}
