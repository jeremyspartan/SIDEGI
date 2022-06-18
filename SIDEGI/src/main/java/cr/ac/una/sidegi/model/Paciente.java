/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByPacidPaciente", query = "SELECT p FROM Paciente p WHERE p.pacidPaciente = :pacidPaciente"),
    @NamedQuery(name = "Paciente.findByPacDiagnostico", query = "SELECT p FROM Paciente p WHERE p.pacDiagnostico = :pacDiagnostico"),
    @NamedQuery(name = "Paciente.findByPacEstado", query = "SELECT p FROM Paciente p WHERE p.pacEstado = :pacEstado"),
    @NamedQuery(name = "Paciente.findByPacprofesionalResponsable", query = "SELECT p FROM Paciente p WHERE p.pacprofesionalResponsable = :pacprofesionalResponsable"),
    @NamedQuery(name = "Paciente.findByPacfechaReferencia", query = "SELECT p FROM Paciente p WHERE p.pacfechaReferencia = :pacfechaReferencia"),
    @NamedQuery(name = "Paciente.findByPacfechaDiagnostico", query = "SELECT p FROM Paciente p WHERE p.pacfechaDiagnostico = :pacfechaDiagnostico"),
    @NamedQuery(name = "Paciente.findByPacDoctor", query = "SELECT p FROM Paciente p WHERE p.pacDoctor = :pacDoctor"),
    @NamedQuery(name = "Paciente.findByPacfechaRegistro", query = "SELECT p FROM Paciente p WHERE p.pacfechaRegistro = :pacfechaRegistro")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "pac_idPaciente")
    private Long pacidPaciente;
    @Basic(optional = false)
    @Column(name = "pac_diagnostico")
    private String pacDiagnostico;
    @Basic(optional = false)
    @Column(name = "pac_estado")
    private String pacEstado;
    @Column(name = "pac_profesionalResponsable")
    private String pacprofesionalResponsable;
    @Basic(optional = false)
    @Column(name = "pac_fechaReferencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacfechaReferencia;
    @Basic(optional = false)
    @Column(name = "pac_fechaDiagnostico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacfechaDiagnostico;
    @Basic(optional = false)
    @Column(name = "pac_doctor")
    private String pacDoctor;
    @Basic(optional = false)
    @Column(name = "pac_fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacfechaRegistro;
    @JoinTable(name = "sid_pacientetratamientos", joinColumns = {
        @JoinColumn(name = "pac_idPaciente", referencedColumnName = "pac_idPaciente")}, inverseJoinColumns = {
        @JoinColumn(name = "tra_id", referencedColumnName = "tra_id")})
    @ManyToMany
    private List<Tratamiento> tratamientos;
    @OneToMany(mappedBy = "pacidPaciente")
    private List<Observacion> observacionList;
    @OneToMany(mappedBy = "pacidPaciente")
    private List<Estadia> estadias;
    @OneToMany(mappedBy = "pacidPaciente")
    private List<Entrevista> entrevistas;
    @OneToMany(mappedBy = "pacidPaciente")
    private List<Anexo> anexos;
    @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")
    @ManyToOne
    private Institucion insId;
    @JoinColumn(name = "per_cedula", referencedColumnName = "per_cedula")
    @ManyToOne
    private Persona perCedula;

    public Paciente() {
    }

    public Paciente(Long pacidPaciente) {
        this.pacidPaciente = pacidPaciente;
    }

    public Paciente(Long pacidPaciente, String pacDiagnostico, String pacEstado, Date pacfechaReferencia, Date pacfechaDiagnostico, String pacDoctor, Date pacfechaRegistro) {
        this.pacidPaciente = pacidPaciente;
        this.pacDiagnostico = pacDiagnostico;
        this.pacEstado = pacEstado;
        this.pacfechaReferencia = pacfechaReferencia;
        this.pacfechaDiagnostico = pacfechaDiagnostico;
        this.pacDoctor = pacDoctor;
        this.pacfechaRegistro = pacfechaRegistro;
    }

    public Long getPacidPaciente() {
        return pacidPaciente;
    }

    public void setPacidPaciente(Long pacidPaciente) {
        this.pacidPaciente = pacidPaciente;
    }

    public String getPacDiagnostico() {
        return pacDiagnostico;
    }

    public void setPacDiagnostico(String pacDiagnostico) {
        this.pacDiagnostico = pacDiagnostico;
    }

    public String getPacEstado() {
        return pacEstado;
    }

    public void setPacEstado(String pacEstado) {
        this.pacEstado = pacEstado;
    }

    public String getPacprofesionalResponsable() {
        return pacprofesionalResponsable;
    }

    public void setPacprofesionalResponsable(String pacprofesionalResponsable) {
        this.pacprofesionalResponsable = pacprofesionalResponsable;
    }

    public Date getPacfechaReferencia() {
        return pacfechaReferencia;
    }

    public void setPacfechaReferencia(Date pacfechaReferencia) {
        this.pacfechaReferencia = pacfechaReferencia;
    }

    public Date getPacfechaDiagnostico() {
        return pacfechaDiagnostico;
    }

    public void setPacfechaDiagnostico(Date pacfechaDiagnostico) {
        this.pacfechaDiagnostico = pacfechaDiagnostico;
    }

    public String getPacDoctor() {
        return pacDoctor;
    }

    public void setPacDoctor(String pacDoctor) {
        this.pacDoctor = pacDoctor;
    }

    public Date getPacfechaRegistro() {
        return pacfechaRegistro;
    }

    public void setPacfechaRegistro(Date pacfechaRegistro) {
        this.pacfechaRegistro = pacfechaRegistro;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    @XmlTransient
    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }

    @XmlTransient
    public List<Estadia> getEstadias() {
        return estadias;
    }

    public void setEstadias(List<Estadia> estadias) {
        this.estadias = estadias;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(List<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    @XmlTransient
    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    public Institucion getInsId() {
        return insId;
    }

    public void setInsId(Institucion insId) {
        this.insId = insId;
    }

    public Persona getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(Persona perCedula) {
        this.perCedula = perCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacidPaciente != null ? pacidPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacidPaciente == null && other.pacidPaciente != null) || (this.pacidPaciente != null && !this.pacidPaciente.equals(other.pacidPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Paciente[ pacidPaciente=" + pacidPaciente + " ]";
    }
    
}
