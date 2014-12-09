
package com.mycompany.proyecto2.ll.af;

import com.llaf.elementos.model.DAOUsuario;
import com.llaf.elementos.model.Usuarios;
import java.util.ArrayList;


public class GenerarUsuarios {
    public static String obtenerUsuario()throws Exception{
        DAOUsuario du=new DAOUsuario();
        
   
        return du.obtenerTodos() ;
        
    }
}
