/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sid_observaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observacion.findAll", query = "SELECT o FROM Observacion o"),
    @NamedQuery(name = "Observacion.findByObsidObservacion", query = "SELECT o FROM Observacion o WHERE o.obsIdObservacion = :obsidObservacion"),
    @NamedQuery(name = "Observacion.findByObsdescObservacion", query = "SELECT o FROM Observacion o WHERE o.obsdescObservacion = :obsdescObservacion")})
public class Observacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "obs_idObservacion")
    private Long obsIdObservacion;
    @Basic(optional = false)
    @Column(name = "obs_descObservacion")
    private String obsdescObservacion;
    @JoinColumn(name = "pac_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente pacidPaciente;
    @JoinColumn(name = "tob_idTipoObservacion", referencedColumnName = "tob_idTipoObservacion")
    @ManyToOne
    private TipoObservacion tobidTipoObservacion;

    public Observacion() {
    }

    public Observacion(Long obsidObservacion) {
        this.obsIdObservacion = obsidObservacion;
    }

    public Observacion(Long obsidObservacion, String obsdescObservacion) {
        this.obsIdObservacion = obsidObservacion;
        this.obsdescObservacion = obsdescObservacion;
    }

    public Long getObsidObservacion() {
        return obsIdObservacion;
    }

    public void setObsidObservacion(Long obsidObservacion) {
        this.obsIdObservacion = obsidObservacion;
    }

    public String getObsdescObservacion() {
        return obsdescObservacion;
    }

    public void setObsdescObservacion(String obsdescObservacion) {
        this.obsdescObservacion = obsdescObservacion;
    }

    public Paciente getPacidPaciente() {
        return pacidPaciente;
    }

    public void setPacidPaciente(Paciente pacidPaciente) {
        this.pacidPaciente = pacidPaciente;
    }

    public TipoObservacion getTobidTipoObservacion() {
        return tobidTipoObservacion;
    }

    public void setTobidTipoObservacion(TipoObservacion tobidTipoObservacion) {
        this.tobidTipoObservacion = tobidTipoObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obsIdObservacion != null ? obsIdObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacion)) {
            return false;
        }
        Observacion other = (Observacion) object;
        if ((this.obsIdObservacion == null && other.obsIdObservacion != null) || (this.obsIdObservacion != null && !this.obsIdObservacion.equals(other.obsIdObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Observacion[ obsidObservacion=" + obsIdObservacion + " ]";
    }
    
}
