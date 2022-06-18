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
@Table(name = "sid_viviendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v"),
    @NamedQuery(name = "Vivienda.findByVivId", query = "SELECT v FROM Vivienda v WHERE v.vivId = :vivId"),
    @NamedQuery(name = "Vivienda.findByVivDescripcion", query = "SELECT v FROM Vivienda v WHERE v.vivDescripcion = :vivDescripcion"),
    @NamedQuery(name = "Vivienda.findByVivisAcondicionada", query = "SELECT v FROM Vivienda v WHERE v.vivisAcondicionada = :vivisAcondicionada")})
public class Vivienda implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "viv_id")
    private Long vivId;
    @Column(name = "viv_descripcion")
    private String vivDescripcion;
    @Basic(optional = false)
    @Column(name = "viv_isAcondicionada")
    private String vivisAcondicionada;
    @OneToMany(mappedBy = "vivId")
    private List<Entrevista> entrevistaList;

    public Vivienda() {
    }

    public Vivienda(Long vivId) {
        this.vivId = vivId;
    }

    public Vivienda(Long vivId, String vivisAcondicionada) {
        this.vivId = vivId;
        this.vivisAcondicionada = vivisAcondicionada;
    }

    public Long getVivId() {
        return vivId;
    }

    public void setVivId(Long vivId) {
        this.vivId = vivId;
    }

    public String getVivDescripcion() {
        return vivDescripcion;
    }

    public void setVivDescripcion(String vivDescripcion) {
        this.vivDescripcion = vivDescripcion;
    }

    public String getVivisAcondicionada() {
        return vivisAcondicionada;
    }

    public void setVivisAcondicionada(String vivisAcondicionada) {
        this.vivisAcondicionada = vivisAcondicionada;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistaList() {
        return entrevistaList;
    }

    public void setEntrevistaList(List<Entrevista> entrevistaList) {
        this.entrevistaList = entrevistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vivId != null ? vivId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.vivId == null && other.vivId != null) || (this.vivId != null && !this.vivId.equals(other.vivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Vivienda[ vivId=" + vivId + " ]";
    }
    
}
