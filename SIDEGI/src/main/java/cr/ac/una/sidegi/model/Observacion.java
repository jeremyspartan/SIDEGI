/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Observacion.findByObsidObservacion", query = "SELECT o FROM Observacion o WHERE o.idObservacion = :idObservacion"),
    @NamedQuery(name = "Observacion.findByObsdescObservacion", query = "SELECT o FROM Observacion o WHERE o.descObservacion = :descObservacion")})
public class Observacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "obs_idObservacion")
    private Integer idObservacion;
    @Basic(optional = false)
    @Column(name = "obs_descObservacion")
    private String descObservacion;
    @JoinColumn(name = "obs_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente paciente;
    @JoinColumn(name = "obs_idTipoObservacion", referencedColumnName = "tob_idTipoObservacion")
    @ManyToOne
    private TipoObservacion tipoObservacion;

    public Observacion() {
    }

    public Observacion(Integer obsidObservacion) {
        this.idObservacion = obsidObservacion;
    }

    public Observacion(Integer obsidObservacion, String obsdescObservacion) {
        this.idObservacion = obsidObservacion;
        this.descObservacion = obsdescObservacion;
    }

    public Integer getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getDescObservacion() {
        return descObservacion;
    }

    public void setDescObservacion(String descObservacion) {
        this.descObservacion = descObservacion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoObservacion getTipoObservacion() {
        return tipoObservacion;
    }

    public void setTipoObservacion(TipoObservacion tipoObservacion) {
        this.tipoObservacion = tipoObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObservacion != null ? idObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacion)) {
            return false;
        }
        Observacion other = (Observacion) object;
        if ((this.idObservacion == null && other.idObservacion != null) || (this.idObservacion != null && !this.idObservacion.equals(other.idObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Observacion[ obsidObservacion=" + idObservacion + " ]";
    }
    
}
