/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import cv.paradmigasolutions.controledevenda.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping(value = "/cadastro")
    public ModelAndView cadastro() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("forncedores", fornecedorService.findAll(new Sort(Sort.Direction.DESC, "fn_id")));
        mv.setViewName("/home/produto/cadastro");
        return mv;

    }
}
