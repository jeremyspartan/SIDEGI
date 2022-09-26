/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.DireccionDto;
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
@Table(name = "sid_direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByDiridDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "Direccion.findByDirdescDireccion", query = "SELECT d FROM Direccion d WHERE d.descDireccion = :descDireccion")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dir_idDireccion")
    private Integer idDireccion;
    @Basic(optional = false)
    @Column(name = "dir_descDireccion")
    private String descDireccion;
    @OneToMany(mappedBy = "direccion")//mapeado por el campo idDirecccion de persona
    private List<Persona> personas;
    @JoinColumn(name = "dir_idCanton", referencedColumnName = "can_idCanton")
    @ManyToOne(optional = false)
    private Canton canton;
    @JoinColumn(name = "dir_idDistrito", referencedColumnName = "dist_idDistrito")
    @ManyToOne(optional = false)
    private Distrito distrito;
    @JoinColumn(name = "dir_idProvincia", referencedColumnName = "pro_idProvincia")
    @ManyToOne(optional = false)
    private Provincia provincia;

    public Direccion() {
    }

    public Direccion(DireccionDto direccionDto) {
        actualizarDireccion(direccionDto);
    }
     
    public void actualizarDireccion(DireccionDto direccionDto){
        this.idDireccion = direccionDto.getIdDireccion();
        this.descDireccion = direccionDto.getDescDireccion();
    }
    
    public Direccion(Integer diridDireccion) {
        this.idDireccion = diridDireccion;
    }

    public Direccion(Integer diridDireccion, String dirdescDireccion) {
        this.idDireccion = diridDireccion;
        this.descDireccion = dirdescDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDescDireccion() {
        return descDireccion;
    }

    public void setDescDireccion(String descDireccion) {
        this.descDireccion = descDireccion;
    }

    @XmlTransient
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Direccion[ diridDireccion=" + idDireccion + " ]";
    }
    
}
