/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Estadia.findByEstidEstadia", query = "SELECT e FROM Estadia e WHERE e.estidEstadia = :estidEstadia"),
    @NamedQuery(name = "Estadia.findByEstfechaIngreso", query = "SELECT e FROM Estadia e WHERE e.estfechaIngreso = :estfechaIngreso"),
    @NamedQuery(name = "Estadia.findByEstfechaSalida", query = "SELECT e FROM Estadia e WHERE e.estfechaSalida = :estfechaSalida"),
    @NamedQuery(name = "Estadia.findByEstcantidadComidas", query = "SELECT e FROM Estadia e WHERE e.estcantidadComidas = :estcantidadComidas")})
public class Estadia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "est_idEstadia")
    private Long estidEstadia;
    @Basic(optional = false)
    @Column(name = "est_fechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estfechaIngreso;
    @Column(name = "est_fechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estfechaSalida;
    @Basic(optional = false)
    @Column(name = "est_cantidadComidas")
    private BigInteger estcantidadComidas;
    @JoinColumn(name = "cas_id", referencedColumnName = "cas_id")
    @ManyToOne
    private Casa casId;
    @JoinColumn(name = "pac_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente pacidPaciente;

    public Estadia() {
    }

    public Estadia(Long estidEstadia) {
        this.estidEstadia = estidEstadia;
    }

    public Estadia(Long estidEstadia, Date estfechaIngreso, BigInteger estcantidadComidas) {
        this.estidEstadia = estidEstadia;
        this.estfechaIngreso = estfechaIngreso;
        this.estcantidadComidas = estcantidadComidas;
    }

    public Long getEstidEstadia() {
        return estidEstadia;
    }

    public void setEstidEstadia(Long estidEstadia) {
        this.estidEstadia = estidEstadia;
    }

    public Date getEstfechaIngreso() {
        return estfechaIngreso;
    }

    public void setEstfechaIngreso(Date estfechaIngreso) {
        this.estfechaIngreso = estfechaIngreso;
    }

    public Date getEstfechaSalida() {
        return estfechaSalida;
    }

    public void setEstfechaSalida(Date estfechaSalida) {
        this.estfechaSalida = estfechaSalida;
    }

    public BigInteger getEstcantidadComidas() {
        return estcantidadComidas;
    }

    public void setEstcantidadComidas(BigInteger estcantidadComidas) {
        this.estcantidadComidas = estcantidadComidas;
    }

    public Casa getCasId() {
        return casId;
    }

    public void setCasId(Casa casId) {
        this.casId = casId;
    }

    public Paciente getPacidPaciente() {
        return pacidPaciente;
    }

    public void setPacidPaciente(Paciente pacidPaciente) {
        this.pacidPaciente = pacidPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estidEstadia != null ? estidEstadia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadia)) {
            return false;
        }
        Estadia other = (Estadia) object;
        if ((this.estidEstadia == null && other.estidEstadia != null) || (this.estidEstadia != null && !this.estidEstadia.equals(other.estidEstadia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Estadia[ estidEstadia=" + estidEstadia + " ]";
    }
    
}
