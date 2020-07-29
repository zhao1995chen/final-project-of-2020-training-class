/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PersonallnformationDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Personallnformation;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
        PersonallnformationDAO per =new PersonallnformationDAO();
    @RequestMapping("/success")
    public ModelAndView registerSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "註冊成功");
        return mav;
    }
    @RequestMapping("/fail")
    public ModelAndView registerfail(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "註冊失敗");
        return mav;
    }
    @RequestMapping("/param")
    public ModelAndView getParam(Personallnformation user) {
        try{       
        per.Percreate(user.getPid(),user.getUsername(), user.getEmail(), user.getPassword(), user.getPayList());
        System.out.println(user.getPid());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getPayList());       
        ModelAndView mav = new ModelAndView("redirect:/success");
        return mav;
        }catch (Exception ex){
            ModelAndView mav = new ModelAndView("redirect:/fail");
            return mav;
        }
    }

    /*@ModelAttribute
    public void model(Model model) {
        model.addAttribute("message", "注解成功");
    }*/

    /*@RequestMapping("/value")
    public String handleRequest() {
        return "index";
    }*/
    
    /*@RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/hello");
        return mav;
    }*/

    /*@RequestMapping("/jump")
    public String jump() {
        return "redirect: ./hello";
    }*/
    
}
