/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Paciente;
import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author computer
 */
public class PacienteDto {
    public SimpleStringProperty idPaciente;
    public SimpleStringProperty diagnostico;
    public SimpleStringProperty estado;
    public SimpleStringProperty profesionalResponsable;
    public ObjectProperty<LocalDate> fechaReferencia;
    public ObjectProperty<LocalDate> fechaDiagnostico;
    public SimpleStringProperty doctor;
    public ObjectProperty<LocalDate> fechaRegistro;
    /*public List<Tratamiento> tratamientos;
    public List<Observacion> observacionList;
    public List<Estadia> estadias;
    public List<Entrevista> entrevistas;
    public List<Anexo> anexos;*/
    public InstitucionDto idInstitucion;
    public SimpleStringProperty cedula;
    
    public PacienteDto(){
        this.idPaciente = new SimpleStringProperty();
        this.diagnostico = new SimpleStringProperty();
        this.estado = new SimpleStringProperty();
        this.profesionalResponsable = new SimpleStringProperty();
        this.fechaReferencia = new SimpleObjectProperty();
        this.fechaDiagnostico = new SimpleObjectProperty();
        this.doctor = new SimpleStringProperty();
        this.fechaRegistro = new SimpleObjectProperty();
        this.cedula = new SimpleStringProperty();
    }
    
    public PacienteDto(Paciente paciente)
    {
        this();
        this.idPaciente.set(Long.toString(paciente.getIdPaciente()));
        this.diagnostico.set(paciente.getDiagnostico());
        this.estado.set(paciente.getEstado());
        this.profesionalResponsable.set(paciente.getProfesionalResponsable());
        this.fechaReferencia.set(paciente.getFechaReferencia());
        this.fechaDiagnostico.set(paciente.getFechaDiagnostico());
        this.doctor.set(paciente.getDoctor());
        this.fechaRegistro.set(paciente.getFechaRegistro());
        this.idInstitucion = new InstitucionDto(paciente.getInstitucion());
        this.cedula.set(paciente.getPersona().getCedula());
    }

    public Integer getIdPaciente() {
          if(idPaciente.get()!=null && !idPaciente.get().isEmpty())
            return Integer.valueOf(idPaciente.get());
        else
            return null;
    }

    public void setIdPaciente(Integer IdPaciente) {
        this.idPaciente.set(IdPaciente.toString());
    }

    public String getDiagnostico() {
        return diagnostico.get();
    }

    public void setDiagnostico(String pacDiagnostico) {
        this.diagnostico.set(pacDiagnostico);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String Estado) {
        this.estado.set(Estado);
    }

    public String getProfesionalResponsable() {
        return profesionalResponsable.get();
    }

    public String getCedula() {
        return cedula.get();
    }

    public void setCedula(String perCedula) {
       this.cedula.set(perCedula);
    }
    
    

    public void setProfesionalResponsable(String pacProfesionalResponsable) {
        this.profesionalResponsable.set(pacProfesionalResponsable);
    }

    public LocalDate getFechaReferencia() {
        return fechaReferencia.get();
    }

    public void setFechaReferencia(LocalDate fechaReferencia) {
        this.fechaReferencia.set(fechaReferencia);
    }

    public LocalDate getFechaDiagnostico() {
         return fechaDiagnostico.get();
    }

    public void setfechaDiagnostico(LocalDate fechaDiagnostico) {
        this.fechaDiagnostico.set(fechaDiagnostico);
    }

    public String getDoctor() {
        return doctor.get();
    }

    public void setDoctor(String doctor) {
        this.doctor.set(doctor);
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro.get();
    }

    public void setPacFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro.set(fechaRegistro);
    }

    public InstitucionDto getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(InstitucionDto idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
    
    
}
