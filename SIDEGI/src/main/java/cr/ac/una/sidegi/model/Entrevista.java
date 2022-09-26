/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
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
@Table(name = "sid_entrevistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrevista.findAll", query = "SELECT e FROM Entrevista e"),
    @NamedQuery(name = "Entrevista.findByEntidEntrevista", query = "SELECT e FROM Entrevista e WHERE e.idEntrevista = :idEntrevista"),
    @NamedQuery(name = "Entrevista.findByEntFecha", query = "SELECT e FROM Entrevista e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Entrevista.findByEntdispEntrevistado", query = "SELECT e FROM Entrevista e WHERE e.dispEntrevistado = :dispEntrevistado"),
    @NamedQuery(name = "Entrevista.findByEntLugar", query = "SELECT e FROM Entrevista e WHERE e.lugar = :lugar"),
    @NamedQuery(name = "Entrevista.findByEntnombreAplicanrte", query = "SELECT e FROM Entrevista e WHERE e.nombreAplicante = :nombreAplicante")})
public class Entrevista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ent_idEntrevista")
    private Integer idEntrevista;
    @Basic(optional = false)
    @Column(name = "ent_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "ent_dispEntrevistado")
    private String dispEntrevistado;
    @Basic(optional = false)
    @Column(name = "ent_lugar")
    private String lugar;
    @Basic(optional = false)
    @Column(name = "ent_nombreAplicante")
    private String nombreAplicante;
    @JoinColumn(name = "ent_idIngresoEconomico", referencedColumnName = "ing_idIngresoEconomico")
    @ManyToOne
    private IngresoEconomico ingresoEconomico;
    @JoinColumn(name = "ent_idModalidadEntrevista", referencedColumnName = "me_idModalidadEntrevista")
    @ManyToOne
    private ModalidadEntrevista modalidadEntrevista;
    @JoinColumn(name = "ent_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente paciente;
    @JoinColumn(name = "ent_idRedApoyoc", referencedColumnName = "ra_idRedApoyo")
    @ManyToOne
    private RedApoyo redApoyo;
    @JoinColumn(name = "ent_idVivienda", referencedColumnName = "viv_idVivienda")
    @ManyToOne
    private Vivienda vivienda;

    public Entrevista() {
    }

    public Entrevista(Integer entidEntrevista) {
        this.idEntrevista = entidEntrevista;
    }

    public Entrevista(Integer entidEntrevista, Date entFecha, String entdispEntrevistado, String entLugar, String entnombreAplicanrte) {
        this.idEntrevista = entidEntrevista;
        this.fecha = entFecha;
        this.dispEntrevistado = entdispEntrevistado;
        this.lugar = entLugar;
        this.nombreAplicante = entnombreAplicanrte;
    }

    public Integer getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(Integer idEntrevista) {
        this.idEntrevista = idEntrevista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDispEntrevistado() {
        return dispEntrevistado;
    }

    public void setDispEntrevistado(String dispEntrevistado) {
        this.dispEntrevistado = dispEntrevistado;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreAplicante() {
        return nombreAplicante;
    }

    public void setNombreAplicante(String nombreAplicante) {
        this.nombreAplicante = nombreAplicante;
    }

    public IngresoEconomico getIngresoEconomico() {
        return ingresoEconomico;
    }

    public void setIngresoEconomico(IngresoEconomico ingresoEconomico) {
        this.ingresoEconomico = ingresoEconomico;
    }

    public ModalidadEntrevista getModalidadEntrevista() {
        return modalidadEntrevista;
    }

    public void setModalidadEntrevista(ModalidadEntrevista modalidadEntrevista) {
        this.modalidadEntrevista = modalidadEntrevista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public RedApoyo getRedApoyo() {
        return redApoyo;
    }

    public void setRedApoyo(RedApoyo redApoyo) {
        this.redApoyo = redApoyo;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrevista != null ? idEntrevista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrevista)) {
            return false;
        }
        Entrevista other = (Entrevista) object;
        if ((this.idEntrevista == null && other.idEntrevista != null) || (this.idEntrevista != null && !this.idEntrevista.equals(other.idEntrevista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Entrevista[ entidEntrevista=" + idEntrevista + " ]";
    }
    
}
