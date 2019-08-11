/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
public class AccountController {

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request, Model model) {
        if (request.getUserPrincipal() == null) {
            model.addAttribute("title", "Login | Informe os dados de sua conta");
            return "account/login";
        } else {
            return "redirect:/";
        }
    }

//    @GetMapping(value = "/registar")
//    public String signUp() {
//
//        return "account/signup";
//    }
}
