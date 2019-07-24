/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.repository;

import cv.paradmigasolutions.controledevenda.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author programmer
 */
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    
}
