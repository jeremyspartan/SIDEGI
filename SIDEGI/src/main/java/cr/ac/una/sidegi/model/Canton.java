/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "sid_cantones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cantone.findAll", query = "SELECT c FROM Canton c"),
    @NamedQuery(name = "Cantone.findByCanidCanton", query = "SELECT c FROM Canton c WHERE c.idCanton = :idCanton"),
    @NamedQuery(name = "Cantone.findByCanCanton", query = "SELECT c FROM Canton c WHERE c.canton = :canton")})
public class Canton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "can_idCanton")
    private Integer idCanton;
    @Basic(optional = false)
    @Column(name = "can_canton")
    private String canton;
    @JoinColumn(name = "can_idProvincia", referencedColumnName = "pro_idProvincia")
    @ManyToOne(optional = false)
    private Provincia provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canton")//Mapeado por el campo idCanton de distrito
    private List<Distrito> distritos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canton")//Mapeado por el campo idCanton de direccion
    private List<Direccion> direcciones;

    public Canton() {
    }

    public Canton(Integer canidCanton) {
        this.idCanton = canidCanton;
    }

    public Canton(Integer canidCanton, String canCanton) {
        this.idCanton = canidCanton;
        this.canton = canCanton;
    }

    public Integer getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Integer idCanton) {
        this.idCanton = idCanton;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

    @XmlTransient
    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCanton != null ? idCanton.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canton)) {
            return false;
        }
        Canton other = (Canton) object;
        if ((this.idCanton == null && other.idCanton != null) || (this.idCanton != null && !this.idCanton.equals(other.idCanton))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Cantone[ canidCanton=" + idCanton + " ]";
    }
    
}
