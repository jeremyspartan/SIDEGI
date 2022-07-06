/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.PacienteDto;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.transaction.Transactional;
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
    @NamedQuery(name = "Paciente.findByPacidPaciente", query = "SELECT p FROM Paciente p WHERE p.pacIdPaciente = :pacIdPaciente"),
    @NamedQuery(name = "Paciente.findByPacDiagnostico", query = "SELECT p FROM Paciente p WHERE p.pacDiagnostico = :pacDiagnostico"),
    @NamedQuery(name = "Paciente.findByPacEstado", query = "SELECT p FROM Paciente p WHERE p.pacEstado = :pacEstado"),
    @NamedQuery(name = "Paciente.findByPacprofesionalResponsable", query = "SELECT p FROM Paciente p WHERE p.pacProfesionalResponsable = :pacProfesionalResponsable"),
    @NamedQuery(name = "Paciente.findByPacfechaReferencia", query = "SELECT p FROM Paciente p WHERE p.pacFechaReferencia = :pacFechaReferencia"),
    @NamedQuery(name = "Paciente.findByPacfechaDiagnostico", query = "SELECT p FROM Paciente p WHERE p.pacfechaDiagnostico = :pacfechaDiagnostico"),
    @NamedQuery(name = "Paciente.findByPacDoctor", query = "SELECT p FROM Paciente p WHERE p.pacDoctor = :pacDoctor"),
    @NamedQuery(name = "Paciente.findByPacfechaRegistro", query = "SELECT p FROM Paciente p WHERE p.pacFechaRegistro = :pacFechaRegistro")})
@Transactional
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pac_idPaciente")
    private Long pacIdPaciente;
    @Basic(optional = false)
    @Column(name = "pac_diagnostico")
    private String pacDiagnostico;
    @Basic(optional = false)
    @Column(name = "pac_estado")
    private String pacEstado;
    @Column(name = "pac_profesionalResponsable")
    private String pacProfesionalResponsable;
    @Basic(optional = false)
    @Column(name = "pac_fechaReferencia")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate pacFechaReferencia;
    @Basic(optional = false)
    @Column(name = "pac_fechaDiagnostico")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate pacfechaDiagnostico;
    @Basic(optional = false)
    @Column(name = "pac_doctor")
    private String pacDoctor;
    @Basic(optional = false)
    @Column(name = "pac_fechaRegistro")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate pacFechaRegistro;
    @JoinTable(name = "sid_pacientetratamientos", joinColumns = {
        @JoinColumn(name = "pac_idPaciente", referencedColumnName = "pac_idPaciente")}, inverseJoinColumns = {
        @JoinColumn(name = "tra_id", referencedColumnName = "tra_id")})
    @ManyToMany
    private List<Tratamiento> tratamientos;
    @OneToMany(mappedBy = "pacidPaciente")
    private List<Observacion> observaciones;
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
    
    public Paciente(PacienteDto pacienteDto) {
        actualizarPaciente(pacienteDto);
    }

    public void actualizarPaciente(PacienteDto pacienteDto){
        this.pacIdPaciente = pacienteDto.getPacIdPaciente();
        this.pacDiagnostico = pacienteDto.getPacDiagnostico();
        this.pacEstado = pacienteDto.getPacEstado();
        this.pacProfesionalResponsable = pacienteDto.getPacProfesionalResponsable();
        this.pacFechaReferencia = pacienteDto.getPacFechaReferencia();
        this.pacfechaDiagnostico = pacienteDto.getPacfechaDiagnostico();
        this.pacDoctor = pacienteDto.getPacDoctor();
        this.pacFechaRegistro = pacienteDto.getPacFechaRegistro();
//        this.insId = new Institucion(pacienteDto.getInsId());
    }
    public Paciente(Long pacidPaciente) {
        this.pacIdPaciente = pacidPaciente;
    }

    public Paciente(Long pacidPaciente, String pacDiagnostico, String pacEstado, LocalDate pacfechaReferencia, LocalDate pacfechaDiagnostico, String pacDoctor, LocalDate pacfechaRegistro) {
        this.pacIdPaciente = pacidPaciente;
        this.pacDiagnostico = pacDiagnostico;
        this.pacEstado = pacEstado;
        this.pacFechaReferencia = pacfechaReferencia;
        this.pacfechaDiagnostico = pacfechaDiagnostico;
        this.pacDoctor = pacDoctor;
        this.pacFechaRegistro = pacfechaRegistro;
    }

    public Long getPacIdPaciente() {
        return pacIdPaciente;
    }

    public void setPacIdPaciente(Long pacidPaciente) {
        this.pacIdPaciente = pacidPaciente;
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

    public String getPacProfesionalResponsable() {
        return pacProfesionalResponsable;
    }

    public void setPacProfesionalResponsable(String pacProfesionalResponsable) {
        this.pacProfesionalResponsable = pacProfesionalResponsable;
    }

    public LocalDate getPacFechaReferencia() {
        return pacFechaReferencia;
    }

    public void setPacFechaReferencia(LocalDate pacFechaReferencia) {
        this.pacFechaReferencia = pacFechaReferencia;
    }

    public LocalDate getPacfechaDiagnostico() {
        return pacfechaDiagnostico;
    }

    public void setPacfechaDiagnostico(LocalDate pacfechaDiagnostico) {
        this.pacfechaDiagnostico = pacfechaDiagnostico;
    }

    public String getPacDoctor() {
        return pacDoctor;
    }

    public void setPacDoctor(String pacDoctor) {
        this.pacDoctor = pacDoctor;
    }

    public LocalDate getPacFechaRegistro() {
        return pacFechaRegistro;
    }

    public void setPacFechaRegistro(LocalDate pacFechaRegistro) {
        this.pacFechaRegistro = pacFechaRegistro;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    @XmlTransient
    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
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
        hash += (pacIdPaciente != null ? pacIdPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacIdPaciente == null && other.pacIdPaciente != null) || (this.pacIdPaciente != null && !this.pacIdPaciente.equals(other.pacIdPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Paciente[ pacidPaciente=" + pacIdPaciente + " ]";
    }
    
}
