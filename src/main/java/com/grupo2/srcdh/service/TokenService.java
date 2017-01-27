/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.TokenDAOImpl;
import com.grupo2.srcdh.model.Token;
import java.util.UUID;

/**
 *
 * @author carlos
 */
public class TokenService {
    
    private final TokenDAOImpl tokenDAO = new TokenDAOImpl();
    
    public static String GenerateIdentifyToken(){
        String identifyToken = UUID.randomUUID().toString();
        return identifyToken;
    }
    
    public Token getByToken(String token){
        return tokenDAO.BuscarPorToken(token);
    }
    
}
