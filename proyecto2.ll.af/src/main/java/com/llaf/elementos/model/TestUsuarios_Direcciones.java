/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llaf.elementos.model;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;

/**
 *
 * @author campitos
 */
public class TestUsuarios_Direcciones {

    
    public static void main(String args[])throws Exception{
        DAOUsuario du=new DAOUsuario();
       System.out.println(du.obtenerTodos());
    }
    
}
