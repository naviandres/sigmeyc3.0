//package com.sigmeyc.jasperreport.controller;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import com.sigmeyc.beans.MercanciaFacadeLocal;
//import com.sigmeyc.entities.Mercancia;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//
///**
// *
// * @author juanc
// */
//@Named(value = "jasperReportController")
//@RequestScoped
//public class jasperReportController {
//
//    @EJB
//    private MercanciaFacadeLocal mfl;
//    private List<Mercancia> mercancias;
//    private JasperPrint jp;
//
//    /**
//     * Creates a new instance of jasperReport
//     */
//    public jasperReportController() {
//    }
//
//    @PostConstruct
//
//    public void init() {
//        mercancias = mfl.findAll();
//    }
//
//    public List<Mercancia> getMercancia() {
//        return mercancias;
//    }
//
//    private void prepararExport()  {
//        try {
//            Map<String, Object> params = new HashMap<>();
//            params.put("NombreUsuario", "Administrador");
//            params.put("fecha", jp);
//            JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(mercancias);
//            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "/WEB-INF/reportes/jasper/reporte2.jasper";
//            jp = JasperFillManager.fillReport(reportPath, params, bcds);
//        } catch (JRException ex) {
//            Logger.getLogger(jasperReportController.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    public void exportarPDF() throws IOException, JRException {
//        prepararExport();
//        ServletOutputStream out = null;
//        String contentType = "application/pdf";
//        FacesContext fc = FacesContext.getCurrentInstance();
//        ExternalContext ec = fc.getExternalContext();
//        HttpServletResponse res = (HttpServletResponse) ec.getResponse();
//        res.setContentType(contentType);
//        res.addHeader("Content-disposition", "attachment; filename=\"reporte.pdf\"");
//        out = res.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jp, out);
//        fc.responseComplete();
//
//    }
//}
