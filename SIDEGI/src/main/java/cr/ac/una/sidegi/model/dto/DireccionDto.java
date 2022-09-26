/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Direccion;
import java.text.ParseException;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class DireccionDto {
    public SimpleStringProperty idDireccion;
    public SimpleStringProperty descDireccion;

    public DireccionDto() {
        this.idDireccion = new SimpleStringProperty();
        this.descDireccion = new SimpleStringProperty();
    }
    public DireccionDto(DireccionDto direccionService)  {
        this.idDireccion.set(direccionService.getIdDireccion().toString());
        this.descDireccion.set(direccionService.getDescDireccion());

    }
    public DireccionDto(Direccion direccion){
        this.idDireccion.set(Long.toString(direccion.getIdDireccion()));
        this.descDireccion.set(direccion.getDescDireccion());

    }

    public Integer getIdDireccion() {
        if(idDireccion.get()!=null && !idDireccion.get().isEmpty())
            return Integer.valueOf(idDireccion.get());
        else
            return null;
    }

    public void setIdDireccion(Long direcId) {
        this.idDireccion.set(direcId.toString());
    }

    public String getDescDireccion() {
        return descDireccion.get();
    }

    public void setDescDireccion(String direcDesc) {
        this.descDireccion.set(direcDesc);
    }
    
    
    
}
