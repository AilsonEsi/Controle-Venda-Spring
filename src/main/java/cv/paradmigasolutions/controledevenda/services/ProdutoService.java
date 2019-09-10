/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

import cv.paradmigasolutions.controledevenda.model.Produto;
import cv.paradmigasolutions.controledevenda.repository.ProdutoRepository;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author programmer
 */
@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(MultipartFile img, Produto p) {

        if (p.getCreatedAt() == null) {
            p.setCreatedAt(new Date());
        }
        if (p.getUpdatedAt() == null) {
            p.setUpdatedAt(new Date());
        }

        if (!img.isEmpty()) {
            String[] type = img.getContentType().split("/"); //get extention of file
            String fileName = String.valueOf(System.currentTimeMillis() + "." + type[1]);
            p.setImgURL("http://localhost:8080/uploads/" + fileName);
            uploadImg(img, fileName);
        }
        produtoRepository.save(p);
    }

    private void uploadImg(MultipartFile img, String fileName) {

        try {
            final String PATH = "src/main/resources/static/uploads";
            File dir = new File(PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            byte[] fileBytes = img.getBytes();
            File file = new File(dir.getAbsolutePath() + File.separator + fileName);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
            stream.write(fileBytes);
            stream.close();

        } catch (IOException ex) {
            Logger.getLogger(ProdutoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
