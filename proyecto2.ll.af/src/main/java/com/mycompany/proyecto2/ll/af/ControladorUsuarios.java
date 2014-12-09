/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2.ll.af;

import com.mycompany.proyecto2.ll.af.*;

import com.llaf.elementos.model.DAOUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorUsuarios {
    
    @RequestMapping(value="/usuario", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String hola2()throws Exception{
    DAOUsuario d=new DAOUsuario();
    
   String hola= d.obtenerTodos();
       
        return hola;
    }
    
     @RequestMapping(value="/usuario/{id}", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String hola3(@PathVariable Integer id)throws Exception{
    DAOUsuario d=new DAOUsuario();
    
   
       
        return d.obtenerPorId(id);
    }
    
    @RequestMapping(value="/usuario/nombre/{nombre}", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String buscarPorNOmbre(@PathVariable String nombre)throws Exception{
    DAOUsuario d=new DAOUsuario();
    
   
     
        return d.obtenerPorNOmbre(nombre);
    }
    
    
    
    
    
}
