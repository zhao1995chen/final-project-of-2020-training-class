/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PersonallnformationDAO;;
import model.Personallnformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    PersonallnformationDAO per =new PersonallnformationDAO();
    @RequestMapping("/success")
    public ModelAndView registerSuccess(Personallnformation user) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "註冊成功或登入成功。");
        return mav;
    }
    @RequestMapping("/fail")
    public ModelAndView registerfail(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "註冊失敗或登入失敗。");
        return mav;
    }
    @RequestMapping("/register")
    public ModelAndView getRegister(Personallnformation user) {  
        for (String student : per.Percheck()) {        
        if(user.getUsername().equals(student)){
        ModelAndView mav = new ModelAndView("redirect:/fail");
        return mav; 
            }    
        }
        per.Percreate(user.getPid(),user.getUsername(), user.getEmail(), user.getPassword(), user.getPayList());  
        ModelAndView mav = new ModelAndView("redirect:/success");
        return mav;
    }
    @RequestMapping("/login")
    public ModelAndView getLogin(Personallnformation user) {         
        if(per.PercheckP(user.getUsername(),user.getPassword())){
        ModelAndView mav = new ModelAndView("redirect:/success");
        return mav; 
               
        }
        ModelAndView mav = new ModelAndView("redirect:/fail");
        return mav;
    }    
    @RequestMapping("/sreach")
    public ModelAndView getSreach(Personallnformation user) {         
        ModelAndView mav = new ModelAndView("sreachsuccess", "list", per.Persearch());
        /*for (Personallnformation personallnformation : ls) { 
                mav.addObject("username", personallnformation.getUsername()); 
                mav.addObject("password", personallnformation.getPassword()); 
            }*/
        return mav;
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
