/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.TipoSeguroDto;
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
@Table(name = "sid_tiposseguros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSeguro.findAll", query = "SELECT t FROM TipoSeguro t"),
    @NamedQuery(name = "TipoSeguro.findBySegidTipoSeguro", query = "SELECT t FROM TipoSeguro t WHERE t.idTipoSeguro = :idTipoSeguro"),
    @NamedQuery(name = "TipoSeguro.findBySegDescripcion", query = "SELECT t FROM TipoSeguro t WHERE t.descripcion = :descripcion")})
public class TipoSeguro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seg_idTipoSeguro")
    private Integer idTipoSeguro;
    @Basic(optional = false)
    @Column(name = "seg_descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tipoSeguro")
    private List<Persona> personas;//mapeado por el campo idTipoSeguro de Persona

    public TipoSeguro() {
    }

    public TipoSeguro(TipoSeguroDto tipoSeguroDto) {
        actualizarTipoSeguro(tipoSeguroDto);
    }
     
    public void actualizarTipoSeguro(TipoSeguroDto tipoSeguroDto){
        this.idTipoSeguro = tipoSeguroDto.getIdTipoSeguro();
        this.descripcion = tipoSeguroDto.getDescTipoSeguro();
    }
    
    public TipoSeguro(Integer segidTipoSeguro) {
        this.idTipoSeguro = segidTipoSeguro;
    }

    public TipoSeguro(Integer segidTipoSeguro, String segDescripcion) {
        this.idTipoSeguro = segidTipoSeguro;
        this.descripcion = segDescripcion;
    }

    public Integer getIdTipoSeguro() {
        return idTipoSeguro;
    }

    public void setIdTipoSeguro(Integer idTipoSeguro) {
        this.idTipoSeguro = idTipoSeguro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSeguro != null ? idTipoSeguro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSeguro)) {
            return false;
        }
        TipoSeguro other = (TipoSeguro) object;
        if ((this.idTipoSeguro == null && other.idTipoSeguro != null) || (this.idTipoSeguro != null && !this.idTipoSeguro.equals(other.idTipoSeguro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoSeguro[ segidTipoSeguro=" + idTipoSeguro + " ]";
    }
    
}
