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
@Table(name = "sid_tipodocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByTdoidTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.tdoidTipoDocumento = :tdoidTipoDocumento"),
    @NamedQuery(name = "TipoDocumento.findByTdoDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.tdoDescripcion = :tdoDescripcion")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tdo_idTipoDocumento")
    private Long tdoidTipoDocumento;
    @Basic(optional = false)
    @Column(name = "tdo_descripcion")
    private String tdoDescripcion;
    @OneToMany(mappedBy = "tdoidTipoDocumento")
    private List<Anexo> anexoList;

    public TipoDocumento() {
    }

    public TipoDocumento(Long tdoidTipoDocumento) {
        this.tdoidTipoDocumento = tdoidTipoDocumento;
    }

    public TipoDocumento(Long tdoidTipoDocumento, String tdoDescripcion) {
        this.tdoidTipoDocumento = tdoidTipoDocumento;
        this.tdoDescripcion = tdoDescripcion;
    }

    public Long getTdoidTipoDocumento() {
        return tdoidTipoDocumento;
    }

    public void setTdoidTipoDocumento(Long tdoidTipoDocumento) {
        this.tdoidTipoDocumento = tdoidTipoDocumento;
    }

    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    @XmlTransient
    public List<Anexo> getAnexoList() {
        return anexoList;
    }

    public void setAnexoList(List<Anexo> anexoList) {
        this.anexoList = anexoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdoidTipoDocumento != null ? tdoidTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tdoidTipoDocumento == null && other.tdoidTipoDocumento != null) || (this.tdoidTipoDocumento != null && !this.tdoidTipoDocumento.equals(other.tdoidTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.TipoDocumento[ tdoidTipoDocumento=" + tdoidTipoDocumento + " ]";
    }
    
}
