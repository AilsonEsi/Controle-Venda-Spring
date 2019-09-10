/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.controllers;

import com.sun.media.jfxmedia.logging.Logger;
import cv.paradmigasolutions.controledevenda.model.Produto;
import cv.paradmigasolutions.controledevenda.services.FornecedorService;
import cv.paradmigasolutions.controledevenda.services.ProdutoService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProdutoController {

    private static final String VIEWNAME = "/home/produto/cadastro";

    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/cadastrar")
    public ModelAndView createView(Model model) {

        model.addAttribute("produto", new Produto());
        return loadModelAndView(new ModelAndView(), VIEWNAME);
    }

    @PostMapping(value = "/cadastrar")
    public ModelAndView create(@RequestParam("file") MultipartFile img, @Valid Produto produto,
            BindingResult result, Model model, HttpServletRequest request) throws UnknownHostException {

        ModelAndView mv = new ModelAndView();

        if (result.hasErrors()) {

            model.addAttribute(produto);
            return loadModelAndView(mv, VIEWNAME);

        } else {

            produtoService.save(img, produto);
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
