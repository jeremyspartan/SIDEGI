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
@Table(name = "sid_tipoobservaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoObservacion.findAll", query = "SELECT t FROM TipoObservacion t"),
    @NamedQuery(name = "TipoObservacion.findByTobidTipoObservacion", query = "SELECT t FROM TipoObservacion t WHERE t.tobidTipoObservacion = :tobidTipoObservacion"),
    @NamedQuery(name = "TipoObservacion.findByTobDescripcion", query = "SELECT t FROM TipoObservacion t WHERE t.tobDescripcion = :tobDescripcion")})
public class TipoObservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tob_idTipoObservacion")
    private Long tobidTipoObservacion;
    @Column(name = "tob_descripcion")
    private String tobDescripcion;
    @OneToMany(mappedBy = "tobidTipoObservacion")
    private List<Observacion> observacionList;

    public TipoObservacion() {
    }

    public TipoObservacion(Long tobidTipoObservacion) {
        this.tobidTipoObservacion = tobidTipoObservacion;
    }

    public Long getTobidTipoObservacion() {
        return tobidTipoObservacion;
    }

    public void setTobidTipoObservacion(Long tobidTipoObservacion) {
        this.tobidTipoObservacion = tobidTipoObservacion;
    }

    public String getTobDescripcion() {
        return tobDescripcion;
    }

    public void setTobDescripcion(String tobDescripcion) {
        this.tobDescripcion = tobDescripcion;
    }

    @XmlTransient
    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tobidTipoObservacion != null ? tobidTipoObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoObservacion)) {
            return false;
        }
        TipoObservacion other = (TipoObservacion) object;
        if ((this.tobidTipoObservacion == null && other.tobidTipoObservacion != null) || (this.tobidTipoObservacion != null && !this.tobidTipoObservacion.equals(other.tobidTipoObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoObservacion[ tobidTipoObservacion=" + tobidTipoObservacion + " ]";
    }
    
}
