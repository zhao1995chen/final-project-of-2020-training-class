package Listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyContecxtListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String param = context.getInitParameter("welcome");
        context.setAttribute("welcome", param);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
          ServletContext context = sce.getServletContext();
          System.out.println("contextDestroyed:"+context);
    }
}
