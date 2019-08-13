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
import java.util.Optional;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
public class UserController {

    private final String title = "Gerir utilizadores";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "admin/gerir/utilizador")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", title);
        mv.addObject("users", userService.getAllUsers());
        mv.addObject("user", new User());
        mv.addObject("roles", roleService.getAllRoles());
        mv.setViewName("home/gerir-user/home");
        return mv;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "admin/gerir/utilizador/registrar")
    public ModelAndView create(@Valid User user, BindingResult result, Model model) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("title", title);
            mv.addObject("user", user);
            mv.addObject("roles", roleService.getAllRoles());
            mv.setViewName("home/gerir-user/home");
        } else {
            mv.setViewName("redirect:/admin/gerir/utilizador");
            userService.create(user);
        }
        mv.addObject("users", userService.getAllUsers());
        return mv;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "admin/gerir/utilizador/deletar/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        userService.delete(id);
        mv.addObject("title", title);
        mv.addObject("users", userService.getAllUsers());
        mv.addObject("user", new User());
        mv.addObject("roles", roleService.getAllRoles());
        mv.setViewName("redirect:/admin/gerir/utilizador");
        return mv;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("admin/gerir/utilizador/{id}")
    public String find(@PathVariable("id") Integer id, Model model) {
        Optional<User> optional = userService.findById(id);
        User presentUser = null;
        if (optional.isPresent()) {
            presentUser = (User) optional.get();
            model.addAttribute("user", presentUser);
        }

        return "redirect:/admin/gerir/utilizador";
    }
}
