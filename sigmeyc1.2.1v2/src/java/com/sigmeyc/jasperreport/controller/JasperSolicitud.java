/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jasperreport.controller;

import com.sigmeyc.controllers.session.SessionController;
import com.sigmeyc.entities.Solicitud;
import com.sigmeyc.jsf.SolicitudController;
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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author juanc
 */
@Named(value = "jasperSolicitud")
@RequestScoped
public class JasperSolicitud {

    @Inject
    private SolicitudController s;
    private List<Solicitud> solicitud;
    private JasperPrint jp;

    @Inject
    SessionController sc;

    public JasperSolicitud() {
    }

    @PostConstruct

    public void init() {
        solicitud = s.getSolicitudes();
    }

    public List<Solicitud> getSolicitud() {
        return solicitud;
    }

    private void prepararExportSolicitud() {
        try {
            Map<String, Object> params = new HashMap<>();
            Date actual = new Date();

            params.put("NombreUsuario", sc.getUsuarioSesion().getPrimerNombre());
            params.put("fecha", actual);

            JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(solicitud);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + "/WEB-INF/reportes/jasper/solicitud.jasper";
            jp = JasperFillManager.fillReport(reportPath, params, bcds);
        } catch (JRException ex) {
            Logger.getLogger(JasperSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void exportarPDFSolicitud() throws IOException, JRException {
        prepararExportSolicitud();
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
