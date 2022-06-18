/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @NamedQuery(name = "Contacto.findByConidContacto", query = "SELECT c FROM Contacto c WHERE c.conidContacto = :conidContacto"),
    @NamedQuery(name = "Contacto.findByConContacto", query = "SELECT c FROM Contacto c WHERE c.conContacto = :conContacto")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "con_idContacto")
    private Long conidContacto;
    @Basic(optional = false)
    @Column(name = "con_contacto")
    private String conContacto;
    @JoinTable(name = "sid_institucionescontactos", joinColumns = {
        @JoinColumn(name = "con_idContacto", referencedColumnName = "con_idContacto")}, inverseJoinColumns = {
        @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")})
    @ManyToMany
    private List<Institucion> institucionList;
    @JoinTable(name = "sid_personacontactos", joinColumns = {
        @JoinColumn(name = "con_idContacto", referencedColumnName = "con_idContacto")}, inverseJoinColumns = {
        @JoinColumn(name = "per_cedula", referencedColumnName = "per_cedula")})
    @ManyToMany
    private List<Persona> personaList;
    @JoinColumn(name = "tpc_idTipoContacto", referencedColumnName = "tpc_idTipoContacto")
    @ManyToOne
    private TipoContacto tpcidTipoContacto;

    public Contacto() {
    }

    public Contacto(Long conidContacto) {
        this.conidContacto = conidContacto;
    }

    public Contacto(Long conidContacto, String conContacto) {
        this.conidContacto = conidContacto;
        this.conContacto = conContacto;
    }

    public Long getConidContacto() {
        return conidContacto;
    }

    public void setConidContacto(Long conidContacto) {
        this.conidContacto = conidContacto;
    }

    public String getConContacto() {
        return conContacto;
    }

    public void setConContacto(String conContacto) {
        this.conContacto = conContacto;
    }

    @XmlTransient
    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public TipoContacto getTpcidTipoContacto() {
        return tpcidTipoContacto;
    }

    public void setTpcidTipoContacto(TipoContacto tpcidTipoContacto) {
        this.tpcidTipoContacto = tpcidTipoContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conidContacto != null ? conidContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.conidContacto == null && other.conidContacto != null) || (this.conidContacto != null && !this.conidContacto.equals(other.conidContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Contacto[ conidContacto=" + conidContacto + " ]";
    }
    
}
