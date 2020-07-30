package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PersonController {

    private PersonService personService;
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    @RequestMapping(value = "/jq", method = RequestMethod.GET)
    public String listJq(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "jq";
    }
    //For add and update person both

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {
        for (String person : this.personService.PersonsCheck()) {            
            if (p.getUsername().equals(person)) {
                return "redirect:/persons";
            }
        }
        this.personService.addPerson(p);
        return "redirect:/jq";

    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loPerson(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "login";
    }
    @RequestMapping(value = "/login/in", method = RequestMethod.POST)
    public String inLoPerson(@ModelAttribute("person") Person p) {
        if (this.personService.PersonsLogin(p.getUsername(), p.getPassword())) {
            return "redirect:/home";

        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home";
    }

    @RequestMapping("/remove/{pid}")
    public String removePerson(@PathVariable("pid") int id) {

        this.personService.removePerson(id);
        return "redirect:/jq";
    }

    @RequestMapping("/edit/{pid}")
    public String editPerson(@PathVariable("pid") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

}
