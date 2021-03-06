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
    @NamedQuery(name = "TipoContacto.findByTpcidTipoContacto", query = "SELECT t FROM TipoContacto t WHERE t.tpcidTipoContacto = :tpcidTipoContacto"),
    @NamedQuery(name = "TipoContacto.findByTpcDescripcion", query = "SELECT t FROM TipoContacto t WHERE t.tpcDescripcion = :tpcDescripcion")})
public class TipoContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tpc_idTipoContacto")
    private Long tpcidTipoContacto;
    @Basic(optional = false)
    @Column(name = "tpc_descripcion")
    private String tpcDescripcion;
    @OneToMany(mappedBy = "tpcIdTipoContacto")
    private List<Contacto> contactos;

    public TipoContacto() {
    }
    
    public TipoContacto(TipoContactoDto  tipoContactoDto) {
        actualizarTipoContacto(tipoContactoDto);
    }
     
    public void actualizarTipoContacto(TipoContactoDto tipoContactoDto){
        this.tpcidTipoContacto = tipoContactoDto.getTpcidTipoContacto();
        this.tpcDescripcion = tipoContactoDto.getTpcDescripcion();
        tipoContactoDto.getContactos().forEach((object) -> {
            contactos.add(new Contacto(object));
        });
    }

    public TipoContacto(Long tpcidTipoContacto) {
        this.tpcidTipoContacto = tpcidTipoContacto;
    }

    public TipoContacto(Long tpcidTipoContacto, String tpcDescripcion) {
        this.tpcidTipoContacto = tpcidTipoContacto;
        this.tpcDescripcion = tpcDescripcion;
    }

    public Long getTpcidTipoContacto() {
        return tpcidTipoContacto;
    }

    public void setTpcidTipoContacto(Long tpcidTipoContacto) {
        this.tpcidTipoContacto = tpcidTipoContacto;
    }

    public String getTpcDescripcion() {
        return tpcDescripcion;
    }

    public void setTpcDescripcion(String tpcDescripcion) {
        this.tpcDescripcion = tpcDescripcion;
    }

    @XmlTransient
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactoList) {
        this.contactos = contactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpcidTipoContacto != null ? tpcidTipoContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContacto)) {
            return false;
        }
        TipoContacto other = (TipoContacto) object;
        if ((this.tpcidTipoContacto == null && other.tpcidTipoContacto != null) || (this.tpcidTipoContacto != null && !this.tpcidTipoContacto.equals(other.tpcidTipoContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoContacto[ tpcidTipoContacto=" + tpcidTipoContacto + " ]";
    }
    
}
