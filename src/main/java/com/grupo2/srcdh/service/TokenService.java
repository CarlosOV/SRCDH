/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import java.util.UUID;

/**
 *
 * @author carlos
 */
public class TokenService {
    
    public static String GenerateIdentifyToken(){
        String identifyToken = UUID.randomUUID().toString();
        return identifyToken;
    }
    
}
