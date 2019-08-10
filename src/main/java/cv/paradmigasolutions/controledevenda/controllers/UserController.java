/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import cv.paradmigasolutions.controledevenda.model.Role;
import cv.paradmigasolutions.controledevenda.model.User;
import cv.paradmigasolutions.controledevenda.services.RoleService;
import cv.paradmigasolutions.controledevenda.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @GetMapping(value = "/gerir/utilizador")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "Gerir utilizadores");
        mv.addObject("users", userService.getAllUsers());
        mv.addObject("user", new User());
        mv.addObject("roles", roleService.getAllRoles());
        mv.setViewName("home/gerir-user/home");
        return mv;
    }
    
    @PostMapping(value = "/gerir/utilizador/registrar")
    public String create(User user){
        userService.create(user);
        return "redirect:/gerir/utilizador";
    }
}
