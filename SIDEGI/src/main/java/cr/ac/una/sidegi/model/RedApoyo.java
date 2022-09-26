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
import javax.persistence.JoinColumn;
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
@Table(name = "sid_redapoyos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedApoyo.findAll", query = "SELECT r FROM RedApoyo r"),
    @NamedQuery(name = "RedApoyo.findByRaidRedApoyo", query = "SELECT r FROM RedApoyo r WHERE r.idRedApoyo = :idRedApoyo"),
    @NamedQuery(name = "RedApoyo.findByRaDescripcion", query = "SELECT r FROM RedApoyo r WHERE r.descripcion = :descripcion")})
public class RedApoyo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ra_idRedApoyo")
    private Integer idRedApoyo;
    @Basic(optional = false)
    @Column(name = "ra_descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "redApoyo")
    private List<Entrevista> entrevistas;//mapeado por el campo idRedApoyo de Entrevista
    @JoinColumn(name = "ra_idTipoRedDeApoyo", referencedColumnName = "tra_idTipoRedDeApoyo")
    @ManyToOne
    private TipoRedApoyo tipoRedDeApoyo;

    public RedApoyo() {
    }

    public RedApoyo(Integer raidRedApoyo) {
        this.idRedApoyo = raidRedApoyo;
    }

    public RedApoyo(Integer raidRedApoyo, String raDescripcion) {
        this.idRedApoyo = raidRedApoyo;
        this.descripcion = raDescripcion;
    }

    public Integer getIdRedApoyo() {
        return idRedApoyo;
    }

    public void setIdRedApoyo(Integer idRedApoyo) {
        this.idRedApoyo = idRedApoyo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(List<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    public TipoRedApoyo getTipoRedDeApoyo() {
        return tipoRedDeApoyo;
    }

    public void setTipoRedDeApoyo(TipoRedApoyo tipoRedDeApoyo) {
        this.tipoRedDeApoyo = tipoRedDeApoyo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedApoyo != null ? idRedApoyo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedApoyo)) {
            return false;
        }
        RedApoyo other = (RedApoyo) object;
        if ((this.idRedApoyo == null && other.idRedApoyo != null) || (this.idRedApoyo != null && !this.idRedApoyo.equals(other.idRedApoyo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.RedApoyo[ raidRedApoyo=" + idRedApoyo + " ]";
    }
    
}
