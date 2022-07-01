/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.ContactoDto;
import cr.ac.una.sidegi.model.dto.TipoContactoDto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByConidContacto", query = "SELECT c FROM Contacto c WHERE c.conIdContacto = :conIdContacto"),
    @NamedQuery(name = "Contacto.findByConContacto", query = "SELECT c FROM Contacto c WHERE c.conContacto = :conContacto")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "con_idContacto")
    private Long conIdContacto;
    @Basic(optional = false)
    @Column(name = "con_contacto")
    private String conContacto;
    @JoinTable(name = "sid_institucionescontactos", joinColumns = {
        @JoinColumn(name = "con_idContacto", referencedColumnName = "con_idContacto")}, inverseJoinColumns = {
        @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")})
    @ManyToMany
    private List<Institucion> instituciones;
    @JoinTable(name = "sid_personacontactos", joinColumns = {
        @JoinColumn(name = "con_idContacto", referencedColumnName = "con_idContacto")}, inverseJoinColumns = {
        @JoinColumn(name = "per_cedula", referencedColumnName = "per_cedula")})
    @ManyToMany
    private List<Persona> personas;
    @JoinColumn(name = "tpc_idTipoContacto", referencedColumnName = "tpc_idTipoContacto")
    @ManyToOne
    private TipoContacto tpcIdTipoContacto;

    public Contacto() {
    }
    
    public Contacto(ContactoDto contactoDto){
        ActualizarContacto(contactoDto);
    }
    
    public void ActualizarContacto(ContactoDto contactoDto)
    {
        this.conIdContacto = contactoDto.getConIdContacto();
        this.conContacto = contactoDto.getConContacto();
        this.tpcIdTipoContacto = new TipoContacto(contactoDto.getTpcIdTipoContactoDto());
        contactoDto.getInstitucionesDto().forEach((object) -> {
            this.instituciones.add(new Institucion(object));
        });
    }

    public Contacto(Long conidContacto) {
        this.conIdContacto = conidContacto;
    }

    public Contacto(Long conidContacto, String conContacto) {
        this.conIdContacto = conidContacto;
        this.conContacto = conContacto;
    }

    public Long getConIdContacto() {
        return conIdContacto;
    }

    public void setConIdContacto(Long conIdContacto) {
        this.conIdContacto = conIdContacto;
    }

    public String getConContacto() {
        return conContacto;
    }

    public void setConContacto(String conContacto) {
        this.conContacto = conContacto;
    }

    @XmlTransient
    public List<Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(List<Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    @XmlTransient
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public TipoContacto getTpcIdTipoContacto() {
        return tpcIdTipoContacto;
    }

    public void setTpcIdTipoContacto(TipoContacto tpcIdTipoContacto) {
        this.tpcIdTipoContacto = tpcIdTipoContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conIdContacto != null ? conIdContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.conIdContacto == null && other.conIdContacto != null) || (this.conIdContacto != null && !this.conIdContacto.equals(other.conIdContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Contacto[ conidContacto=" + conIdContacto + " ]";
    }
    
}
