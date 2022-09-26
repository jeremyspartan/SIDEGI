/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Institucion;
import cr.ac.una.sidegi.model.TipoInstitucion;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author computer
 */
public class TiposInstitucionDto {
    public SimpleStringProperty idTipoInstitucion;
    public SimpleStringProperty descripicion;
    public List<InstitucionDto> institucionesDto;
    
    public TiposInstitucionDto(){
        this.idTipoInstitucion = new SimpleStringProperty();
        this.descripicion = new SimpleStringProperty();
        this.institucionesDto = new ArrayList<>();
    }
    
    public TiposInstitucionDto(TipoInstitucion tiposInstitucion){
        this.idTipoInstitucion.set(Long.toString(tiposInstitucion.getIdTipoInstitucion()));
        this.descripicion.set(tiposInstitucion.getDescripicion());
        tiposInstitucion.getInstituciones().forEach((object) -> {
            this.institucionesDto.add(new InstitucionDto(object));
        });
    }

    public Integer getIdTipoInstitucion() {
       if(idTipoInstitucion.get()!=null && !idTipoInstitucion.get().isEmpty())
            return Integer.valueOf(idTipoInstitucion.get());
        else
            return null;
    }

    public void setIdTipoInstitucion(Integer idTipoInstitucion) {
        this.idTipoInstitucion.set(idTipoInstitucion.toString());
    }

    public String getDescripicion() {
        return descripicion.get();
    }

    public void setDescripicion(String descripicion) {
        this.descripicion.set(descripicion);
    }

    public List<InstitucionDto> getInstitucionesDto() {
        return institucionesDto;
    }

    public void setInstitucionesDto(List<InstitucionDto> institucionesDto) {
        this.institucionesDto = institucionesDto;
    }
    
}
