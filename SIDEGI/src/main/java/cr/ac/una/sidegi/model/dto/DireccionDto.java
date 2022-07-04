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
    public SimpleStringProperty direcId;
    public SimpleStringProperty direcDesc;

    public DireccionDto() {
        this.direcId = new SimpleStringProperty();
        this.direcDesc = new SimpleStringProperty();
    }
    public DireccionDto(DireccionDto direccionService)  {
        this.direcId.set(direccionService.getDirecId().toString());
        this.direcDesc.set(direccionService.getDirecDesc());

    }
    public DireccionDto(Direccion direccion){
        this.direcId.set(Long.toString(direccion.getDiridDireccion()));
        this.direcDesc.set(direccion.getDirdescDireccion());

    }

    public Long getDirecId() {
        if(direcId.get()!=null && !direcId.get().isEmpty())
            return Long.valueOf(direcId.get());
        else
            return null;
    }

    public void setDirecId(Long direcId) {
        this.direcId.set(direcId.toString());
    }

    public String getDirecDesc() {
        return direcDesc.get();
    }

    public void setDirecDesc(String direcDesc) {
        this.direcDesc.set(direcDesc);
    }
    
    
    
}
