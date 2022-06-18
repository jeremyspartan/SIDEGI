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
@Table(name = "sid_situacioneconomica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionEconomica.findAll", query = "SELECT s FROM SituacionEconomica s"),
    @NamedQuery(name = "SituacionEconomica.findBySeId", query = "SELECT s FROM SituacionEconomica s WHERE s.seId = :seId"),
    @NamedQuery(name = "SituacionEconomica.findBySetipoSituacion", query = "SELECT s FROM SituacionEconomica s WHERE s.setipoSituacion = :setipoSituacion")})
public class SituacionEconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "se_id")
    private BigDecimal seId;
    @Basic(optional = false)
    @Column(name = "se_tipoSituacion")
    private String setipoSituacion;
    @OneToMany(mappedBy = "seId")
    private List<Ingreso> ingresoList;

    public SituacionEconomica() {
    }

    public SituacionEconomica(BigDecimal seId) {
        this.seId = seId;
    }

    public SituacionEconomica(BigDecimal seId, String setipoSituacion) {
        this.seId = seId;
        this.setipoSituacion = setipoSituacion;
    }

    public BigDecimal getSeId() {
        return seId;
    }

    public void setSeId(BigDecimal seId) {
        this.seId = seId;
    }

    public String getSetipoSituacion() {
        return setipoSituacion;
    }

    public void setSetipoSituacion(String setipoSituacion) {
        this.setipoSituacion = setipoSituacion;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seId != null ? seId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionEconomica)) {
            return false;
        }
        SituacionEconomica other = (SituacionEconomica) object;
        if ((this.seId == null && other.seId != null) || (this.seId != null && !this.seId.equals(other.seId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.SituacionEconomica[ seId=" + seId + " ]";
    }
    
}
