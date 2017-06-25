/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.fileUpload;

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
@Named(value = "fileUpload")
@ViewScoped
public class fileUpload implements Serializable {

    private Part filePart;

    public fileUpload() {

    }

    @PostConstruct
    public void init() {

    }

    public Part getFilepart() {
        return filePart;
    }

    public void setFilepart(Part filepart) {
        this.filePart = filepart;
    }

    public void uploadFiles() throws ServletException {
        try {
            List<Part> pFiles = getPartsFiles();
            for (Part filePart : pFiles) {
                System.out.println("Datose del archivo:");
                System.out.println("Name 1: " + filePart.getName());
                System.out.println("Name 2: " + filePart.getSubmittedFileName());
                System.out.println("Type: " + filePart.getContentType());
                System.out.println("Size: " + filePart.getSize());
                saveFile(filePart);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void uploadFile() {
        try {
            System.out.println("Datos del archivo:");
            System.out.println("Name 1: " + filePart.getName());
            System.out.println("Name 2: " + filePart.getSubmittedFileName());
            System.out.println("Type: " + filePart.getContentType());
            System.out.println("Size: " + filePart.getSize());
            saveFile(filePart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Part> getPartsFiles() throws IOException, ServletException {
        List<Part> partsFiles = new ArrayList<>();
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest rq = (HttpServletRequest) ec.getRequest();
        Collection<Part> parts = rq.getParts();
        for (Part part : parts) {
            if (part.getSize() > 0 && part.getSubmittedFileName() != null) {
                partsFiles.add(part);
            }
        }
        return partsFiles;
    }

    private void saveFile(Part p) throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        String path = ec.getRealPath("") + "/WEB-INF/files/documentos/";
        File dir = new File(path);
        dir.mkdirs();
        File file = new File(dir, getNameFile(p.getSubmittedFileName()));
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = p.getInputStream();

        byte[] buffer = new byte[1024];
        int lenght;
        
        while ((lenght = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, lenght);
        }
        outputStream.close();
        inputStream.close();
    }

    private String getNameFile(String path) {
        String[] datos = path.split("\\\\");
        return datos[datos.length-1];
    }

    private String getExtention(String path) {
        String[] datos = path.split("\\.");
        return datos[datos.length - 1];
    }

    private String getOnlyNameFile(String path) {
        String[] datos = path.split("\\.");
        String[] datos2 = path.split("\\\\");
        return datos2[datos2.length - 1];
    }
}
