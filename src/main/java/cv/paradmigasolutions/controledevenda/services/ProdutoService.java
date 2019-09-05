/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

import cv.paradmigasolutions.controledevenda.model.Fornecedor;
import cv.paradmigasolutions.controledevenda.model.Produto;
import cv.paradmigasolutions.controledevenda.repository.ProdutoRepository;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(Produto p) {

        if (p.getCreatedAt() == null) {
            p.setCreatedAt(new Date());
        }
        if (p.getUpdatedAt() == null) {
            p.setUpdatedAt(new Date());
        }
        //p.setFornecedor(new Fornecedor());
        produtoRepository.save(p);

    }
}
