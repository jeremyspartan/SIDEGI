/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Institucion;
import cr.ac.una.sidegi.model.TiposInstitucion;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author computer
 */
public class TiposInstitucionDto {
    public SimpleStringProperty tinsId;
    public SimpleStringProperty tinsDescripicion;
    public List<InstitucionDto> institucionesDto;
    
    public TiposInstitucionDto(){
        this.tinsId = new SimpleStringProperty();
        this.tinsDescripicion = new SimpleStringProperty();
        this.institucionesDto = new ArrayList<>();
    }
    
    public TiposInstitucionDto(TiposInstitucion tiposInstitucion){
        this.tinsId.set(Long.toString(tiposInstitucion.getTinsId()));
        this.tinsDescripicion.set(tiposInstitucion.getTinsDescripicion());
        tiposInstitucion.getInstituciones().forEach((object) -> {
            this.institucionesDto.add(new InstitucionDto(object));
        });
    }

    public Long getTinsId() {
       if(tinsId.get()!=null && !tinsId.get().isEmpty())
            return Long.valueOf(tinsId.get());
        else
            return null;
    }

    public void setTinsId(Long tinsId) {
        this.tinsId.set(tinsId.toString());
    }

    public String getTinsDescripicion() {
        return tinsDescripicion.get();
    }

    public void setTinsDescripicion(String tinsDescripicion) {
        this.tinsDescripicion.set(tinsDescripicion);
    }

    public List<InstitucionDto> getInstitucionesDto() {
        return institucionesDto;
    }

    public void setInstitucionesDto(List<InstitucionDto> institucionesDto) {
        this.institucionesDto = institucionesDto;
    }
    
}
