/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Institucion;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author computer
 */
public class InstitucionDto {
    public SimpleStringProperty idInstitucion;
    public SimpleStringProperty descripcion;
    public List<ContactoDto> contactos;
    public TiposInstitucionDto tipoInstitucion;
    //private List<Paciente> pacienteList;
    
     public InstitucionDto(){
        this.idInstitucion = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.contactos = new ArrayList<>();
    }
    
    public InstitucionDto(Institucion institucion){
        this.idInstitucion.set(Long.toString(institucion.getIdInstitucion()));
        this.descripcion.set(institucion.getDescripcion());
        this.tipoInstitucion = new TiposInstitucionDto(institucion.getTipoInstitucion());
         institucion.getContactos().forEach((object) -> {
            contactos.add(new ContactoDto(object));
        });
    }

    public Integer getIdInstituicion() {
        if(idInstitucion.get()!=null && !idInstitucion.get().isEmpty())
            return Integer.valueOf(idInstitucion.get());
        else
            return null;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion.set(idInstitucion.toString());
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public TiposInstitucionDto getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(TiposInstitucionDto tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public List<ContactoDto> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDto> contactos) {
        this.contactos = contactos;
    }
    
    
}
