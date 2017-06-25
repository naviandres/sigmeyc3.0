/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jasperreport.controller;

import com.sigmeyc.controllers.session.SessionController;
import com.sigmeyc.entities.Mercancia;
import com.sigmeyc.jsf.MercanciaController;


import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author juanc
 */
@Named(value = "jasperReportController")
@RequestScoped
public class JasperReportController {

    @Inject
    private MercanciaController c;
    
    private List<Mercancia> mercancia;
    private JasperPrint jp;

    @Inject
    SessionController sc;

    public JasperReportController() {
    }

    @PostConstruct

    public void init() {
        mercancia = c.getMercancias();
    }

    public List<Mercancia> getMercancias() {
        return mercancia;
    }

    private void prepararExport() {
        try {
            Map<String, Object> params = new HashMap<>();

            Date actual = new Date();

            params.put("NombreUsuario", sc.getUsuarioSesion().getPrimerNombre());
            params.put("fecha", actual);

            JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(mercancia);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/WEB-INF/reportes/jasper/mercancia.jasper";
            jp = JasperFillManager.fillReport(reportPath, params, bcds);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void exportarPDF() throws IOException, JRException {
        prepararExport();
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
