/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;
import com.sigmeyc.beans.EmpresaFacade;
import com.sigmeyc.entities.Empresa;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ivan
 */
//@Named("planillaConverterBean")
//@ManagedBean() 
@FacesConverter(forClass = Empresa.class, value = "empresaConverter")
public class EmpresaConverter implements Converter {

    private EmpresaFacade empresaFacade;

    public EmpresaConverter() {
        empresaFacade = CDI.current().select(EmpresaFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return empresaFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Empresa) {
            Empresa e = (Empresa) value;
            return e.getNit().toString();
        }
        return null;
    }
}
