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
    private SimpleStringProperty tpcidTipoContacto;
    private SimpleStringProperty tpcDescripcion;
    private List<ContactoDto> contactos;
    
    public TipoContactoDto(){
        this.tpcidTipoContacto = new SimpleStringProperty();
        this.tpcDescripcion = new SimpleStringProperty();
        contactos = new ArrayList<>();
    }
    
    public TipoContactoDto(TipoContacto tipoContacto){
        this.tpcidTipoContacto.set(Long.toString(tipoContacto.getTpcidTipoContacto()));
        this.tpcDescripcion.set(tipoContacto.getTpcDescripcion());
        tipoContacto.getContactos().forEach((object) -> {
            contactos.add(new ContactoDto(object));
        });//paso la lista de contactos de la bd a la lista de contactos del tipo dto
    }

    public Long getTpcidTipoContacto() {
        if(tpcidTipoContacto.get()!=null && !tpcidTipoContacto.get().isEmpty())
            return Long.valueOf(tpcidTipoContacto.get());
        else
            return null;
    }

    public void setTpcidTipoContacto(Long tpcidTipoContacto) {
        this.tpcidTipoContacto.set(tpcidTipoContacto.toString());
    }

    public String getTpcDescripcion() {
        return tpcDescripcion.get();
    }

    public void setTpcDescripcion(String tpcDescripcion) {
        this.tpcDescripcion.set(tpcDescripcion);
    }

    public List<ContactoDto> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDto> contactos) {
        this.contactos = contactos;
    }
    
    
}
