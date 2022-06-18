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
@Table(name = "sid_casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casa.findAll", query = "SELECT c FROM Casa c"),
    @NamedQuery(name = "Casa.findByCasId", query = "SELECT c FROM Casa c WHERE c.casId = :casId"),
    @NamedQuery(name = "Casa.findByCasDescripcion", query = "SELECT c FROM Casa c WHERE c.casDescripcion = :casDescripcion")})
public class Casa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "cas_id")
    private Long casId;
    @Basic(optional = false)
    @Column(name = "cas_descripcion")
    private String casDescripcion;
    @OneToMany(mappedBy = "casId")
    private List<Estadia> estadiaList;

    public Casa() {
    }

    public Casa(Long casId) {
        this.casId = casId;
    }

    public Casa(Long casId, String casDescripcion) {
        this.casId = casId;
        this.casDescripcion = casDescripcion;
    }

    public Long getCasId() {
        return casId;
    }

    public void setCasId(Long casId) {
        this.casId = casId;
    }

    public String getCasDescripcion() {
        return casDescripcion;
    }

    public void setCasDescripcion(String casDescripcion) {
        this.casDescripcion = casDescripcion;
    }

    @XmlTransient
    public List<Estadia> getEstadiaList() {
        return estadiaList;
    }

    public void setEstadiaList(List<Estadia> estadiaList) {
        this.estadiaList = estadiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casId != null ? casId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casa)) {
            return false;
        }
        Casa other = (Casa) object;
        if ((this.casId == null && other.casId != null) || (this.casId != null && !this.casId.equals(other.casId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Casa[ casId=" + casId + " ]";
    }
    
}
