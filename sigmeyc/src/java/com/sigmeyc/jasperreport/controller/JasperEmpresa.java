/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jasperreport.controller;

import com.sigmeyc.entities.Empresa;
import com.sigmeyc.jsf.EmpresaController;
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
@Named(value = "jasperEmpresa")
@RequestScoped
public class JasperEmpresa {
    
     private EmpresaController e;
     private List<Empresa> empresa;
      private JasperPrint jp;
      
      
       public JasperEmpresa() {
    }

    @PostConstruct

    public void init() {
        empresa = e.getEmpresas();
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }
    
     private void prepararExportEmpresa()  {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("NombreUsuario", "Administrador");
      
            JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(empresa);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "/WEB-INF/reportes/jasper/empresa.jasper";
            jp = JasperFillManager.fillReport(reportPath, params, bcds);
        } catch (JRException ex) {
            Logger.getLogger(jasperReportController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void exportarPDFEmpresa() throws IOException, JRException {
        prepararExportEmpresa();
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
