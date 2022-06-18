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
@Table(name = "sid_tiposseguros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSeguro.findAll", query = "SELECT t FROM TipoSeguro t"),
    @NamedQuery(name = "TipoSeguro.findBySegId", query = "SELECT t FROM TipoSeguro t WHERE t.segId = :segId"),
    @NamedQuery(name = "TipoSeguro.findBySegDescripcion", query = "SELECT t FROM TipoSeguro t WHERE t.segDescripcion = :segDescripcion")})
public class TipoSeguro implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "seg_id")
    private Long segId;
    @Basic(optional = false)
    @Column(name = "seg_descripcion")
    private String segDescripcion;
    @OneToMany(mappedBy = "segId")
    private List<Persona> personaList;

    public TipoSeguro() {
    }

    public TipoSeguro(Long segId) {
        this.segId = segId;
    }

    public TipoSeguro(Long segId, String segDescripcion) {
        this.segId = segId;
        this.segDescripcion = segDescripcion;
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public String getSegDescripcion() {
        return segDescripcion;
    }

    public void setSegDescripcion(String segDescripcion) {
        this.segDescripcion = segDescripcion;
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
        hash += (segId != null ? segId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSeguro)) {
            return false;
        }
        TipoSeguro other = (TipoSeguro) object;
        if ((this.segId == null && other.segId != null) || (this.segId != null && !this.segId.equals(other.segId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoSeguro[ segId=" + segId + " ]";
    }
    
}
