package demo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

public class HelloController implements Controller {

    private String viewPage;

    public ModelAndView handleRequest(HttpServletRequest req,  HttpServletResponse res)    throws Exception {
        String user = req.getParameter("user");
        return new ModelAndView(viewPage, "user", user);
    }

    public void setViewPage(String viewPage) {
        this.viewPage = viewPage;
    }
}
