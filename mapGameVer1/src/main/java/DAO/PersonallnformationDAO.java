/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import model.Personallnformation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Administrator
 */
public class PersonallnformationDAO {
    static Personallnformation userObj;
       static Session sessionObj;
       static SessionFactory sessionFactoryObj;
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addClass(Personallnformation.class);
        configObj.configure("hibernate.cfg.xml");
 
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
     public void Personallnformation(String pid, String username, String email, String password, String payList){
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
                userObj = new Personallnformation();
                userObj.setPid(pid);
                userObj.setUsername(username);
                userObj.setEmail(email);
                userObj.setPassword(password);
                userObj.setPayList(payList);
 
                sessionObj.save(userObj);
            
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");
 
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
