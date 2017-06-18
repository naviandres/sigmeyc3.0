/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;
import com.sigmeyc.beans.SolicitudFacade;
import com.sigmeyc.beans.SolicitudFacade;
import com.sigmeyc.entities.Solicitud;
import com.sigmeyc.entities.Solicitud;
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
@FacesConverter(forClass = Solicitud.class, value = "solicitudConverter")
public class SolicitudConverter implements Converter {

    private SolicitudFacade solicitudFacade;

    public SolicitudConverter() {
        solicitudFacade = CDI.current().select(SolicitudFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return solicitudFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Solicitud) {
            Solicitud s = (Solicitud) value;
            return s.getIdSolicitud().toString();
        }
        return null;
    }
}
