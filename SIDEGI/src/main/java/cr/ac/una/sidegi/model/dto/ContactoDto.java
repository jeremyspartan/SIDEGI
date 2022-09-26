/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model.dto;

import cr.ac.una.sidegi.model.Contacto;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author computer
 */
public class ContactoDto {
    public SimpleStringProperty IdContacto;
    public SimpleStringProperty contacto;
    public List<InstitucionDto> institucionesDto;
    //private List<Persona> personas;
    public TipoContactoDto TipoContactoDto;
    
    public ContactoDto(){
        this.IdContacto = new SimpleStringProperty();
        this.contacto = new SimpleStringProperty();
    }
    
    public ContactoDto(Contacto contacto){
        this.IdContacto.set(Long.toString(contacto.getIdContacto()));
        this.contacto.set(contacto.getContacto());
        this.TipoContactoDto = new TipoContactoDto(contacto.getTipoContacto());
        //    contacto.getInstituciones().forEach((object) -> {
          //      this.institucionesDto.add(new InstitucionDto(object));
          //  });
    }

    public Long getConIdContacto() {
        if(IdContacto.get()!=null && !IdContacto.get().isEmpty())
            return Long.valueOf(IdContacto.get());
        else
            return null;
    }

    public void setConIdContacto(Long conIdContacto) {
        this.IdContacto.set(conIdContacto.toString());
    }

    public String getContacto() {
        return contacto.get();
    }

    public void setContacto(String conContacto) {
        this.contacto.set(conContacto);
    }

    public List<InstitucionDto> getInstitucionesDto() {
        return institucionesDto;
    }

    public void setInstitucionesDto(List<InstitucionDto> institucionesDto) {
        this.institucionesDto = institucionesDto;
    }

    public TipoContactoDto getTipoContactoDto() {
        return TipoContactoDto;
    }

    public void setTipoContactoDto(TipoContactoDto TipoContactoDto) {
        this.TipoContactoDto = TipoContactoDto;
    }
    
}
