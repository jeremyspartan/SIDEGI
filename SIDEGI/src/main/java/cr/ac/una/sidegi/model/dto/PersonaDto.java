/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.datatype.XMLGregorianCalendar;
/**
 *
 * @author Usuario
 */
public class PersonaDto {

    public SimpleStringProperty perCedula;
    public SimpleStringProperty perNombre;
    public SimpleStringProperty perPapellido;
    public SimpleStringProperty perSapellido;  
    public ObjectProperty<LocalDate> perFechaNacimiento;
    public TipoSeguroDto perIdTipoSeguroDto;
    public EscolaridadDto perIdEscolaridadDto;
    public DireccionDto perIdDireccionDto;

    public PersonaDto() {
        this.perCedula = new SimpleStringProperty();
        this.perNombre = new SimpleStringProperty();
        this.perPapellido = new SimpleStringProperty();
        this.perSapellido = new SimpleStringProperty();
        this.perFechaNacimiento = new SimpleObjectProperty();
    }
    public PersonaDto(Persona persona) throws ParseException {
        this();
        this.perNombre.set(persona.getPerNombre());
        this.perPapellido.set(persona.getPerpApellido());
        this.perSapellido.set(persona.getPersApellido());
        this.perCedula.set(persona.getPerCedula());
        this.perFechaNacimiento.set(persona.getPerfechaNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        this.perIdTipoSeguroDto = new TipoSeguroDto(persona.getSegId());
        this.perIdEscolaridadDto=new EscolaridadDto(persona.getEscId());
        this.perIdDireccionDto = new DireccionDto(persona.getDiridDireccion());


    }

    public String getPerCedula() {
        return perCedula.get();
    }

    public void setPerCedula(String perCedula) {
        this.perCedula.set(perCedula);
    }

    public String getPerNombre() {
        return perNombre.get();
    }

    public void setPerNombre(String perNombre) {
        this.perNombre.set(perNombre);
    }

    public String getPerPapellido() {
        return perPapellido.get();
    }

    public void setPerPapellido(String perPapellido) {
        this.perPapellido.set(perPapellido);
    }

    public String getPerSapellido() {
        return perSapellido.get();
    }

    public void setPerSapellido(String perSapellido) {
        this.perSapellido.set(perSapellido);
    }

    public LocalDate getPerFechaNacimiento() {
        return perFechaNacimiento.get();
    }

    public void setPerFechaNacimiento(LocalDate perFechaNacimiento) {
        this.perFechaNacimiento.set(perFechaNacimiento);
    }
    
    
    
    
    
    

    
}
