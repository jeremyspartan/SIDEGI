/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.TipoSeguro;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class TipoSeguroDto {
    public SimpleStringProperty idTipoSeguro;
    public SimpleStringProperty descTipoSeguro;

    public TipoSeguroDto() {
        this.idTipoSeguro = new SimpleStringProperty();
        this.descTipoSeguro = new SimpleStringProperty();
    }
    public TipoSeguroDto(TipoSeguroDto tipoSeguroService) {
        this.idTipoSeguro.set(tipoSeguroService.getIdTipoSeguro().toString());
        this.descTipoSeguro.set(tipoSeguroService.getDescTipoSeguro());

    }
    public TipoSeguroDto(TipoSeguro tipoSeguro){
        this.idTipoSeguro.set(Long.toString(tipoSeguro.getIdTipoSeguro()));
        this.descTipoSeguro.set(tipoSeguro.getDescripcion());

    }

    public Integer getIdTipoSeguro() {
        if(idTipoSeguro.get()!=null && !idTipoSeguro.get().isEmpty())
            return Integer.valueOf(idTipoSeguro.get());
        else
            return null;
    }

    public void setIdTipoSeguro(Long idTipoSeguro) {
        this.idTipoSeguro.set(idTipoSeguro.toString());
    }

    public String getDescTipoSeguro() {
        return descTipoSeguro.get();
    }

    public void setDescTipoSeguro(String descTipoSeguro) {
        this.descTipoSeguro.set(descTipoSeguro);
    }
    

   
    
    
    
    

    
    
}
