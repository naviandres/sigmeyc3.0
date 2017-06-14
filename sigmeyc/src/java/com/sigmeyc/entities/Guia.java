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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "guias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g")
    , @NamedQuery(name = "Guia.findByIdGuia", query = "SELECT g FROM Guia g WHERE g.idGuia = :idGuia")
    , @NamedQuery(name = "Guia.findByNueroGuia", query = "SELECT g FROM Guia g WHERE g.nueroGuia = :nueroGuia")
    , @NamedQuery(name = "Guia.findByDetalleMercancia", query = "SELECT g FROM Guia g WHERE g.detalleMercancia = :detalleMercancia")})
public class Guia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGuia")
    private Integer idGuia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nueroGuia")
    private String nueroGuia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detalleMercancia")
    private String detalleMercancia;
    @JoinColumn(name = "planillas_idPlanilla", referencedColumnName = "idPlanilla")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planilla planillasidPlanilla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiaidGuia", fetch = FetchType.LAZY)
    private List<Mercancia> mercanciaList;

    public Guia() {
    }

    public Guia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Guia(Integer idGuia, String nueroGuia, String detalleMercancia) {
        this.idGuia = idGuia;
        this.nueroGuia = nueroGuia;
        this.detalleMercancia = detalleMercancia;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public String getNueroGuia() {
        return nueroGuia;
    }

    public void setNueroGuia(String nueroGuia) {
        this.nueroGuia = nueroGuia;
    }

    public String getDetalleMercancia() {
        return detalleMercancia;
    }

    public void setDetalleMercancia(String detalleMercancia) {
        this.detalleMercancia = detalleMercancia;
    }

    public Planilla getPlanillasidPlanilla() {
        return planillasidPlanilla;
    }

    public void setPlanillasidPlanilla(Planilla planillasidPlanilla) {
        this.planillasidPlanilla = planillasidPlanilla;
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
        hash += (idGuia != null ? idGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idGuia == null && other.idGuia != null) || (this.idGuia != null && !this.idGuia.equals(other.idGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Guia[ idGuia=" + idGuia + " ]";
    }
    
}
