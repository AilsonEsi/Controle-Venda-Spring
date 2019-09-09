/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

import cv.paradmigasolutions.controledevenda.model.Fornecedor;
import cv.paradmigasolutions.controledevenda.model.Produto;
import cv.paradmigasolutions.controledevenda.repository.ProdutoRepository;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;

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
        produtoRepository.save(p);

    }

    public void uploadImg(MultipartFile img, ServletContext context) {

        try {
            final String PATH = "src/main/resources/static/uploads";
            File dir = new File(PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            byte[] fileBytes = img.getBytes();
            String[] type = img.getContentType().split("/"); //get extention of file
            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + System.currentTimeMillis() + "." + type[1]);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(fileBytes);
            stream.close();

        } catch (IOException ex) {
            Logger.getLogger(ProdutoService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
