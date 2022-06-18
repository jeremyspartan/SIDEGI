/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "sid_entrevistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrevista.findAll", query = "SELECT e FROM Entrevista e"),
    @NamedQuery(name = "Entrevista.findByEntId", query = "SELECT e FROM Entrevista e WHERE e.entId = :entId"),
    @NamedQuery(name = "Entrevista.findByEntFecha", query = "SELECT e FROM Entrevista e WHERE e.entFecha = :entFecha"),
    @NamedQuery(name = "Entrevista.findByEntdispEntrevistado", query = "SELECT e FROM Entrevista e WHERE e.entdispEntrevistado = :entdispEntrevistado"),
    @NamedQuery(name = "Entrevista.findByEntLugar", query = "SELECT e FROM Entrevista e WHERE e.entLugar = :entLugar"),
    @NamedQuery(name = "Entrevista.findByEntnombreAplicanrte", query = "SELECT e FROM Entrevista e WHERE e.entnombreAplicanrte = :entnombreAplicanrte")})
public class Entrevista implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ent_id")
    private BigDecimal entId;
    @Basic(optional = false)
    @Column(name = "ent_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entFecha;
    @Basic(optional = false)
    @Column(name = "ent_dispEntrevistado")
    private String entdispEntrevistado;
    @Basic(optional = false)
    @Column(name = "ent_lugar")
    private String entLugar;
    @Basic(optional = false)
    @Column(name = "ent_nombreAplicanrte")
    private String entnombreAplicanrte;
    @JoinColumn(name = "ing_id", referencedColumnName = "ing_id")
    @ManyToOne
    private Ingreso ingId;
    @JoinColumn(name = "me_id", referencedColumnName = "me_id")
    @ManyToOne
    private ModalidadEntrevista meId;
    @JoinColumn(name = "pac_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente pacidPaciente;
    @JoinColumn(name = "ra_id", referencedColumnName = "ra_id")
    @ManyToOne
    private RedApoyo raId;
    @JoinColumn(name = "viv_id", referencedColumnName = "viv_id")
    @ManyToOne
    private Vivienda vivId;

    public Entrevista() {
    }

    public Entrevista(BigDecimal entId) {
        this.entId = entId;
    }

    public Entrevista(BigDecimal entId, Date entFecha, String entdispEntrevistado, String entLugar, String entnombreAplicanrte) {
        this.entId = entId;
        this.entFecha = entFecha;
        this.entdispEntrevistado = entdispEntrevistado;
        this.entLugar = entLugar;
        this.entnombreAplicanrte = entnombreAplicanrte;
    }

    public BigDecimal getEntId() {
        return entId;
    }

    public void setEntId(BigDecimal entId) {
        this.entId = entId;
    }

    public Date getEntFecha() {
        return entFecha;
    }

    public void setEntFecha(Date entFecha) {
        this.entFecha = entFecha;
    }

    public String getEntdispEntrevistado() {
        return entdispEntrevistado;
    }

    public void setEntdispEntrevistado(String entdispEntrevistado) {
        this.entdispEntrevistado = entdispEntrevistado;
    }

    public String getEntLugar() {
        return entLugar;
    }

    public void setEntLugar(String entLugar) {
        this.entLugar = entLugar;
    }

    public String getEntnombreAplicanrte() {
        return entnombreAplicanrte;
    }

    public void setEntnombreAplicanrte(String entnombreAplicanrte) {
        this.entnombreAplicanrte = entnombreAplicanrte;
    }

    public Ingreso getIngId() {
        return ingId;
    }

    public void setIngId(Ingreso ingId) {
        this.ingId = ingId;
    }

    public ModalidadEntrevista getMeId() {
        return meId;
    }

    public void setMeId(ModalidadEntrevista meId) {
        this.meId = meId;
    }

    public Paciente getPacidPaciente() {
        return pacidPaciente;
    }

    public void setPacidPaciente(Paciente pacidPaciente) {
        this.pacidPaciente = pacidPaciente;
    }

    public RedApoyo getRaId() {
        return raId;
    }

    public void setRaId(RedApoyo raId) {
        this.raId = raId;
    }

    public Vivienda getVivId() {
        return vivId;
    }

    public void setVivId(Vivienda vivId) {
        this.vivId = vivId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrevista)) {
            return false;
        }
        Entrevista other = (Entrevista) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Entrevista[ entId=" + entId + " ]";
    }
    
}
