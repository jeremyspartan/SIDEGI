/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Acompannante.findByAcoidAcompannante", query = "SELECT a FROM Acompannante a WHERE a.idAcompannante = :idAcompannante"),
    @NamedQuery(name = "Acompannante.findByAcoParentesco", query = "SELECT a FROM Acompannante a WHERE a.parentesco = :parentesco"),
    @NamedQuery(name = "Acompannante.findByAcoOcupacion", query = "SELECT a FROM Acompannante a WHERE a.ocupacion = :ocupacion"),
    @NamedQuery(name = "Acompannante.findByAcosituacionActual", query = "SELECT a FROM Acompannante a WHERE a.situacionActual = :situacionActual")})
public class Acompannante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aco_idAcompannante")
    private Integer idAcompannante;
    @Basic(optional = false)
    @Column(name = "aco_parentesco")
    private String parentesco;
    @Column(name = "aco_ocupacion")
    private String ocupacion;
    @Basic(optional = false)
    @Column(name = "aco_situacionActual")
    private String situacionActual;
    @JoinColumn(name = "aco_cedula", referencedColumnName = "per_cedula")
    @ManyToOne
    private Persona cedula;

    public Acompannante() {
    }

    public Acompannante(Integer acoidAcompannante) {
        this.idAcompannante = acoidAcompannante;
    }

    public Acompannante(Integer acoidAcompannante, String acoParentesco, String acosituacionActual) {
        this.idAcompannante = acoidAcompannante;
        this.parentesco = acoParentesco;
        this.situacionActual = acosituacionActual;
    }

    public Integer getIdAcompannante() {
        return idAcompannante;
    }

    public void setIdAcompannante(Integer idAcompannante) {
        this.idAcompannante = idAcompannante;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getSituacionActual() {
        return situacionActual;
    }

    public void setSituacionActual(String situacionActual) {
        this.situacionActual = situacionActual;
    }

    public Persona getCedula() {
        return cedula;
    }

    public void setCedula(Persona cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcompannante != null ? idAcompannante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompannante)) {
            return false;
        }
        Acompannante other = (Acompannante) object;
        if ((this.idAcompannante == null && other.idAcompannante != null) || (this.idAcompannante != null && !this.idAcompannante.equals(other.idAcompannante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Acompannante[ acoidAcompannante=" + idAcompannante + " ]";
    }
    
}
