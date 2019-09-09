/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import cv.paradmigasolutions.controledevenda.model.Produto;
import cv.paradmigasolutions.controledevenda.services.FornecedorService;
import cv.paradmigasolutions.controledevenda.services.ProdutoService;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author programmer
 */
@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {

    private final String viewName = "/home/produto/cadastro";

    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    ServletContext context;

    @GetMapping(value = "/cadastrar")
    public ModelAndView createView(Model model) {

        model.addAttribute("produto", new Produto());
        return loadModelAndView(new ModelAndView(), viewName);
    }

    @PostMapping(value = "/cadastrar")
    public ModelAndView create(@RequestParam("file") MultipartFile img, @Valid Produto produto, BindingResult result, Model model) {

        ModelAndView mv = new ModelAndView();
        produtoService.uploadImg(img, context);

        if (result.hasErrors()) {

            model.addAttribute(produto);
            return loadModelAndView(mv, viewName);

        } else {

            //produtoService.save(produto);
            return loadModelAndView(mv, "redirect:/produto/cadastrar");
        }
    }

    private ModelAndView loadModelAndView(ModelAndView mv, String viewName) {

        mv.addObject("title", "Cadastro de produto");
        mv.addObject("forncedores", fornecedorService.findAll());
        mv.setViewName(viewName);

        return mv;

    }
}
