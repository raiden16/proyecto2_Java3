/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llaf.elementos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author los Paps
 */
public class DAODireccion {
    
    
    public String obtenerTodos()throws Exception{
        
    
     SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Direcciones.class);
ArrayList<Direcciones> usuarios= (ArrayList<Direcciones>)cri.list();

ObjectMapper mapper=new ObjectMapper();
Map<String, ArrayList<Direcciones>> singletonMap= Collections.singletonMap("direccion", usuarios);


  
  tranza.commit();
  sesion.close();
  System.out.println(mapper.writeValueAsString(singletonMap));
  return mapper.writeValueAsString(singletonMap);
    
    }
}