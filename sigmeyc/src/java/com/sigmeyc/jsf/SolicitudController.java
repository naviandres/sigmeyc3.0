package com.sigmeyc.jsf;

import com.sigmeyc.beans.SolicitudFacade;
import com.sigmeyc.controllers.session.SessionController;
import com.sigmeyc.entities.Usuario;
import com.sigmeyc.entities.Solicitud;
import com.sigmeyc.jsf.util.MessageUtil;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Named("solicitudController")
@SessionScoped
public class SolicitudController implements Serializable {

    @EJB
    private SolicitudFacade solicitudFacade;

    private Solicitud solicitud;

    private SessionController sc;

    private Date fechaR;
//    DIRECCION ORIGEN
    private String carr, num1, abece1, biz1, sur1, num2, abece, biz2, num3, norte1;
//    Direccion destino
    private String carrD, num1D, abeceD1, biz1D, sur1D, num2D, abeceD, biz2D, num3D, norte1D;

    public SolicitudController() {
    }

    @PostConstruct
    public void init() {
        solicitud = new Solicitud();
        sc = new SessionController();
    }

    public Date getFechaR() {
        return fechaR;
    }

    public void setFechaR(Date fechaR) {
        this.fechaR = fechaR;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public String getCarr() {
        return carr;
    }

    public void setCarr(String carr) {
        this.carr = carr;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getAbece1() {
        return abece1;
    }

    public void setAbece1(String abece1) {
        this.abece1 = abece1;
    }

    public String getBiz1() {
        return biz1;
    }

    public void setBiz1(String biz1) {
        this.biz1 = biz1;
    }

    public String getSur1() {
        return sur1;
    }

    public void setSur1(String sur1) {
        this.sur1 = sur1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getAbece() {
        return abece;
    }

    public void setAbece(String abece) {
        this.abece = abece;
    }

    public String getBiz2() {
        return biz2;
    }

    public void setBiz2(String biz2) {
        this.biz2 = biz2;
    }

    public String getNum3() {
        return num3;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }

    public String getNorte1() {
        return norte1;
    }

    public void setNorte1(String norte1) {
        this.norte1 = norte1;
    }

    public String getCarrD() {
        return carrD;
    }

    public void setCarrD(String carrD) {
        this.carrD = carrD;
    }

    public String getNum1D() {
        return num1D;
    }

    public void setNum1D(String num1D) {
        this.num1D = num1D;
    }

    public String getAbeceD1() {
        return abeceD1;
    }

    public void setAbeceD1(String abeceD1) {
        this.abeceD1 = abeceD1;
    }

    public String getBiz1D() {
        return biz1D;
    }

    public void setBiz1D(String biz1D) {
        this.biz1D = biz1D;
    }

    public String getSur1D() {
        return sur1D;
    }

    public void setSur1D(String sur1D) {
        this.sur1D = sur1D;
    }

    public String getNum2D() {
        return num2D;
    }

    public void setNum2D(String num2D) {
        this.num2D = num2D;
    }

    public String getAbeceD() {
        return abeceD;
    }

    public void setAbeceD(String abeceD) {
        this.abeceD = abeceD;
    }

    public String getBiz2D() {
        return biz2D;
    }

    public void setBiz2D(String biz2D) {
        this.biz2D = biz2D;
    }

    public String getNum3D() {
        return num3D;
    }

    public void setNum3D(String num3D) {
        this.num3D = num3D;
    }

    public String getNorte1D() {
        return norte1D;
    }

    public void setNorte1D(String norte1D) {
        this.norte1D = norte1D;
    }

    public String registroSolicitudRecepcionista() {
        Boolean f = guardar();
        if (f) {
            return "/app/crud/mercancia/Create.xhtml?faces-redirect=true";
        } else {
            return "/app/recepcion/registarsoliciud.xhtml?faces-redirect=true";
        }
    }

    public void persistirSolicitud() {
        solicitud.setIdSolicitud(null);
        Usuario us = sc.getUsuarioSesion();
        solicitud.setUsuariosDocumento(us);
        String nRol = sc.getUsuarioSesion().getRoles().get(0).getNombreRol();
        if (nRol.equals("cliente")) {
            solicitud.setEstadoSolicitud("Sin recoger");
        } else {
            solicitud.setEstadoSolicitud("En recepcion");
        }
        solicitud.setFechaRecoleccion(fechaR);
        solicitud.setDireccionOrigen(direccionOrigen());
        solicitud.setDireccionDestino(direccionDestino());
//        this.solicitudFacade.create(solicitud);
        init();
    }

    public String direccionOrigen() {
        String dirOri = carr + " " + num1 + abece1 + biz1 + " " + sur1 + " " + "#" + num2 + abece + biz2 + "-" + num3 + norte1;
        MessageUtil.enviarMensajeInformacion("dirOr", "Ingrese los datos de mercancia para completar la solicitud", "Dírijase a la pestaña mercancia");
        MessageUtil.enviarMensajeErrorGlobal("Datos obligatorios", "Ingrese email y clave");
        return dirOri;
    }

    public String direccionDestino() {

        String dirOriD = carrD + " " + num1D + abeceD1 + biz1D + " " + sur1D + " " + "#" + num2D + abeceD + biz2D + "-" + num3D + norte1D;
        MessageUtil.enviarMensajeInformacion("dirDes", "Ingrese los datos de mercancia para completar la solicitud", "Dírijase a la pestaña mercancia");

        return dirOriD;
    }

    public Boolean guardar() {
        try {
            Date fechaActual = new Date();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String hora1 = "01:00:00";//tener presente
            String hora2 = "09:00:00";
            String horaNueva = dateFormat.format(fechaActual);
            Date date1, date2, dateNueva;
            date1 = dateFormat.parse(hora1);
            date2 = dateFormat.parse(hora2);
            dateNueva = dateFormat.parse(horaNueva);

            solicitud.setHora(horaNueva);
            solicitud.setFechaSolicitud(fechaActual);
            if (fechaR.before(fechaActual)) {
                System.out.println("Igual");
//anotadion: si el valor de la cadena es es menor que el valor de la cadena pasado como parametro retorna valor negativo y si es al contrario(valor
//de la cadena es mayor que el parametro, retorna valor positivo.si son iguales el valor es 0
                if ((date1.compareTo(dateNueva) <= 0) && (date2.compareTo(dateNueva) >= 0)) {
                    System.out.println("Registro " + horaNueva);
                    solicitud.setPriorizacion("alta");
                    putSolicitud();
                    persistirSolicitud();
                    MessageUtil.enviarMensajeInformacion("solicindex", "Ingrese los datos de mercancia para completar la solicitud", "Dírijase a la pestaña mercancia");

                    return true;
                } else {
                    System.out.println("Tiene que realizar la solicitud antes de" + hora2);
                    solicitud.setPriorizacion("media");
                    putSolicitud();
                    persistirSolicitud();
                    MessageUtil.enviarMensajeInformacion("solicindex", "Ingrese los datos de mercancia para completar la solicitud", "Dírijase a la pestaña mercancia");
                    return true;
                }
            } else {
                System.out.println("Recoleccion fecha..." + fechaR);
                solicitud.setPriorizacion("baja");
                putSolicitud();
                persistirSolicitud();
                MessageUtil.enviarMensajeInformacion("solicindex", "Ingrese los datos de mercancia para completar la solicitud", "Dírijase a la pestaña mercancia");
                return true;
            }
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return false;
    }
    
     public void modal(Solicitud s) {
        setSolicitud(s);
    }

    public char[] getAbecedario() {
        char[] s;
        s = new char[26];
        for (int i = 0; i < 26; i++) {
            s[i] = (char) ('A' + i);
        }
        return s;
    }

    public List<String> getAbecedarioLis() {
        List<String> bi = new ArrayList<>();
        bi.add("A");
        bi.add("B");
        bi.add("C");
        bi.add("D");
        bi.add("F");
        bi.add("G");
        bi.add("H");
        bi.add("I");
        bi.add("J");
        bi.add("K");
        bi.add("L");
        bi.add("M");
        bi.add("N");
        bi.add("O");
        bi.add("P");
        bi.add("Q");
        bi.add("R");
        bi.add("S");
        bi.add("T");
        bi.add("U");
        bi.add("V");
        bi.add("W");
        bi.add("X");
        bi.add("Y");
        bi.add("Z");
        return bi;
    }

    public List<String> getAbecedarioLisB() {
        List<String> bi = new ArrayList<>();
        bi.add("A bis");
        bi.add("B bis");
        bi.add("C bis");
        bi.add("D bis");
        bi.add("F bis");
        bi.add("G bis");
        bi.add("H bis");
        bi.add("I bis");
        bi.add("J bis");
        bi.add("K bis");
        bi.add("L bis");
        bi.add("M bis");
        bi.add("N bis");
        bi.add("O bis");
        bi.add("P bis");
        bi.add("Q bis");
        bi.add("R bis");
        bi.add("S bis");
        bi.add("T bis");
        bi.add("U bis");
        bi.add("V bis");
        bi.add("W bis");
        bi.add("X bis");
        bi.add("Y bis");
        bi.add("Z bis");
        return bi;
    }

    public void putSolicitud() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.getSessionMap().put("solicitud", solicitud);
    }

    public Solicitud getSolicitudContex() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Solicitud) ec.getSessionMap().get("solicitud");
    }

    public String fecha() {
        Date fechaActual = new Date();
        DateFormat format = new SimpleDateFormat("dd/MM/yy");
        String fechaNue = format.format(fechaActual);
        return fechaNue;
    }

    public String prepareCreate() {
        return "/app/crud/solicitud/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Solicitud s) {
        this.solicitud = s;
        return "/app/crud/solicitud/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/solicitud/List.xhtml?faces-redirect=true";
    }

    public List<Solicitud> getSolicitudes() {
        return this.solicitudFacade.findAll();
    }

    public String eliminar(Solicitud s) {
        this.solicitudFacade.remove(s);
        return "/app/crud/solicitud/List.xhtml?faces-redirect=true";
    }

    public String editar(Solicitud s) {
        setSolicitud(s);
        return "/app/crud/solicitud/Edit.xhtml?faces-redirect=true";
    }

    public String guardarEdicion() {
        System.out.println("solici "+solicitud.getEstadoSolicitud());
        this.solicitudFacade.edit(solicitud);
        return "/app/crud/solicitud/List.xhtml?faces-redirect=true";
    }

    public String destruirVer(Integer idSolicitud) {

        return "/app/crud/solicitud/List.xhtml?faces-redirect=true";
    }

}
