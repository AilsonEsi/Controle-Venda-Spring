/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import cv.paradmigasolutions.controledevenda.model.Fornecedor;
import cv.paradmigasolutions.controledevenda.services.FornecedorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping(value = "/fornecedor")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/fornecedor");
        mv.addObject("fornecedor", new Fornecedor());
        return mv;
    }

    @PostMapping(value = "/fornecedor")
    public ModelAndView save(@Valid Fornecedor fornecedor, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("/home/fornecedor");
            mv.addObject("fornecedor", fornecedor);
        } else {
            mv.setViewName("redirect:/fornecedor");
            
            fornecedorService.save(fornecedor);
        }
        return mv;

    }

}
