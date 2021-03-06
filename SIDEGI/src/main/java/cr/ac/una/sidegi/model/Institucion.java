/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.InstitucionDto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_instituciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i"),
    @NamedQuery(name = "Institucion.findByInsId", query = "SELECT i FROM Institucion i WHERE i.insId = :insId"),
    @NamedQuery(name = "Institucion.findByInsDescripcion", query = "SELECT i FROM Institucion i WHERE i.insDescripcion = :insDescripcion")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ins_id")
    private Long insId;
    @Basic(optional = false)
    @Column(name = "ins_descripcion")
    private String insDescripcion;
    @ManyToMany(mappedBy = "instituciones")
    private List<Contacto> contactos;
    @JoinColumn(name = "tins_id", referencedColumnName = "tins_id")
    @ManyToOne
    private TiposInstitucion tinsId;
    @OneToMany(mappedBy = "insId")
    private List<Paciente> pacientes;

    public Institucion() {
    }
    
    public Institucion(InstitucionDto institucionDto){
        actualizarInstitucion(institucionDto);
    }
    
    public void actualizarInstitucion(InstitucionDto institucionDto) {
        this.insId = institucionDto.getInsId();
        this.insDescripcion = institucionDto.getInsDescripcion();
         institucionDto.getContactos().forEach((object) -> {
            contactos.add(new Contacto(object));
        });
         this.tinsId = new TiposInstitucion(institucionDto.getTipoInstitucion());
    }

    public Institucion(Long insId) {
        this.insId = insId;
    }

    public Institucion(Long insId, String insDescripcion) {
        this.insId = insId;
        this.insDescripcion = insDescripcion;
    }

    public Long getInsId() {
        return insId;
    }

    public void setInsId(Long insId) {
        this.insId = insId;
    }

    public String getInsDescripcion() {
        return insDescripcion;
    }

    public void setInsDescripcion(String insDescripcion) {
        this.insDescripcion = insDescripcion;
    }

    @XmlTransient
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public TiposInstitucion getTinsId() {
        return tinsId;
    }

    public void setTinsId(TiposInstitucion tinsId) {
        this.tinsId = tinsId;
    }

    @XmlTransient
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insId != null ? insId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.insId == null && other.insId != null) || (this.insId != null && !this.insId.equals(other.insId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Institucion[ insId=" + insId + " ]";
    }
    
}
