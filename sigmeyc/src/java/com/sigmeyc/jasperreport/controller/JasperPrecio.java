/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jasperreport.controller;

import com.sigmeyc.entities.Precio;
import com.sigmeyc.jsf.PrecioController;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author juanc
 */
@Named(value = "jasperPrecio")
@RequestScoped
public class JasperPrecio {
    
     private PrecioController pc;
     private List<Precio> precio;
      private JasperPrint jp;
      
      
       public JasperPrecio() {
    }

    @PostConstruct

    public void init() {
        precio = pc.getPrecios();
    }

    public List<Precio> getPrecio() {
        return precio;
    }
    
     private void prepararExportPrecio()  {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("NombreUsuario", "Administrador");
      
            JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(precio);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "/WEB-INF/reportes/jasper/precio.jasper";
            jp = JasperFillManager.fillReport(reportPath, params, bcds);
        } catch (JRException ex) {
            Logger.getLogger(jasperReportController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void exportarPDFPrecio() throws IOException, JRException {
        prepararExportPrecio();
        ServletOutputStream out = null;
        String contentType = "application/pdf";
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletResponse res = (HttpServletResponse) ec.getResponse();
        res.setContentType(contentType);
        res.addHeader("Content-disposition", "attachment; filename=\"reporte.pdf\"");
        out = res.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jp, out);
        fc.responseComplete();

    }
}
