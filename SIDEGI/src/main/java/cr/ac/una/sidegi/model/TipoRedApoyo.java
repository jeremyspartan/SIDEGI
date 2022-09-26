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
@Table(name = "sid_tiporedapoyos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRedApoyo.findAll", query = "SELECT t FROM TipoRedApoyo t"),
    @NamedQuery(name = "TipoRedApoyo.findByTraidTipoRedDeApoyo", query = "SELECT t FROM TipoRedApoyo t WHERE t.idTipoRedDeApoyo = :idTipoRedDeApoyo"),
    @NamedQuery(name = "TipoRedApoyo.findByTraTipo", query = "SELECT t FROM TipoRedApoyo t WHERE t.tipo = :tipo")})
public class TipoRedApoyo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tra_idTipoRedDeApoyo")
    private Integer idTipoRedDeApoyo;
    @Basic(optional = false)
    @Column(name = "tra_tipo")
    private String tipo;
    @OneToMany(mappedBy = "tipoRedDeApoyo")
    private List<RedApoyo> redesDeApoyo;//mapeado por el campo idTipoRedDeApoyo de RedApoyo

    public TipoRedApoyo() {
    }

    public TipoRedApoyo(Integer traidTipoRedDeApoyo) {
        this.idTipoRedDeApoyo = traidTipoRedDeApoyo;
    }

    public TipoRedApoyo(Integer traidTipoRedDeApoyo, String traTipo) {
        this.idTipoRedDeApoyo = traidTipoRedDeApoyo;
        this.tipo = traTipo;
    }

    public Integer getIdTipoRedDeApoyo() {
        return idTipoRedDeApoyo;
    }

    public void setIdTipoRedDeApoyo(Integer idTipoRedDeApoyo) {
        this.idTipoRedDeApoyo = idTipoRedDeApoyo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<RedApoyo> getRedesDeApoyo() {
        return redesDeApoyo;
    }

    public void setRedesDeApoyo(List<RedApoyo> redesDeApoyo) {
        this.redesDeApoyo = redesDeApoyo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRedDeApoyo != null ? idTipoRedDeApoyo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRedApoyo)) {
            return false;
        }
        TipoRedApoyo other = (TipoRedApoyo) object;
        if ((this.idTipoRedDeApoyo == null && other.idTipoRedDeApoyo != null) || (this.idTipoRedDeApoyo != null && !this.idTipoRedDeApoyo.equals(other.idTipoRedDeApoyo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoRedApoyo[ traidTipoRedDeApoyo=" + idTipoRedDeApoyo + " ]";
    }
    
}
