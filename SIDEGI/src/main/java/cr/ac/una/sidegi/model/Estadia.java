/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_estadias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadia.findAll", query = "SELECT e FROM Estadia e"),
    @NamedQuery(name = "Estadia.findByEstidEstadia", query = "SELECT e FROM Estadia e WHERE e.idEstadia = :idEstadia"),
    @NamedQuery(name = "Estadia.findByEstfechaIngreso", query = "SELECT e FROM Estadia e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Estadia.findByEstfechaSalida", query = "SELECT e FROM Estadia e WHERE e.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Estadia.findByEstcantidadComidas", query = "SELECT e FROM Estadia e WHERE e.cantidadComidas = :cantidadComidas")})
public class Estadia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_idEstadia")
    private Integer idEstadia;
    @Basic(optional = false)
    @Column(name = "est_fechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "est_fechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "est_cantidadComidas")
    private BigInteger cantidadComidas;
    @JoinColumn(name = "est_idCasa", referencedColumnName = "cas_idCasa")
    @ManyToOne
    private Casa casa;
    @JoinColumn(name = "est_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente paciente;

    public Estadia() {
    }

    public Estadia(Integer estidEstadia) {
        this.idEstadia = estidEstadia;
    }

    public Estadia(Integer estidEstadia, Date estfechaIngreso, BigInteger estcantidadComidas) {
        this.idEstadia = estidEstadia;
        this.fechaIngreso = estfechaIngreso;
        this.cantidadComidas = estcantidadComidas;
    }

    public Integer getIdEstadia() {
        return idEstadia;
    }

    public void setIdEstadia(Integer idEstadia) {
        this.idEstadia = idEstadia;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigInteger getCantidadComidas() {
        return cantidadComidas;
    }

    public void setCantidadComidas(BigInteger cantidadComidas) {
        this.cantidadComidas = cantidadComidas;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadia != null ? idEstadia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadia)) {
            return false;
        }
        Estadia other = (Estadia) object;
        if ((this.idEstadia == null && other.idEstadia != null) || (this.idEstadia != null && !this.idEstadia.equals(other.idEstadia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Estadia[ estidEstadia=" + idEstadia + " ]";
    }
    
}
