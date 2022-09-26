/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Escolaridad;
import java.text.ParseException;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class EscolaridadDto {
    public SimpleStringProperty idEscolaridad;
    public SimpleStringProperty descEscolaridad;
    
    public EscolaridadDto() {
        this.idEscolaridad = new SimpleStringProperty();
        this.descEscolaridad = new SimpleStringProperty();
    }
    public EscolaridadDto(EscolaridadDto escolaridadService) throws ParseException {
        this();
        this.idEscolaridad.set(escolaridadService.getIdEscolaridad().toString());
        this.descEscolaridad.set(escolaridadService.getDescEscolaridad());

    }
    public EscolaridadDto(Escolaridad escolaridad){
        this.idEscolaridad.set(Long.toString(escolaridad.getIdEscolaridad()));
        this.descEscolaridad.set(escolaridad.getDescripcion());
    }

    public Integer getIdEscolaridad() {
        if(idEscolaridad.get()!=null && !idEscolaridad.get().isEmpty())
            return Integer.valueOf(idEscolaridad.get());
        else
            return null;
    }

    public void setIdEscolaridad(Long idEscolaridad) {
        this.idEscolaridad.set(idEscolaridad.toString());
    }

    public String getDescEscolaridad() {
        return descEscolaridad.get();
    }

    public void setDescEscolaridad(String descEscolaridad) {
        this.descEscolaridad.set(descEscolaridad);
    }
    
    
}

