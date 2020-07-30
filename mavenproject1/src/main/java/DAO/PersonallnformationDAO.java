/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import antlr.StringUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.Personallnformation;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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

    public void Percreate(String username, String email, String password, String payList) {
        System.out.println(".......Hibernate Maven Example.......\n");
        String pid = "p" + (int) (Math.random() * 1000000) + 1;
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
            System.out.println(pid);
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public List<Personallnformation> Persearch() {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            List<Personallnformation> ls = sessionObj.createCriteria(Personallnformation.class).list();
            for (Personallnformation personallnformation : ls) {
                System.out.println(personallnformation);
            } // 提交資料 saveOrUpdate意為:存在修改,不存在增加 修改也可以用Update // session.saveOrUpdate(st);

            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            return ls;
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return null;
    }

    public List<String> Percheck() {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            List<String> ls = sessionObj.createQuery("select username from Personallnformation").list();
            for (String student : ls) {
                System.out.println(student);
            }

            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            return ls;
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return null;
    }

    public boolean PercheckP(String accountT, String passwordsT) {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            Criteria criteria = sessionObj.createCriteria(Personallnformation.class);
            Iterator Personallnformations = criteria.list().iterator();
            while (Personallnformations.hasNext()) {
                Personallnformation personallnformation = (Personallnformation) Personallnformations.next();
                if (personallnformation.getUsername().equals(accountT) && personallnformation.getPassword().equals(passwordsT)) {
                    return true;
                }
            }
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return false;
    }

}
