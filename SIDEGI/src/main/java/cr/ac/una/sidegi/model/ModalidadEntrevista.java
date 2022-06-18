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
@Table(name = "sid_modalidadesentrevista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadEntrevista.findAll", query = "SELECT m FROM ModalidadEntrevista m"),
    @NamedQuery(name = "ModalidadEntrevista.findByMeId", query = "SELECT m FROM ModalidadEntrevista m WHERE m.meId = :meId"),
    @NamedQuery(name = "ModalidadEntrevista.findByMeModalidad", query = "SELECT m FROM ModalidadEntrevista m WHERE m.meModalidad = :meModalidad")})
public class ModalidadEntrevista implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "me_id")
    private BigDecimal meId;
    @Basic(optional = false)
    @Column(name = "me_modalidad")
    private String meModalidad;
    @OneToMany(mappedBy = "meId")
    private List<Entrevista> entrevistaList;

    public ModalidadEntrevista() {
    }

    public ModalidadEntrevista(BigDecimal meId) {
        this.meId = meId;
    }

    public ModalidadEntrevista(BigDecimal meId, String meModalidad) {
        this.meId = meId;
        this.meModalidad = meModalidad;
    }

    public BigDecimal getMeId() {
        return meId;
    }

    public void setMeId(BigDecimal meId) {
        this.meId = meId;
    }

    public String getMeModalidad() {
        return meModalidad;
    }

    public void setMeModalidad(String meModalidad) {
        this.meModalidad = meModalidad;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistaList() {
        return entrevistaList;
    }

    public void setEntrevistaList(List<Entrevista> entrevistaList) {
        this.entrevistaList = entrevistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meId != null ? meId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadEntrevista)) {
            return false;
        }
        ModalidadEntrevista other = (ModalidadEntrevista) object;
        if ((this.meId == null && other.meId != null) || (this.meId != null && !this.meId.equals(other.meId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.ModalidadEntrevista[ meId=" + meId + " ]";
    }
    
}
