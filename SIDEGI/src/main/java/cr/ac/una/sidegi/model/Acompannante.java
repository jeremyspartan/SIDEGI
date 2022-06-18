/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_acompannantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompannante.findAll", query = "SELECT a FROM Acompannante a"),
    @NamedQuery(name = "Acompannante.findByAcoidAcompannante", query = "SELECT a FROM Acompannante a WHERE a.acoidAcompannante = :acoidAcompannante"),
    @NamedQuery(name = "Acompannante.findByAcoParentesco", query = "SELECT a FROM Acompannante a WHERE a.acoParentesco = :acoParentesco"),
    @NamedQuery(name = "Acompannante.findByAcoOcupacion", query = "SELECT a FROM Acompannante a WHERE a.acoOcupacion = :acoOcupacion"),
    @NamedQuery(name = "Acompannante.findByAcosituacionActual", query = "SELECT a FROM Acompannante a WHERE a.acosituacionActual = :acosituacionActual")})
public class Acompannante implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "aco_idAcompannante")
    private Long acoidAcompannante;
    @Basic(optional = false)
    @Column(name = "aco_parentesco")
    private String acoParentesco;
    @Column(name = "aco_ocupacion")
    private String acoOcupacion;
    @Basic(optional = false)
    @Column(name = "aco_situacionActual")
    private String acosituacionActual;
    @JoinColumn(name = "per_cedula", referencedColumnName = "per_cedula")
    @ManyToOne
    private Persona perCedula;

    public Acompannante() {
    }

    public Acompannante(Long acoidAcompannante) {
        this.acoidAcompannante = acoidAcompannante;
    }

    public Acompannante(Long acoidAcompannante, String acoParentesco, String acosituacionActual) {
        this.acoidAcompannante = acoidAcompannante;
        this.acoParentesco = acoParentesco;
        this.acosituacionActual = acosituacionActual;
    }

    public Long getAcoidAcompannante() {
        return acoidAcompannante;
    }

    public void setAcoidAcompannante(Long acoidAcompannante) {
        this.acoidAcompannante = acoidAcompannante;
    }

    public String getAcoParentesco() {
        return acoParentesco;
    }

    public void setAcoParentesco(String acoParentesco) {
        this.acoParentesco = acoParentesco;
    }

    public String getAcoOcupacion() {
        return acoOcupacion;
    }

    public void setAcoOcupacion(String acoOcupacion) {
        this.acoOcupacion = acoOcupacion;
    }

    public String getAcosituacionActual() {
        return acosituacionActual;
    }

    public void setAcosituacionActual(String acosituacionActual) {
        this.acosituacionActual = acosituacionActual;
    }

    public Persona getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(Persona perCedula) {
        this.perCedula = perCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acoidAcompannante != null ? acoidAcompannante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompannante)) {
            return false;
        }
        Acompannante other = (Acompannante) object;
        if ((this.acoidAcompannante == null && other.acoidAcompannante != null) || (this.acoidAcompannante != null && !this.acoidAcompannante.equals(other.acoidAcompannante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Acompannante[ acoidAcompannante=" + acoidAcompannante + " ]";
    }
    
}
