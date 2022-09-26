/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

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
@Table(name = "sid_situacioneconomica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionEconomica.findAll", query = "SELECT s FROM SituacionEconomica s"),
    @NamedQuery(name = "SituacionEconomica.findBySeidSituacionEconomica", query = "SELECT s FROM SituacionEconomica s WHERE s.idSituacionEconomica = :idSituacionEconomica"),
    @NamedQuery(name = "SituacionEconomica.findBySetipoSituacion", query = "SELECT s FROM SituacionEconomica s WHERE s.tipoSituacion = :tipoSituacion")})
public class SituacionEconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "se_idSituacionEconomica")
    private Integer idSituacionEconomica;
    @Basic(optional = false)
    @Column(name = "se_tipoSituacion")
    private String tipoSituacion;
    @OneToMany(mappedBy = "situacionEconomica")
    private List<IngresoEconomico> ingresosEconomicos;//mapeado por el campo idSituacionEconomica de IngresoEconomico

    public SituacionEconomica() {
    }

    public SituacionEconomica(Integer seidSituacionEconomica) {
        this.idSituacionEconomica = seidSituacionEconomica;
    }

    public SituacionEconomica(Integer seidSituacionEconomica, String setipoSituacion) {
        this.idSituacionEconomica = seidSituacionEconomica;
        this.tipoSituacion = setipoSituacion;
    }

    public Integer getIdSituacionEconomica() {
        return idSituacionEconomica;
    }

    public void setIdSituacionEconomica(Integer idSituacionEconomica) {
        this.idSituacionEconomica = idSituacionEconomica;
    }

    public String getTipoSituacion() {
        return tipoSituacion;
    }

    public void setTipoSituacion(String tipoSituacion) {
        this.tipoSituacion = tipoSituacion;
    }

    @XmlTransient
    public List<IngresoEconomico> getIngresosEconomicos() {
        return ingresosEconomicos;
    }

    public void setIngresosEconomicos(List<IngresoEconomico> ingresosEconomicos) {
        this.ingresosEconomicos = ingresosEconomicos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacionEconomica != null ? idSituacionEconomica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionEconomica)) {
            return false;
        }
        SituacionEconomica other = (SituacionEconomica) object;
        if ((this.idSituacionEconomica == null && other.idSituacionEconomica != null) || (this.idSituacionEconomica != null && !this.idSituacionEconomica.equals(other.idSituacionEconomica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.SituacionEconomica[ seidSituacionEconomica=" + idSituacionEconomica + " ]";
    }
    
}
