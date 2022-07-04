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
    public SimpleStringProperty escId;
    public SimpleStringProperty escDesc;
    
    public EscolaridadDto() {
        this.escId = new SimpleStringProperty();
        this.escDesc = new SimpleStringProperty();
    }
    public EscolaridadDto(EscolaridadDto escolaridadService) throws ParseException {
        this();
        this.escId.set(escolaridadService.getEscId().toString());
        this.escDesc.set(escolaridadService.getEscDesc());

    }
    public EscolaridadDto(Escolaridad escolaridad){
        this.escId.set(Long.toString(escolaridad.getEscId()));
        this.escDesc.set(escolaridad.getEscDescripcion());
    }

    public Long getEscId() {
        if(escId.get()!=null && !escId.get().isEmpty())
            return Long.valueOf(escId.get());
        else
            return null;
    }

    public void setEscId(Long escId) {
        this.escId.set(escId.toString());
    }

    public String getEscDesc() {
        return escDesc.get();
    }

    public void setEscDesc(String escDesc) {
        this.escDesc.set(escDesc);
    }
    
    
}

