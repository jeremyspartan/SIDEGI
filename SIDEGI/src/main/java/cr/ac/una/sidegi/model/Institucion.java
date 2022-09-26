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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Institucion.findByInsidInstitucion", query = "SELECT i FROM Institucion i WHERE i.idInstitucion = :idInstitucion"),
    @NamedQuery(name = "Institucion.findByInsDescripcion", query = "SELECT i FROM Institucion i WHERE i.descripcion = :descripcion")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ins_idInstitucion")
    private Integer idInstitucion;
    @Basic(optional = false)
    @Column(name = "ins_descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "instituciones")
    private List<Contacto> contactos;//mapeado por el campo instituciones de contacto
    @JoinColumn(name = "ins_idTipoInstitucion", referencedColumnName = "tins_idTipoInstitucion")
    @ManyToOne
    private TipoInstitucion tipoInstitucion;
    @OneToMany(mappedBy = "institucion")
    private List<Paciente> pacientes;

    public Institucion() {
    }
    
    public Institucion(InstitucionDto institucionDto){
        actualizarInstitucion(institucionDto);
    }
    
    public void actualizarInstitucion(InstitucionDto institucionDto) {
        this.idInstitucion = institucionDto.getIdInstituicion();
        this.descripcion = institucionDto.getDescripcion();
         institucionDto.getContactos().forEach((object) -> {
            contactos.add(new Contacto(object));
        });
         this.tipoInstitucion = new TipoInstitucion(institucionDto.getTipoInstitucion());
    }

    public Institucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Institucion(Integer insidInstitucion, String insDescripcion) {
        this.idInstitucion = insidInstitucion;
        this.descripcion = insDescripcion;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public TipoInstitucion getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(TipoInstitucion tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
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
        hash += (idInstitucion != null ? idInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.idInstitucion == null && other.idInstitucion != null) || (this.idInstitucion != null && !this.idInstitucion.equals(other.idInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Institucion[ insidInstitucion=" + idInstitucion + " ]";
    }
    
}
