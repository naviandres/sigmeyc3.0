/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.fileUpload;

import com.sigmeyc.beans.fileBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author danie
 */
@Named(value = "fileUploadController")
@ViewScoped
public class FileUploadController implements Serializable {
     private final static String UPLOAD_DIR="/files/uploads/";
    
    /**
     * Creates a new instance of FileUploadController
     */
    public FileUploadController() {
    }

    @PostConstruct
    public void init() {

    }

    public void upload() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            List<fileBean> filesBeans = getFilesUpload(ec);

            for (fileBean fileBean : filesBeans) {
                savePart(ec, fileBean);
                System.out.println("Datos: " + fileBean.toString());
            }
            deleteFile(ec, "Tablero y TV.c4d");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }

    private List<fileBean> getFilesUpload(ExternalContext ec) throws IOException, ServletException {
        List<fileBean> files = new ArrayList<>();
        Collection<Part> parts = getParts(ec);
        for (Part part : parts) {
            if (part.getSize() > 0 && part.getSubmittedFileName() != null) {
                files.add(new fileBean(part.getName(), part.getContentType(), part.getSize(), part));
            }
        }
        return files;
    }

    private Collection<Part> getParts(ExternalContext ec) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) ec.getRequest();
        return rq.getParts();
    }

    private void savePart(ExternalContext ec, fileBean fileBean) throws IOException {
        File dir = new File(ec.getRealPath("") + UPLOAD_DIR);
        dir.mkdirs();
        File file = new File(dir, fileBean.getFileNameFull());
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = fileBean.getPart().getInputStream();

        byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }
   private void deleteFile(ExternalContext ec, String name){
        File dir = new File(ec.getRealPath("") + UPLOAD_DIR);
        dir.mkdirs();
        File file = new File(dir, name);
        file.delete();
   }
    
}
