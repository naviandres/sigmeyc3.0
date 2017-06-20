/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.beans;

import com.sigmeyc.entities.Mercancia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juanc
 */
@Local
public interface MercanciaFacadeLocal {

    void create(Mercancia mercancia);

    void edit(Mercancia mercancia);

    void remove(Mercancia mercancia);

    Mercancia find(Object id);

    List<Mercancia> findAll();

    List<Mercancia> findRange(int[] range);

    int count();
    
}
