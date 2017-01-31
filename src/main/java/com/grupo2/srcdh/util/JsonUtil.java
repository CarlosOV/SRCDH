/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.util;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import spark.ResponseTransformer;

/**
 *
 * @author carlos
 */
public class JsonUtil {

    
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
 
    public static ResponseTransformer json() {
      return JsonUtil::toJson;
    }
  
    public static Map<String, String> parse(String object) {
      return new Gson().fromJson(object, Map.class);
    }
    
    public static List<String> parseList(String object){
      return new Gson().fromJson(object, List.class); 
    }
}
