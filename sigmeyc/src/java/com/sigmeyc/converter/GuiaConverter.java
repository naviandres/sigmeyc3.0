/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;
import com.sigmeyc.beans.GuiaFacade;
import com.sigmeyc.entities.Guia;
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
@FacesConverter(forClass = Guia.class, value = "guiaConverter")
public class GuiaConverter implements Converter {

    private GuiaFacade guiaFacade;

    public GuiaConverter() {
        guiaFacade = CDI.current().select(GuiaFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return guiaFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Guia) {
            Guia g = (Guia) value;
            return g.getIdGuia().toString();
        }
        return null;
    }
}
