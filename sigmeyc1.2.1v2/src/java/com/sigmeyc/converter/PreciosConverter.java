/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;
import com.sigmeyc.beans.PrecioFacade;
import com.sigmeyc.entities.Precio;
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
@FacesConverter(forClass = Precio.class, value = "precioConverter")
public class PreciosConverter implements Converter {

    private PrecioFacade precioFacade;

    public PreciosConverter() {
        precioFacade = CDI.current().select(PrecioFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return precioFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Precio) {
            Precio p = (Precio) value;
            return p.getIdprecios().toString();
        }
        return null;
    }
}
