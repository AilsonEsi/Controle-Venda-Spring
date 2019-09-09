/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

import cv.paradmigasolutions.controledevenda.model.Fornecedor;
import cv.paradmigasolutions.controledevenda.repository.FornecedorRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void save(Fornecedor fornecedor) {

        if (fornecedor.getCreatedAt() == null) {
            fornecedor.setCreatedAt(new Date());
        }
        if (fornecedor.getUpdatedAt() == null) {
            fornecedor.setUpdatedAt(new Date());
        }
        fornecedorRepository.save(fornecedor);
    }
    
    public List<Fornecedor> findAll(){
    
        return fornecedorRepository.findAll();
    }
}
