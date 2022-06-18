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
@Table(name = "sid_tiporedapoyos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRedApoyo.findAll", query = "SELECT t FROM TipoRedApoyo t"),
    @NamedQuery(name = "TipoRedApoyo.findByTraId", query = "SELECT t FROM TipoRedApoyo t WHERE t.traId = :traId"),
    @NamedQuery(name = "TipoRedApoyo.findByTraTipo", query = "SELECT t FROM TipoRedApoyo t WHERE t.traTipo = :traTipo")})
public class TipoRedApoyo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tra_id")
    private BigDecimal traId;
    @Basic(optional = false)
    @Column(name = "tra_tipo")
    private String traTipo;
    @OneToMany(mappedBy = "traId")
    private List<RedApoyo> redApoyoList;

    public TipoRedApoyo() {
    }

    public TipoRedApoyo(BigDecimal traId) {
        this.traId = traId;
    }

    public TipoRedApoyo(BigDecimal traId, String traTipo) {
        this.traId = traId;
        this.traTipo = traTipo;
    }

    public BigDecimal getTraId() {
        return traId;
    }

    public void setTraId(BigDecimal traId) {
        this.traId = traId;
    }

    public String getTraTipo() {
        return traTipo;
    }

    public void setTraTipo(String traTipo) {
        this.traTipo = traTipo;
    }

    @XmlTransient
    public List<RedApoyo> getRedApoyoList() {
        return redApoyoList;
    }

    public void setRedApoyoList(List<RedApoyo> redApoyoList) {
        this.redApoyoList = redApoyoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traId != null ? traId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRedApoyo)) {
            return false;
        }
        TipoRedApoyo other = (TipoRedApoyo) object;
        if ((this.traId == null && other.traId != null) || (this.traId != null && !this.traId.equals(other.traId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoRedApoyo[ traId=" + traId + " ]";
    }
    
}
