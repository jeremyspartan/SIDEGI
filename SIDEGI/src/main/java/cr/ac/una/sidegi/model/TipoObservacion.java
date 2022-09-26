/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "TipoObservacion.findByTobidTipoObservacion", query = "SELECT t FROM TipoObservacion t WHERE t.idTipoObservacion = :idTipoObservacion"),
    @NamedQuery(name = "TipoObservacion.findByTobDescripcion", query = "SELECT t FROM TipoObservacion t WHERE t.descripcion = :descripcion")})
public class TipoObservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tob_idTipoObservacion")
    private Integer idTipoObservacion;
    @Column(name = "tob_descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tipoObservacion")
    private List<Observacion> observaciones; //mapeado por el campo idTipoObservacion de Observacion

    public TipoObservacion() {
    }

    public TipoObservacion(Integer tobidTipoObservacion) {
        this.idTipoObservacion = tobidTipoObservacion;
    }

    public Integer getIdTipoObservacion() {
        return idTipoObservacion;
    }

    public void setIdTipoObservacion(Integer idTipoObservacion) {
        this.idTipoObservacion = idTipoObservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoObservacion != null ? idTipoObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoObservacion)) {
            return false;
        }
        TipoObservacion other = (TipoObservacion) object;
        if ((this.idTipoObservacion == null && other.idTipoObservacion != null) || (this.idTipoObservacion != null && !this.idTipoObservacion.equals(other.idTipoObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoObservacion[ tobidTipoObservacion=" + idTipoObservacion + " ]";
    }
    
}
