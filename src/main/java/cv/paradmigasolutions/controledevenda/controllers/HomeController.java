/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
public class HomeController {
    
    @Value("${spring.application.name}")
    private String appName;
    
    @GetMapping("/")
    public ModelAndView home(Principal principal ){
    
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/home");
        mv.addObject("appName", appName);
        //Authentication auth = (Authentication) principal;
        //System.out.println(auth.getAuthorities());
        return mv;
    }
}
