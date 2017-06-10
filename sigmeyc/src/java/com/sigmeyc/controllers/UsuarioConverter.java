/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;
import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Usuario;
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
@FacesConverter(forClass = Usuario.class, value = "usuarioConverter")
public class UsuarioConverter implements Converter {

    private UsuarioFacade usuarioFacade;

    public UsuarioConverter() {
        usuarioFacade = CDI.current().select(UsuarioFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return usuarioFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Usuario) {
            Usuario p = (Usuario) value;
            return p.getDocumento().toString();
        }
        return null;
    }
}
