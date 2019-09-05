/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.repository;

import cv.paradmigasolutions.controledevenda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author programmer
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
