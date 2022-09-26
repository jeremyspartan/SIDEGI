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
    @NamedQuery(name = "Paciente.findByPacidPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Paciente.findByPacDiagnostico", query = "SELECT p FROM Paciente p WHERE p.diagnostico = :diagnostico"),
    @NamedQuery(name = "Paciente.findByPacEstado", query = "SELECT p FROM Paciente p WHERE p.estado = :estado"),
    @NamedQuery(name = "Paciente.findByPacprofesionalResponsable", query = "SELECT p FROM Paciente p WHERE p.profesionalResponsable = :profesionalResponsable"),
    @NamedQuery(name = "Paciente.findByPacfechaReferencia", query = "SELECT p FROM Paciente p WHERE p.fechaReferencia = :fechaReferencia"),
    @NamedQuery(name = "Paciente.findByPacfechaDiagnostico", query = "SELECT p FROM Paciente p WHERE p.fechaDiagnostico = :fechaDiagnostico"),
    @NamedQuery(name = "Paciente.findByPacDoctor", query = "SELECT p FROM Paciente p WHERE p.doctor = :doctor"),
    @NamedQuery(name = "Paciente.findByPacfechaRegistro", query = "SELECT p FROM Paciente p WHERE p.fechaRegistro = :fechaRegistro")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pac_idPaciente")
    private Integer idPaciente;
    @Basic(optional = false)
    @Column(name = "pac_diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "pac_estado")
    private String estado;
    @Column(name = "pac_profesionalResponsable")
    private String profesionalResponsable;
    @Basic(optional = false)
    @Column(name = "pac_fechaReferencia")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaReferencia;
    @Basic(optional = false)
    @Column(name = "pac_fechaDiagnostico")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaDiagnostico;
    @Basic(optional = false)
    @Column(name = "pac_doctor")
    private String doctor;
    @Basic(optional = false)
    @Column(name = "pac_fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaRegistro;
    @ManyToMany(mappedBy = "pacientes")
    private List<Tratamiento> tratamientos;//mapeado por el campo pacientes de Tratamiento
    @OneToMany(mappedBy = "paciente")
    private List<Observacion> observaciones;//mapeado por el campo idPaciente de Observacion
    @OneToMany(mappedBy = "paciente")
    private List<Estadia> estadias;//mapeado por el campo idPaciente de Estadia
    @OneToMany(mappedBy = "paciente")
    private List<Entrevista> entrevistas;//mapeado por el campo idPaciente de Entrevista
    @OneToMany(mappedBy = "idPaciente")
    private List<Anexo> anexos;//mapeado por el campo idPaciente de Anexo
    @JoinColumn(name = "pac_idInstitucion", referencedColumnName = "ins_idInstitucion")
    @ManyToOne
    private Institucion institucion;
    @JoinColumn(name = "pac_cedula", referencedColumnName = "per_cedula")
    @ManyToOne
    private Persona persona;

    public Paciente() {
    }
    
    public Paciente(PacienteDto pacienteDto) {
        actualizarPaciente(pacienteDto);
    }
    
     public void actualizarPaciente(PacienteDto pacienteDto){
        this.idPaciente = pacienteDto.getIdPaciente();
        this.diagnostico = pacienteDto.getDiagnostico();
        this.estado = pacienteDto.getEstado();
        this.profesionalResponsable = pacienteDto.getProfesionalResponsable();
        this.fechaReferencia = pacienteDto.getFechaReferencia();
        this.fechaDiagnostico = pacienteDto.getFechaDiagnostico();
        this.doctor = pacienteDto.getDoctor();
        this.fechaRegistro = pacienteDto.getFechaRegistro();
//        this.insId = new Institucion(pacienteDto.getInsId());
    }
    public Paciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }


    public Paciente(Integer pacidPaciente, String pacDiagnostico, String pacEstado, LocalDate pacfechaReferencia, LocalDate pacfechaDiagnostico, String pacDoctor, LocalDate pacfechaRegistro) {
        this.idPaciente = pacidPaciente;
        this.diagnostico = pacDiagnostico;
        this.estado = pacEstado;
        this.fechaReferencia = pacfechaReferencia;
        this.fechaDiagnostico = pacfechaDiagnostico;
        this.doctor = pacDoctor;
        this.fechaRegistro = pacfechaRegistro;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProfesionalResponsable() {
        return profesionalResponsable;
    }

    public void setProfesionalResponsable(String profesionalResponsable) {
        this.profesionalResponsable = profesionalResponsable;
    }

    public LocalDate getFechaReferencia() {
        return fechaReferencia;
    }

    public void setFechaReferencia(LocalDate fechaReferencia) {
        this.fechaReferencia = fechaReferencia;
    }

    public LocalDate getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(LocalDate fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Paciente[ pacidPaciente=" + idPaciente + " ]";
    }
    
}
