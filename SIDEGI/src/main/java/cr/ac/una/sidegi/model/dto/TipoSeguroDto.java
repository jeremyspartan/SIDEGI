/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.TipoSeguro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class TipoSeguroDto {
    public SimpleStringProperty tipoSegId;
    public SimpleStringProperty tipoSegDesc;

    public TipoSeguroDto() {
        this.tipoSegId = new SimpleStringProperty();
        this.tipoSegDesc = new SimpleStringProperty();
    }
    public TipoSeguroDto(TipoSeguroDto tipoSeguroService) {
        this.tipoSegId.set(tipoSeguroService.getTipoSegId().toString());
        this.tipoSegDesc.set(tipoSeguroService.getTipoSegDesc());

    }
    public TipoSeguroDto(TipoSeguro tipoSeguro){
        this.tipoSegId.set(Long.toString(tipoSeguro.getSegId()));
        this.tipoSegDesc.set(tipoSeguro.getSegDescripcion());

    }

    public Long getTipoSegId() {
        if(tipoSegId.get()!=null && !tipoSegId.get().isEmpty())
            return Long.valueOf(tipoSegId.get());
        else
            return null;
    }

    public void setTipoSegId(Long tipoSegId) {
        this.tipoSegId.set(tipoSegId.toString());
    }

    public String getTipoSegDesc() {
        return tipoSegDesc.get();
    }

    public void setTipoSegDesc(String tipoSegDesc) {
        this.tipoSegDesc.set(tipoSegDesc);
    }
    

   
    
    
    
    

    
    
}
