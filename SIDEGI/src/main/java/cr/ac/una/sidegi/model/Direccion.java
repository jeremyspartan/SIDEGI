/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "sid_direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByDiridDireccion", query = "SELECT d FROM Direccion d WHERE d.diridDireccion = :diridDireccion"),
    @NamedQuery(name = "Direccion.findByDirdescDireccion", query = "SELECT d FROM Direccion d WHERE d.dirdescDireccion = :dirdescDireccion")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "dir_idDireccion")
    private BigDecimal diridDireccion;
    @Basic(optional = false)
    @Column(name = "dir_descDireccion")
    private String dirdescDireccion;
    @OneToMany(mappedBy = "diridDireccion")
    private List<Persona> personaList;

    public Direccion() {
    }

    public Direccion(BigDecimal diridDireccion) {
        this.diridDireccion = diridDireccion;
    }

    public Direccion(BigDecimal diridDireccion, String dirdescDireccion) {
        this.diridDireccion = diridDireccion;
        this.dirdescDireccion = dirdescDireccion;
    }

    public BigDecimal getDiridDireccion() {
        return diridDireccion;
    }

    public void setDiridDireccion(BigDecimal diridDireccion) {
        this.diridDireccion = diridDireccion;
    }

    public String getDirdescDireccion() {
        return dirdescDireccion;
    }

    public void setDirdescDireccion(String dirdescDireccion) {
        this.dirdescDireccion = dirdescDireccion;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diridDireccion != null ? diridDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.diridDireccion == null && other.diridDireccion != null) || (this.diridDireccion != null && !this.diridDireccion.equals(other.diridDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Direccion[ diridDireccion=" + diridDireccion + " ]";
    }
    
}
