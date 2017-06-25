/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;

import com.sigmeyc.beans.MarcaFacade;
import com.sigmeyc.entities.Marca;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

/**
 *
 * @author danie
 */
@FacesConverter(forClass = Marca.class, value="marcaConverter")
public class MarcaConverter implements Converter {
    
    private MarcaFacade marcaFacade;
    
    public MarcaConverter(){
    marcaFacade = CDI.current().select(MarcaFacade.class).get();
    }
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        if (value != null && value.length()>0) {
            return marcaFacade.find(Integer.valueOf(value));
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Marca) {
            Marca l = (Marca) value;
            return l.getIdMarca().toString();
        }
        return null;
    }
}
