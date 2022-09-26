/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.TipoContactoDto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sid_tipocontactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContacto.findAll", query = "SELECT t FROM TipoContacto t"),
    @NamedQuery(name = "TipoContacto.findByTpcidTipoContacto", query = "SELECT t FROM TipoContacto t WHERE t.idTipoContacto = :idTipoContacto"),
    @NamedQuery(name = "TipoContacto.findByTpcDescripcion", query = "SELECT t FROM TipoContacto t WHERE t.descripcion = :descripcion")})
public class TipoContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tpc_idTipoContacto")
    private Integer idTipoContacto;
    @Basic(optional = false)
    @Column(name = "tpc_descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tipoContacto")
    private List<Contacto> contactos;//mapeado por el campo idContacto de Contacto

    public TipoContacto() {
    }
    
    public TipoContacto(TipoContactoDto  tipoContactoDto) {
        actualizarTipoContacto(tipoContactoDto);
    }
     
    public void actualizarTipoContacto(TipoContactoDto tipoContactoDto){
        this.idTipoContacto = tipoContactoDto.getIdTipoContacto();
        this.descripcion = tipoContactoDto.getDescripcion();
        tipoContactoDto.getContactos().forEach((object) -> {
            contactos.add(new Contacto(object));
        });
    }

    public TipoContacto(Integer tpcidTipoContacto) {
        this.idTipoContacto = tpcidTipoContacto;
    }

    public TipoContacto(Integer tpcidTipoContacto, String tpcDescripcion) {
        this.idTipoContacto = tpcidTipoContacto;
        this.descripcion = tpcDescripcion;
    }

    public Integer getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(Integer idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoContacto != null ? idTipoContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContacto)) {
            return false;
        }
        TipoContacto other = (TipoContacto) object;
        if ((this.idTipoContacto == null && other.idTipoContacto != null) || (this.idTipoContacto != null && !this.idTipoContacto.equals(other.idTipoContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoContacto[ tpcidTipoContacto=" + idTipoContacto + " ]";
    }
    
}
