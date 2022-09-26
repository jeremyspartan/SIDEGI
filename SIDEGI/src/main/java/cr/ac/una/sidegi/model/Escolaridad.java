/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.EscolaridadDto;
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
@Table(name = "sid_escolaridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridad.findAll", query = "SELECT e FROM Escolaridad e"),
    @NamedQuery(name = "Escolaridad.findByEscidEscolaridad", query = "SELECT e FROM Escolaridad e WHERE e.idEscolaridad = :idEscolaridad"),
    @NamedQuery(name = "Escolaridad.findByEscDescripcion", query = "SELECT e FROM Escolaridad e WHERE e.descripcion = :descripcion")})
public class Escolaridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esc_idEscolaridad")
    private Integer idEscolaridad;
    @Basic(optional = false)
    @Column(name = "esc_descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "escolaridad")
    private List<Persona> personas;//mapeado por el campo idEscolaridad de persona

    public Escolaridad() {
    }
    
    public Escolaridad(EscolaridadDto escolaridadDto) {
        actualizarEscolaridad(escolaridadDto);
    }
     
    public void actualizarEscolaridad(EscolaridadDto escolaridadDto){
        this.idEscolaridad = escolaridadDto.getIdEscolaridad();
        this.descripcion = escolaridadDto.getDescEscolaridad();
    }

    public Escolaridad(Integer escidEscolaridad) {
        this.idEscolaridad = escidEscolaridad;
    }

    public Escolaridad(Integer escidEscolaridad, String escDescripcion) {
        this.idEscolaridad = escidEscolaridad;
        this.descripcion = escDescripcion;
    }

    public Integer getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(Integer idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
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
        hash += (idEscolaridad != null ? idEscolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridad)) {
            return false;
        }
        Escolaridad other = (Escolaridad) object;
        if ((this.idEscolaridad == null && other.idEscolaridad != null) || (this.idEscolaridad != null && !this.idEscolaridad.equals(other.idEscolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Escolaridad[ escidEscolaridad=" + idEscolaridad + " ]";
    }
    
}
