/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;

import com.sigmeyc.beans.EmpresaFacade;
import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Empresa;
import com.sigmeyc.entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ivan
 */
@Named(value = "empresaControlle")
@SessionScoped
public class EmpresaControlle implements Serializable {

    private String codigoEmpresa;
    private int nit;
    private String razonSocial;

    private String telefono;
    private String celular;
    private String email;
    private String clave;

    private Integer codigoUsuario;
    private String tipoIdentificacion;
    private long documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    @EJB
    private EmpresaFacade empresaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;

    public EmpresaControlle() {
    }

    public EmpresaControlle(String codigoEmpresa, int nit, String razonSocial) {
        this.codigoEmpresa = codigoEmpresa;
        this.nit = nit;
        this.razonSocial = razonSocial;
    }

    public EmpresaControlle(int nit, String razonSocial, String telefono, String celular, String email, String clave) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.clave = clave;
    }

    public EmpresaControlle(String codigoEmpresa, int nit, String razonSocial, String telefono, String celular, String email, String clave, Integer codigoUsuario, String tipoIdentificacion, long documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.codigoEmpresa = codigoEmpresa;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.clave = clave;
        this.codigoUsuario = codigoUsuario;
        this.tipoIdentificacion = tipoIdentificacion;
        this.documento = documento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public EmpresaFacade getEmpresaFacade() {
        return empresaFacade;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    
    public List<Empresa> getEmpresas(){
        return this.empresaFacade.findAll();
    }
    
    public String guardar() {
//        Usuario u = new Usuario(1,"fd" , documento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, celular, email, clave);
//        Empresa e = new Empresa("454545", nit, razonSocial);
//
//        this.usuarioFacade.create(u);
//        this.empresaFacade.create(e);
        return "index";
    }

}
