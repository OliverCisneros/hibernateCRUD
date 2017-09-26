/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.test;

import com.prueba.util.HibernateUtil;
import java.sql.SQLException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Session;


/**
 *
 * @author WorkNest5
 */
public class Test {
    
    public static void main(String [] args) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        
        //Persona persona = new Persona("Hibernate", "CHIDO");
        
        //Salvar persona
        //session.save(persona);
        
     /*   Query query = session.getNamedQuery("llamarProcesoAlmacenado")
	.setParameter("id", "1036");
        
        List result = query.list();
        for(int i=0; i<result.size(); i++){
            Persona persona = (Persona)result.get(i);
            System.out.println(persona.getfName() + ", " + persona.getlName());
        }*/
       
        StoredProcedureQuery query = session.createStoredProcedureQuery("todos_jeather");

            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);

            query.setParameter(1, 1046);
            System.out.print(query.getOutputParameterValue(2));
            
        session.getTransaction().commit();
        session.close();
     
    }
}
