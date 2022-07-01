/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.TiposInstitucionDto;
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
@Table(name = "sid_tiposinstitucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposInstitucion.findAll", query = "SELECT t FROM TiposInstitucion t"),
    @NamedQuery(name = "TiposInstitucion.findByTinsId", query = "SELECT t FROM TiposInstitucion t WHERE t.tinsId = :tinsId"),
    @NamedQuery(name = "TiposInstitucion.findByTinsDescripicion", query = "SELECT t FROM TiposInstitucion t WHERE t.tinsDescripicion = :tinsDescripicion")})
public class TiposInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tins_id")
    private Long tinsId;
    @Basic(optional = false)
    @Column(name = "tins_descripicion")
    private String tinsDescripicion;
    @OneToMany(mappedBy = "tinsId")
    private List<Institucion> instituciones;

    public TiposInstitucion() {
    }
    
    public TiposInstitucion(TiposInstitucionDto tiposInstitucionDto) {
        actualizarTiposInstitucion(tiposInstitucionDto);
    }
    
    public void actualizarTiposInstitucion(TiposInstitucionDto tipoInstitucionDto){
        this.tinsId = tipoInstitucionDto.getTinsId();
        this.tinsDescripicion = tipoInstitucionDto.getTinsDescripicion();
        tipoInstitucionDto.getInstitucionesDto().forEach((object) -> {
            this.instituciones.add(new Institucion(object));
        });
    }

    public TiposInstitucion(Long tinsId) {
        this.tinsId = tinsId;
    }

    public TiposInstitucion(Long tinsId, String tinsDescripicion) {
        this.tinsId = tinsId;
        this.tinsDescripicion = tinsDescripicion;
    }

    public Long getTinsId() {
        return tinsId;
    }

    public void setTinsId(Long tinsId) {
        this.tinsId = tinsId;
    }

    public String getTinsDescripicion() {
        return tinsDescripicion;
    }

    public void setTinsDescripicion(String tinsDescripicion) {
        this.tinsDescripicion = tinsDescripicion;
    }

    @XmlTransient
    public List<Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(List<Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tinsId != null ? tinsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposInstitucion)) {
            return false;
        }
        TiposInstitucion other = (TiposInstitucion) object;
        if ((this.tinsId == null && other.tinsId != null) || (this.tinsId != null && !this.tinsId.equals(other.tinsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TiposInstitucion[ tinsId=" + tinsId + " ]";
    }
    
}
