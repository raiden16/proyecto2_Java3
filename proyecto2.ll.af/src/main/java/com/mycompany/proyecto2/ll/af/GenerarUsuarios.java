
package com.mycompany.proyecto2.ll.af;

import com.jc.elementos.model.DAOUsuarioImpl;
import com.jc.elementos.model.Usuario;
import java.util.ArrayList;


public class GenerarUsuarios {
    public static String obtenerUsuario()throws Exception{
        DAOUsuarioImpl du=new DAOUsuarioImpl();
        
   
        return du.obtenerTodos() ;
        
    }
}
