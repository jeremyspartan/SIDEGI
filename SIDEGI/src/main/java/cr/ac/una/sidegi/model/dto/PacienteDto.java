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
    public SimpleStringProperty pacIdPaciente;
    public SimpleStringProperty pacDiagnostico;
    public SimpleStringProperty pacEstado;
    public SimpleStringProperty pacProfesionalResponsable;
    public ObjectProperty<LocalDate> pacFechaReferencia;
    public ObjectProperty<LocalDate> pacfechaDiagnostico;
    public SimpleStringProperty pacDoctor;
    public ObjectProperty<LocalDate> pacFechaRegistro;
    /*public List<Tratamiento> tratamientos;
    public List<Observacion> observacionList;
    public List<Estadia> estadias;
    public List<Entrevista> entrevistas;
    public List<Anexo> anexos;*/
    public InstitucionDto insId;
    public SimpleStringProperty perCedula;
    
    public PacienteDto(){
        this.pacIdPaciente = new SimpleStringProperty();
        this.pacDiagnostico = new SimpleStringProperty();
        this.pacEstado = new SimpleStringProperty();
        this.pacProfesionalResponsable = new SimpleStringProperty();
        this.pacFechaReferencia = new SimpleObjectProperty();
        this.pacfechaDiagnostico = new SimpleObjectProperty();
        this.pacDoctor = new SimpleStringProperty();
        this.pacFechaRegistro = new SimpleObjectProperty();
        this.perCedula = new SimpleStringProperty();
    }
    
    public PacienteDto(Paciente paciente)
    {
        this();
        this.pacIdPaciente.set(Long.toString(paciente.getPacIdPaciente()));
        this.pacDiagnostico.set(paciente.getPacDiagnostico());
        this.pacEstado.set(paciente.getPacEstado());
        this.pacProfesionalResponsable.set(paciente.getPacProfesionalResponsable());
        this.pacFechaReferencia.set(paciente.getPacFechaReferencia());
        this.pacfechaDiagnostico.set(paciente.getPacfechaDiagnostico());
        this.pacDoctor.set(paciente.getPacDoctor());
        this.pacFechaRegistro.set(paciente.getPacFechaRegistro());
        this.insId = new InstitucionDto(paciente.getInsId());
        this.perCedula.set(paciente.getPerCedula().getPerCedula());
    }

    public Long getPacIdPaciente() {
          if(pacIdPaciente.get()!=null && !pacIdPaciente.get().isEmpty())
            return Long.valueOf(pacIdPaciente.get());
        else
            return null;
    }

    public void setPacIdPaciente(Long pacIdPaciente) {
        this.pacIdPaciente.set(pacIdPaciente.toString());
    }

    public String getPacDiagnostico() {
        return pacDiagnostico.get();
    }

    public void setPacDiagnostico(String pacDiagnostico) {
        this.pacDiagnostico.set(pacDiagnostico);
    }

    public String getPacEstado() {
        return pacEstado.get();
    }

    public void setPacEstado(String pacEstado) {
        this.pacEstado.set(pacEstado);
    }

    public String getPacProfesionalResponsable() {
        return pacProfesionalResponsable.get();
    }

    public String getPerCedula() {
        return perCedula.get();
    }

    public void setPerCedula(String perCedula) {
       this.perCedula.set(perCedula);
    }
    
    

    public void setPacProfesionalResponsable(String pacProfesionalResponsable) {
        this.pacProfesionalResponsable.set(pacProfesionalResponsable);
    }

    public LocalDate getPacFechaReferencia() {
        return pacFechaReferencia.get();
    }

    public void setPacFechaReferencia(LocalDate pacFechaReferencia) {
        this.pacFechaReferencia.set(getPacFechaReferencia());
    }

    public LocalDate getPacfechaDiagnostico() {
         return pacfechaDiagnostico.get();
    }

    public void setPacfechaDiagnostico(LocalDate pacfechaDiagnostico) {
        this.pacfechaDiagnostico.set(getPacFechaReferencia());
    }

    public String getPacDoctor() {
        return pacDoctor.get();
    }

    public void setPacDoctor(String pacDoctor) {
        this.pacDoctor.set(pacDoctor);
    }

    public LocalDate getPacFechaRegistro() {
        return pacFechaRegistro.get();
    }

    public void setPacFechaRegistro(LocalDate pacFechaRegistro) {
        this.pacFechaRegistro.set(getPacFechaReferencia());
    }

    public InstitucionDto getInsId() {
        return insId;
    }

    public void setInsId(InstitucionDto insId) {
        this.insId = insId;
    }
    
    
}
