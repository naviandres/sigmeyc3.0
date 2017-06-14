/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;
import com.sigmeyc.beans.VehiculoFacade;
import com.sigmeyc.entities.Vehiculo;

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
@FacesConverter(forClass = Vehiculo.class, value = "vehiculoConverter")
public class VehiculoConverter implements Converter {

    private VehiculoFacade vehiculoFacade;

    public VehiculoConverter() {
        vehiculoFacade = CDI.current().select(VehiculoFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return vehiculoFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Vehiculo) {
            Vehiculo v = (Vehiculo) value;
            return v.getIdVehiculo().toString();
        }
        return null;
    }
}
