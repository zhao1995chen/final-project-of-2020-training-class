package Listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author Chang
 */
public class MySessionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    ServletContext context;
     int users=0;
   
   public void contextDestroyed(ServletContextEvent sce) {
     logout("contextDestroyed()-->ServletContext被銷毀");
        this.context = null;
    }
    public void contextInitialized(ServletContextEvent sce) {
     this.context = sce.getServletContext();
     logout("MySessionListener contextInitialized()-->ServletContext初始化了");
    }//ServletContextListener


    //HttpSessionAttributeListener
    public void attributeAdded(HttpSessionBindingEvent event) {
 
     logout("attributeAdded('" + event.getSession().getId() + "', '" +
         event.getName() + "', '" + event.getValue() + "')");
    }
    public void attributeRemoved(HttpSessionBindingEvent event) {
 
     logout("attributeRemoved('" + event.getSession().getId() + "', '" +
         event.getName() + "', '" + event.getValue() + "')");
    }
    public void attributeReplaced(HttpSessionBindingEvent se)
    {
    logout("attributeReplaced('"+se.getSession().getId()+",'"+se.getName()+"','"+se.getValue()+"')");
    }//HttpSessionAttributeListener
     //HttpSessionListener
    public void sessionCreated(HttpSessionEvent event) {
     users++;
     logout("sessionCreated('" + event.getSession().getId() + "'),目前有"+users+"個用戶");
     context.setAttribute("users",new Integer(users));
    }
    public void sessionDestroyed(HttpSessionEvent event) {
     users--;
     logout("sessionDestroyed('" + event.getSession().getId() + "'),目前有"+users+"個用戶");
     context.setAttribute("users",new Integer(users));
    }//HttpSessionListener

    
     private void logout(String message) {
         System.out.println(message);
    } 

}
