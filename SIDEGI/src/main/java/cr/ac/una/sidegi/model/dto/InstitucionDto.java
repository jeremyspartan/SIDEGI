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
    public SimpleStringProperty insId;
    public SimpleStringProperty insDescripcion;
    public List<ContactoDto> contactos;
    public TiposInstitucionDto tipoInstitucion;
    //private List<Paciente> pacienteList;
    
     public InstitucionDto(){
        this.insId = new SimpleStringProperty();
        this.insDescripcion = new SimpleStringProperty();
        this.contactos = new ArrayList<>();
    }
    
    public InstitucionDto(Institucion institucion){
        this.insId.set(Long.toString(institucion.getInsId()));
        this.insDescripcion.set(institucion.getInsDescripcion());
        this.tipoInstitucion = new TiposInstitucionDto(institucion.getTinsId());
         institucion.getContactos().forEach((object) -> {
            contactos.add(new ContactoDto(object));
        });
    }

    public Long getInsId() {
        if(insId.get()!=null && !insId.get().isEmpty())
            return Long.valueOf(insId.get());
        else
            return null;
    }

    public void setInsId(Long insId) {
        this.insId.set(insId.toString());
    }

    public String getInsDescripcion() {
        return insDescripcion.get();
    }

    public void setInsDescripcion(String insDescripcion) {
        this.insDescripcion.set(insDescripcion);
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
