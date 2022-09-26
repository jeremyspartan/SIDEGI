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
@Table(name = "sid_viviendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v"),
    @NamedQuery(name = "Vivienda.findByVividVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda"),
    @NamedQuery(name = "Vivienda.findByVivDescripcion", query = "SELECT v FROM Vivienda v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vivienda.findByVivisAcondicionada", query = "SELECT v FROM Vivienda v WHERE v.isAcondicionada = :isAcondicionada")})
public class Vivienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "viv_idVivienda")
    private Integer idVivienda;
    @Column(name = "viv_descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "viv_isAcondicionada")
    private String isAcondicionada;
    @OneToMany(mappedBy = "vivienda")
    private List<Entrevista> entrevistas;//mapeado por el campo idVivivienda de Entrevista

    public Vivienda() {
    }

    public Vivienda(Integer vividVivienda) {
        this.idVivienda = vividVivienda;
    }

    public Vivienda(Integer vividVivienda, String vivisAcondicionada) {
        this.idVivienda = vividVivienda;
        this.isAcondicionada = vivisAcondicionada;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIsAcondicionada() {
        return isAcondicionada;
    }

    public void setIsAcondicionada(String isAcondicionada) {
        this.isAcondicionada = isAcondicionada;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(List<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVivienda != null ? idVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.idVivienda == null && other.idVivienda != null) || (this.idVivienda != null && !this.idVivienda.equals(other.idVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Vivienda[ vividVivienda=" + idVivienda + " ]";
    }
    
}
