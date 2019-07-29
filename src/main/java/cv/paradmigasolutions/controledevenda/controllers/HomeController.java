/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author programmer
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Principal principal ){
    
        Authentication auth = (Authentication) principal;
        System.out.println(auth.getAuthorities());
        return "home/home";
    }
}
