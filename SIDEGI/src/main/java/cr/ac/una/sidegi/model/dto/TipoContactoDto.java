/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Contacto;
import cr.ac.una.sidegi.model.TipoContacto;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author computer
 */
public class TipoContactoDto {
    public SimpleStringProperty idTipoContacto;
    public SimpleStringProperty descripcion;
    public List<ContactoDto> contactos;
    
    public TipoContactoDto(){
        this.idTipoContacto = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        contactos = new ArrayList<>();
    }
    
    public TipoContactoDto(TipoContacto tipoContacto){
        this.idTipoContacto.set(Long.toString(tipoContacto.getIdTipoContacto()));
        this.descripcion.set(tipoContacto.getDescripcion());
        tipoContacto.getContactos().forEach((object) -> {
            contactos.add(new ContactoDto(object));
        });//paso la lista de contactos de la bd a la lista de contactos del tipo dto
    }

    public Integer getIdTipoContacto() {
        if(idTipoContacto.get()!=null && !idTipoContacto.get().isEmpty())
            return Integer.valueOf(idTipoContacto.get());
        else
            return null;
    }

    public void setIdTipoContacto(Integer idTipoContacto) {
        this.idTipoContacto.set(idTipoContacto.toString());
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public List<ContactoDto> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDto> contactos) {
        this.contactos = contactos;
    }
    
    
}
