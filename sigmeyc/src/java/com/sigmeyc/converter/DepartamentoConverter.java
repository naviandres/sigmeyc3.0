/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;

import com.sigmeyc.beans.DepartamentoFacade;
import com.sigmeyc.entities.Departamento;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author juanc
 */
@FacesConverter(forClass = Departamento.class, value = "departamentoConverter")
public class DepartamentoConverter implements Converter {

    private DepartamentoFacade departamentoFacade;

    public DepartamentoConverter() {
        departamentoFacade = CDI.current().select(DepartamentoFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return departamentoFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Departamento) {
            Departamento e = (Departamento) value;
            return e.getIdDepartamento().toString();
        }
        return null;
    }
}
