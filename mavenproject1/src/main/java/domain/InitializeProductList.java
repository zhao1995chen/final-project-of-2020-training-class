/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class InitializeProductList implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String catalogFileName
                = context.getInitParameter("catalogFileName");
        InputStream is = null;
        BufferedReader catReader = null;
        try {
            is = context.getResourceAsStream(catalogFileName);
            catReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String ProductString;
            ArrayList catalog = new ArrayList();
            while ((ProductString = catReader.readLine()) != null) {
                StringTokenizer tokens
                        = new StringTokenizer(ProductString, "|");
                String code = tokens.nextToken();
                String price = tokens.nextToken();
                String quantityStr = tokens.nextToken();
                int quantity = Integer.parseInt(quantityStr);
                String description = tokens.nextToken();
                Product p = new Product(code, price, quantity, description);
                catalog.add(p);
            }
            context.setAttribute("catalog", catalog);
            context.log("The product list was initialized.");
        } catch (Exception e) {
            context.log("Parsing catalog.txt error!");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (catReader != null) {
                try {
                    catReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
