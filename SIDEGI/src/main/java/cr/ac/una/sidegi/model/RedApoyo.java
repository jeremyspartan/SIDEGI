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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sid_redapoyos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedApoyo.findAll", query = "SELECT r FROM RedApoyo r"),
    @NamedQuery(name = "RedApoyo.findByRaId", query = "SELECT r FROM RedApoyo r WHERE r.raId = :raId"),
    @NamedQuery(name = "RedApoyo.findByRaDescripcion", query = "SELECT r FROM RedApoyo r WHERE r.raDescripcion = :raDescripcion")})
public class RedApoyo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ra_id")
    private BigDecimal raId;
    @Basic(optional = false)
    @Column(name = "ra_descripcion")
    private String raDescripcion;
    @OneToMany(mappedBy = "raId")
    private List<Entrevista> entrevistaList;
    @JoinColumn(name = "tra_id", referencedColumnName = "tra_id")
    @ManyToOne
    private TipoRedApoyo traId;

    public RedApoyo() {
    }

    public RedApoyo(BigDecimal raId) {
        this.raId = raId;
    }

    public RedApoyo(BigDecimal raId, String raDescripcion) {
        this.raId = raId;
        this.raDescripcion = raDescripcion;
    }

    public BigDecimal getRaId() {
        return raId;
    }

    public void setRaId(BigDecimal raId) {
        this.raId = raId;
    }

    public String getRaDescripcion() {
        return raDescripcion;
    }

    public void setRaDescripcion(String raDescripcion) {
        this.raDescripcion = raDescripcion;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistaList() {
        return entrevistaList;
    }

    public void setEntrevistaList(List<Entrevista> entrevistaList) {
        this.entrevistaList = entrevistaList;
    }

    public TipoRedApoyo getTraId() {
        return traId;
    }

    public void setTraId(TipoRedApoyo traId) {
        this.traId = traId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (raId != null ? raId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedApoyo)) {
            return false;
        }
        RedApoyo other = (RedApoyo) object;
        if ((this.raId == null && other.raId != null) || (this.raId != null && !this.raId.equals(other.raId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.RedApoyo[ raId=" + raId + " ]";
    }
    
}
