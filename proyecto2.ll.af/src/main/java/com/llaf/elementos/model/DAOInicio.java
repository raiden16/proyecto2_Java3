package com.llaf.elementos.model;



import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;

public class DAOInicio {
    
private static final Logger log = Logger.getAnonymousLogger();
private static final ThreadLocal session = new ThreadLocal();

private static final SessionFactory sessionFactory = HIbernateUtilidades.getSessionFactory();
        
   public DAOInicio() {  }
                    
    public static Session getSession() {
          Session session = (Session) DAOInicio.session.get();
           if (session == null) {
             session = sessionFactory.openSession();
            DAOInicio.session.set(session);
                  }
    return session;
   }
    protected  void begin() {
          getSession().beginTransaction();
      }
  protected   void commit() {
           getSession().getTransaction().commit();
     }
  protected  void rollback() {
      try {
     getSession().getTransaction().rollback();
          } catch( HibernateException e ) {
     log.log(Level.WARNING,"No se puede hacer el roolback",e);
   }
   try {
    getSession().close();
    } catch( HibernateException e ) {
     log.log(Level.WARNING,"Imposible cerrar",e);
      }
      DAOInicio.session.set(null);
   }

    public static void close() {
     getSession().close();
      DAOInicio.session.set(null);
   }

}