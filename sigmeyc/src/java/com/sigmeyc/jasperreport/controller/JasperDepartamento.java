/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jasperreport.controller;

import com.sigmeyc.entities.Departamento;
import com.sigmeyc.jsf.DepartamentoController;
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
@Named(value = "jasperDepartamento")
@RequestScoped
public class JasperDepartamento {
    
     private DepartamentoController d;
     private List<Departamento> departamento;
      private JasperPrint jp;
      
      
       public JasperDepartamento() {
    }

    @PostConstruct

    public void init() {
        departamento = d.getDepartamentos();
    }

    public List<Departamento> getDepartamento() {
        return departamento;
    }
    
     private void prepararExportDepartamento()  {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("NombreUsuario", "Administrador");
      
            JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(departamento);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "/WEB-INF/reportes/jasper/departamento.jasper";
            jp = JasperFillManager.fillReport(reportPath, params, bcds);
        } catch (JRException ex) {
            Logger.getLogger(jasperReportController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void exportarPDFDepartamento() throws IOException, JRException {
        prepararExportDepartamento();
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
