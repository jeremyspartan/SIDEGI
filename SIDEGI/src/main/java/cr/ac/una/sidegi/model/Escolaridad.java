/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_escolaridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridad.findAll", query = "SELECT e FROM Escolaridad e"),
    @NamedQuery(name = "Escolaridad.findByEscId", query = "SELECT e FROM Escolaridad e WHERE e.escId = :escId"),
    @NamedQuery(name = "Escolaridad.findByEscDescripcion", query = "SELECT e FROM Escolaridad e WHERE e.escDescripcion = :escDescripcion")})
public class Escolaridad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "esc_id")
    private Long escId;
    @Basic(optional = false)
    @Column(name = "esc_descripcion")
    private String escDescripcion;
    @OneToMany(mappedBy = "escId")
    private List<Persona> personaList;

    public Escolaridad() {
    }

    public Escolaridad(Long escId) {
        this.escId = escId;
    }

    public Escolaridad(Long escId, String escDescripcion) {
        this.escId = escId;
        this.escDescripcion = escDescripcion;
    }

    public Long getEscId() {
        return escId;
    }

    public void setEscId(Long escId) {
        this.escId = escId;
    }

    public String getEscDescripcion() {
        return escDescripcion;
    }

    public void setEscDescripcion(String escDescripcion) {
        this.escDescripcion = escDescripcion;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escId != null ? escId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridad)) {
            return false;
        }
        Escolaridad other = (Escolaridad) object;
        if ((this.escId == null && other.escId != null) || (this.escId != null && !this.escId.equals(other.escId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Escolaridad[ escId=" + escId + " ]";
    }
    
}
