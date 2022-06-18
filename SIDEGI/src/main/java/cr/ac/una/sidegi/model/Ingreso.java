/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sid_ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByIngId", query = "SELECT i FROM Ingreso i WHERE i.ingId = :ingId"),
    @NamedQuery(name = "Ingreso.findByIngcantGrupoFam", query = "SELECT i FROM Ingreso i WHERE i.ingcantGrupoFam = :ingcantGrupoFam"),
    @NamedQuery(name = "Ingreso.findByIngcantPerIngre", query = "SELECT i FROM Ingreso i WHERE i.ingcantPerIngre = :ingcantPerIngre"),
    @NamedQuery(name = "Ingreso.findByIngcantIngresos", query = "SELECT i FROM Ingreso i WHERE i.ingcantIngresos = :ingcantIngresos"),
    @NamedQuery(name = "Ingreso.findByIngperCapita", query = "SELECT i FROM Ingreso i WHERE i.ingperCapita = :ingperCapita")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ing_id")
    private BigDecimal ingId;
    @Basic(optional = false)
    @Column(name = "ing_cantGrupoFam")
    private BigInteger ingcantGrupoFam;
    @Basic(optional = false)
    @Column(name = "ing_cantPerIngre")
    private BigInteger ingcantPerIngre;
    @Basic(optional = false)
    @Column(name = "ing_cantIngresos")
    private double ingcantIngresos;
    @Basic(optional = false)
    @Column(name = "ing_perCapita")
    private double ingperCapita;
    @JoinColumn(name = "se_id", referencedColumnName = "se_id")
    @ManyToOne
    private SituacionEconomica seId;
    @OneToMany(mappedBy = "ingId")
    private List<Entrevista> entrevistaList;

    public Ingreso() {
    }

    public Ingreso(BigDecimal ingId) {
        this.ingId = ingId;
    }

    public Ingreso(BigDecimal ingId, BigInteger ingcantGrupoFam, BigInteger ingcantPerIngre, double ingcantIngresos, double ingperCapita) {
        this.ingId = ingId;
        this.ingcantGrupoFam = ingcantGrupoFam;
        this.ingcantPerIngre = ingcantPerIngre;
        this.ingcantIngresos = ingcantIngresos;
        this.ingperCapita = ingperCapita;
    }

    public BigDecimal getIngId() {
        return ingId;
    }

    public void setIngId(BigDecimal ingId) {
        this.ingId = ingId;
    }

    public BigInteger getIngcantGrupoFam() {
        return ingcantGrupoFam;
    }

    public void setIngcantGrupoFam(BigInteger ingcantGrupoFam) {
        this.ingcantGrupoFam = ingcantGrupoFam;
    }

    public BigInteger getIngcantPerIngre() {
        return ingcantPerIngre;
    }

    public void setIngcantPerIngre(BigInteger ingcantPerIngre) {
        this.ingcantPerIngre = ingcantPerIngre;
    }

    public double getIngcantIngresos() {
        return ingcantIngresos;
    }

    public void setIngcantIngresos(double ingcantIngresos) {
        this.ingcantIngresos = ingcantIngresos;
    }

    public double getIngperCapita() {
        return ingperCapita;
    }

    public void setIngperCapita(double ingperCapita) {
        this.ingperCapita = ingperCapita;
    }

    public SituacionEconomica getSeId() {
        return seId;
    }

    public void setSeId(SituacionEconomica seId) {
        this.seId = seId;
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
        hash += (ingId != null ? ingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.ingId == null && other.ingId != null) || (this.ingId != null && !this.ingId.equals(other.ingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Ingreso[ ingId=" + ingId + " ]";
    }
    
}
