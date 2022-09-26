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

    public SimpleStringProperty cedula;
    public SimpleStringProperty nombre;
    public SimpleStringProperty pApellido;
    public SimpleStringProperty sApellido;  
    public ObjectProperty<LocalDate> fechaNacimiento;
    public TipoSeguroDto tipoSeguroDto;
    public EscolaridadDto escolaridadDto;
    public DireccionDto direccionDto;

    public PersonaDto() {
        this.cedula = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.pApellido = new SimpleStringProperty();
        this.sApellido = new SimpleStringProperty();
        this.fechaNacimiento = new SimpleObjectProperty();
    }
    public PersonaDto(Persona persona) throws ParseException {
        this();
        this.nombre.set(persona.getNombre());
        this.pApellido.set(persona.getpApellido());
        this.sApellido.set(persona.getsApellido());
        this.cedula.set(persona.getCedula());
        this.fechaNacimiento.set(persona.getFechaNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        this.tipoSeguroDto = new TipoSeguroDto(persona.getTipoSeguro());
        this.escolaridadDto=new EscolaridadDto(persona.getEscolaridad());
        this.direccionDto = new DireccionDto(persona.getDireccion());


    }

    public String getCedula() {
        return cedula.get();
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getPapellido() {
        return pApellido.get();
    }

    public void setPapellido(String pApellido) {
        this.pApellido.set(pApellido);
    }

    public String getSapellido() {
        return sApellido.get();
    }

    public void setSapellido(String sApellido) {
        this.sApellido.set(sApellido);
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public void setPerFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }
    
    
    
    
    
    

    
}
