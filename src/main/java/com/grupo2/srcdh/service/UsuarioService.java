/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.srcdh.service;

import com.grupo2.srcdh.dao.Impl.TokenDAOImpl;
import com.grupo2.srcdh.dao.Impl.UsuarioDAOImpl;
import com.grupo2.srcdh.exception.UnableToSaveException;
import com.grupo2.srcdh.model.Token;
import java.util.List;

import com.grupo2.srcdh.model.Usuario;
import static com.grupo2.srcdh.util.EncriptUtil.getMD5;
import com.grupo2.srcdh.util.JsonUtil;
import java.util.Map;
import spark.Request;
import spark.Response;
import static spark.Spark.halt;


/**
 *
 * @author carlos
 */
public class UsuarioService {
    private final UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
    private final TokenDAOImpl tokenDAO = new TokenDAOImpl();
    
    public List<Usuario> getAllUsers(){
        return null;
    }
    
    public Usuario getUser(long id){
        return usuarioDAO.Buscar(id);
    }
    
    public Usuario createUser(String username, String password) throws UnableToSaveException{
        Usuario userAux = usuarioDAO.BuscarPorEmail(username);
        if(userAux != null){
            halt(409, "{\"status\":\"409\",\"message\":\"User Already exist\"}");
        }
        Usuario user = new Usuario(username, getMD5(password));
        long id = usuarioDAO.Guardar(user);
        return this.getUser(id);
    }
    
    public Usuario updateUser(long id, String username, String password){
        return null;
    }
    
    public Token login(Request req, Response res) throws UnableToSaveException{
        
        Map<String, String> map = JsonUtil.parse(req.body());
        String usuario = map.get("user");
        String pass = map.get("pass");
        Usuario user = usuarioDAO.BuscarPorEmail(usuario);
        if (user != null && getMD5(pass).equals(user.getContrasenha())){
            Token token = new Token( TokenService.GenerateIdentifyToken(), true);
            token.setUsuario(user);
            tokenDAO.Guardar(token);
            halt(200, "{\"status\":\"200\",\"token\":\""+token.getToken()+"\"}");
        }else{
            halt(401, "{\"status\":\"401\",\"message\":\"Unauthorized\"}");
        }
        return null;
    }
    public void logout(String token) throws UnableToSaveException{
        Token tk = tokenDAO.BuscarPorToken(token);
        tk.setActivo(false);
        tokenDAO.Actualizar(tk);
    }
}
