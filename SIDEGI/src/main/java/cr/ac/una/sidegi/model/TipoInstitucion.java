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
@Table(name = "sid_tiposinstitucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInstitucion.findAll", query = "SELECT t FROM TipoInstitucion t"),
    @NamedQuery(name = "TipoInstitucion.findByTinsidTipoInstitucion", query = "SELECT t FROM TipoInstitucion t WHERE t.idTipoInstitucion = :idTipoInstitucion"),
    @NamedQuery(name = "TipoInstitucion.findByTinsDescripicion", query = "SELECT t FROM TipoInstitucion t WHERE t.descripicion = :descripicion")})
public class TipoInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tins_idTipoInstitucion")
    private Integer idTipoInstitucion;
    @Basic(optional = false)
    @Column(name = "tins_descripicion")
    private String descripicion;
    @OneToMany(mappedBy = "tipoInstitucion")
    private List<Institucion> instituciones;//mapeado por el campo idTipoInstiticion de Institucion

    public TipoInstitucion() {
    }
    
    public TipoInstitucion(TiposInstitucionDto tiposInstitucionDto) {
        actualizarTiposInstitucion(tiposInstitucionDto);
    }
    
    public void actualizarTiposInstitucion(TiposInstitucionDto tipoInstitucionDto){
        this.idTipoInstitucion = tipoInstitucionDto.getIdTipoInstitucion();
        this.descripicion = tipoInstitucionDto.getDescripicion();
        tipoInstitucionDto.getInstitucionesDto().forEach((object) -> {
            this.instituciones.add(new Institucion(object));
        });
    }

    public TipoInstitucion(Integer tinsidTipoInstitucion) {
        this.idTipoInstitucion = tinsidTipoInstitucion;
    }

    public TipoInstitucion(Integer tinsidTipoInstitucion, String tinsDescripicion) {
        this.idTipoInstitucion = tinsidTipoInstitucion;
        this.descripicion = tinsDescripicion;
    }

    public Integer getIdTipoInstitucion() {
        return idTipoInstitucion;
    }

    public void setIdTipoInstitucion(Integer idTipoInstitucion) {
        this.idTipoInstitucion = idTipoInstitucion;
    }

    public String getDescripicion() {
        return descripicion;
    }

    public void setDescripicion(String descripicion) {
        this.descripicion = descripicion;
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
        hash += (idTipoInstitucion != null ? idTipoInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstitucion)) {
            return false;
        }
        TipoInstitucion other = (TipoInstitucion) object;
        if ((this.idTipoInstitucion == null && other.idTipoInstitucion != null) || (this.idTipoInstitucion != null && !this.idTipoInstitucion.equals(other.idTipoInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoInstitucion[ tinsidTipoInstitucion=" + idTipoInstitucion + " ]";
    }
    
}
