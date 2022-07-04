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
    public SimpleStringProperty conIdContacto;
    public SimpleStringProperty conContacto;
    public List<InstitucionDto> institucionesDto;
    //private List<Persona> personas;
    public TipoContactoDto tpcIdTipoContactoDto;
    
    public ContactoDto(){
        this.conIdContacto = new SimpleStringProperty();
        this.conContacto = new SimpleStringProperty();
    }
    
    public ContactoDto(Contacto contacto){
        this.conIdContacto.set(Long.toString(contacto.getConIdContacto()));
        this.conContacto.set(contacto.getConContacto());
        this.tpcIdTipoContactoDto = new TipoContactoDto(contacto.getTpcIdTipoContacto());
        //    contacto.getInstituciones().forEach((object) -> {
          //      this.institucionesDto.add(new InstitucionDto(object));
          //  });
    }

    public Long getConIdContacto() {
        if(conIdContacto.get()!=null && !conIdContacto.get().isEmpty())
            return Long.valueOf(conIdContacto.get());
        else
            return null;
    }

    public void setConIdContacto(Long conIdContacto) {
        this.conIdContacto.set(conIdContacto.toString());
    }

    public String getConContacto() {
        return conContacto.get();
    }

    public void setConContacto(String conContacto) {
        this.conContacto.set(conContacto);
    }

    public List<InstitucionDto> getInstitucionesDto() {
        return institucionesDto;
    }

    public void setInstitucionesDto(List<InstitucionDto> institucionesDto) {
        this.institucionesDto = institucionesDto;
    }

    public TipoContactoDto getTpcIdTipoContactoDto() {
        return tpcIdTipoContactoDto;
    }

    public void setTpcIdTipoContactoDto(TipoContactoDto tpcIdTipoContactoDto) {
        this.tpcIdTipoContactoDto = tpcIdTipoContactoDto;
    }
    
}
