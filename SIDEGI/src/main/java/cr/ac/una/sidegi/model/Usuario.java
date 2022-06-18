/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuidUsuario", query = "SELECT u FROM Usuario u WHERE u.usuidUsuario = :usuidUsuario"),
    @NamedQuery(name = "Usuario.findByUsunombreUsuario", query = "SELECT u FROM Usuario u WHERE u.usunombreUsuario = :usunombreUsuario"),
    @NamedQuery(name = "Usuario.findByUsuContrasenna", query = "SELECT u FROM Usuario u WHERE u.usuContrasenna = :usuContrasenna")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "usu_idUsuario")
    private Long usuidUsuario;
    @Basic(optional = false)
    @Column(name = "usu_nombreUsuario")
    private String usunombreUsuario;
    @Basic(optional = false)
    @Column(name = "usu_contrasenna")
    private String usuContrasenna;

    public Usuario() {
    }

    public Usuario(Long usuidUsuario) {
        this.usuidUsuario = usuidUsuario;
    }

    public Usuario(Long usuidUsuario, String usunombreUsuario, String usuContrasenna) {
        this.usuidUsuario = usuidUsuario;
        this.usunombreUsuario = usunombreUsuario;
        this.usuContrasenna = usuContrasenna;
    }

    public Long getUsuidUsuario() {
        return usuidUsuario;
    }

    public void setUsuidUsuario(Long usuidUsuario) {
        this.usuidUsuario = usuidUsuario;
    }

    public String getUsunombreUsuario() {
        return usunombreUsuario;
    }

    public void setUsunombreUsuario(String usunombreUsuario) {
        this.usunombreUsuario = usunombreUsuario;
    }

    public String getUsuContrasenna() {
        return usuContrasenna;
    }

    public void setUsuContrasenna(String usuContrasenna) {
        this.usuContrasenna = usuContrasenna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuidUsuario != null ? usuidUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuidUsuario == null && other.usuidUsuario != null) || (this.usuidUsuario != null && !this.usuidUsuario.equals(other.usuidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Usuario[ usuidUsuario=" + usuidUsuario + " ]";
    }
    
}
