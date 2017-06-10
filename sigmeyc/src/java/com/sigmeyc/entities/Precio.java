/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precio.findAll", query = "SELECT p FROM Precio p")
    , @NamedQuery(name = "Precio.findByIdprecios", query = "SELECT p FROM Precio p WHERE p.idprecios = :idprecios")
    , @NamedQuery(name = "Precio.findByValor", query = "SELECT p FROM Precio p WHERE p.valor = :valor")})
public class Precio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprecios")
    private Integer idprecios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preciosIdprecios", fetch = FetchType.LAZY)
    private List<Mercancia> mercanciaList;

    public Precio() {
    }

    public Precio(Integer idprecios) {
        this.idprecios = idprecios;
    }

    public Precio(Integer idprecios, double valor) {
        this.idprecios = idprecios;
        this.valor = valor;
    }

    public Integer getIdprecios() {
        return idprecios;
    }

    public void setIdprecios(Integer idprecios) {
        this.idprecios = idprecios;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<Mercancia> getMercanciaList() {
        return mercanciaList;
    }

    public void setMercanciaList(List<Mercancia> mercanciaList) {
        this.mercanciaList = mercanciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprecios != null ? idprecios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precio)) {
            return false;
        }
        Precio other = (Precio) object;
        if ((this.idprecios == null && other.idprecios != null) || (this.idprecios != null && !this.idprecios.equals(other.idprecios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Precio[ idprecios=" + idprecios + " ]";
    }
    
}
