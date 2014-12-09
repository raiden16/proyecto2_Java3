/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llaf.elementos.model;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.singletonMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author campitos
 */
public class DAOUsuarioImpl {
    
    
    public String obtenerTodos() throws Exception{
   SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class);


ArrayList<Usuario> usuarios= (ArrayList<Usuario>)cri.list();
Map<String, ArrayList<Usuario>> singletonMap =Collections.singletonMap("usuario", usuarios);


ObjectMapper mapper=new ObjectMapper();



  
  tranza.commit();
  sesion.close();
  
  return mapper.writeValueAsString(singletonMap);
    }
    
    public String obtenerUsuarioPorId(Integer id) throws Exception{
          SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class).add(Restrictions.idEq(id));


Usuario u=(Usuario)cri.uniqueResult();


ObjectMapper mapper=new ObjectMapper();


return mapper.writeValueAsString(u);
    }
    
    
       public String obtenerPorId(Integer id) throws Exception{
       SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class).add(Restrictions.idEq(id));
Usuario usuario= (Usuario)cri.uniqueResult();

ObjectMapper mapper=new ObjectMapper();



  
  tranza.commit();
  sesion.close();
  
  return mapper.writeValueAsString(usuario);
    }
       
       
  public String obtenerPorNOmbre(String nombre) throws Exception{
       SessionFactory factory= HIbernateUtilidades.getSessionFactory();
   Session sesion=    factory.openSession();
  Transaction tranza= sesion.beginTransaction();
 
Criteria cri=sesion.createCriteria(Usuario.class).add(Restrictions.like("nombre", nombre+"%"));
Criteria cri2=sesion.createCriteria(Usuario.class).add(Restrictions.eq("nombre", nombre));
Criteria cri3=sesion.createCriteria(Usuario.class).add(Restrictions.between("edad", 18,40)).addOrder(Order.asc("nombre"));
Criteria cri4=sesion.createCriteria(Usuario.class).add(Restrictions.lt("sueldo", new Integer(4000)));
Criteria cri5=sesion.createCriteria(Usuario.class).add(Restrictions.gt("sueldo", new Integer(4000)));


ArrayList<Usuario> usuarios=(ArrayList<Usuario>) cri.list();

ObjectMapper mapper=new ObjectMapper();

Map<String ,ArrayList<Usuario>> singletonMap=Collections.singletonMap("usuarios", usuarios);



  
  tranza.commit();
  sesion.close();
  
  return mapper.writeValueAsString(singletonMap);
    }     
       
       
       
    
}
