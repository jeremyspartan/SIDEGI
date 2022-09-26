/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.ContactoDto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Contacto_1.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto_1.findByConidContacto", query = "SELECT c FROM Contacto c WHERE c.idContacto = :idContacto"),
    @NamedQuery(name = "Contacto_1.findByConContacto", query = "SELECT c FROM Contacto c WHERE c.contacto = :contacto")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_idContacto")
    private Integer idContacto;
    @Basic(optional = false)
    @Column(name = "con_contacto")
    private String contacto;
    @JoinTable(name = "sid_institucionescontactos", joinColumns = {
        @JoinColumn(name = "ixc_idContacto", referencedColumnName = "con_idContacto")}, inverseJoinColumns = {
        @JoinColumn(name = "ixc_idInstitucion", referencedColumnName = "ins_idInstitucion")})
    @ManyToMany
    private List<Institucion> instituciones;
    @ManyToMany(mappedBy = "contactos")
    private List<Persona> personas;
    @JoinColumn(name = "con_idTipoContacto", referencedColumnName = "tpc_idTipoContacto")
    @ManyToOne
    private TipoContacto tipoContacto;

    public Contacto() {
    }
    
    public Contacto(ContactoDto contactoDto){
        ActualizarContacto(contactoDto);
    }
    
    public void ActualizarContacto(ContactoDto contactoDto)
    {
        this.contacto = contactoDto.getContacto();
        this.tipoContacto = new TipoContacto(contactoDto.getTipoContactoDto().getIdTipoContacto());
        contactoDto.getInstitucionesDto().forEach((object) -> {
            this.instituciones.add(new Institucion(object));
        });
    }

    public Contacto(Integer conidContacto) {
        this.idContacto = conidContacto;
    }

    public Contacto(Integer conidContacto, String conContacto) {
        this.idContacto = conidContacto;
        this.contacto = conContacto;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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

    public TipoContacto getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(TipoContacto tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Contacto_1[ conidContacto=" + idContacto + " ]";
    }
    
}
