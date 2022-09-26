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
@Table(name = "sid_ingresoseconomicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoEconomico.findAll", query = "SELECT i FROM IngresoEconomico i"),
    @NamedQuery(name = "IngresoEconomico.findByIngidIngresoEconomico", query = "SELECT i FROM IngresoEconomico i WHERE i.idIngresoEconomico = :idIngresoEconomico"),
    @NamedQuery(name = "IngresoEconomico.findByIngcantGrupoFam", query = "SELECT i FROM IngresoEconomico i WHERE i.cantGrupoFam = :cantGrupoFam"),
    @NamedQuery(name = "IngresoEconomico.findByIngcantPerIngre", query = "SELECT i FROM IngresoEconomico i WHERE i.cantPerIngre = :cantPerIngre"),
    @NamedQuery(name = "IngresoEconomico.findByIngcantIngresos", query = "SELECT i FROM IngresoEconomico i WHERE i.cantIngresos = :cantIngresos"),
    @NamedQuery(name = "IngresoEconomico.findByIngperCapita", query = "SELECT i FROM IngresoEconomico i WHERE i.ingPerCapita = :ingPerCapita")})
public class IngresoEconomico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ing_idIngresoEconomico")
    private Integer idIngresoEconomico;
    @Basic(optional = false)
    @Column(name = "ing_cantGrupoFam")
    private float cantGrupoFam;
    @Basic(optional = false)
    @Column(name = "ing_cantPerIngre")
    private float cantPerIngre;
    @Basic(optional = false)
    @Column(name = "ing_cantIngresos")
    private float cantIngresos;
    @Basic(optional = false)
    @Column(name = "ing_perCapita")
    private float ingPerCapita;
    @OneToMany(mappedBy = "IngresoEconomico")
    private List<Entrevista> entrevistas;//mapeado por el campo idIngresoEconomico de Entrevista
    @JoinColumn(name = "ing_idSituacionEconomica", referencedColumnName = "se_idSituacionEconomica")
    @ManyToOne
    private SituacionEconomica situacionEconomica;

    public IngresoEconomico() {
    }

    public IngresoEconomico(Integer ingidIngresoEconomico) {
        this.idIngresoEconomico = ingidIngresoEconomico;
    }

    public IngresoEconomico(Integer ingidIngresoEconomico, float ingcantGrupoFam, float ingcantPerIngre, float ingcantIngresos, float ingperCapita) {
        this.idIngresoEconomico = ingidIngresoEconomico;
        this.cantGrupoFam = ingcantGrupoFam;
        this.cantPerIngre = ingcantPerIngre;
        this.cantIngresos = ingcantIngresos;
        this.ingPerCapita = ingperCapita;
    }

    public Integer getIdIngresoEconomico() {
        return idIngresoEconomico;
    }

    public void setIdIngresoEconomico(Integer idIngresoEconomico) {
        this.idIngresoEconomico = idIngresoEconomico;
    }

    public float getCantGrupoFam() {
        return cantGrupoFam;
    }

    public void setCantGrupoFam(float cantGrupoFam) {
        this.cantGrupoFam = cantGrupoFam;
    }

    public float getCantPerIngre() {
        return cantPerIngre;
    }

    public void setCantPerIngre(float cantPerIngre) {
        this.cantPerIngre = cantPerIngre;
    }

    public float getCantIngresos() {
        return cantIngresos;
    }

    public void setCantIngresos(float cantIngresos) {
        this.cantIngresos = cantIngresos;
    }

    public float getIngPerCapita() {
        return ingPerCapita;
    }

    public void setIngPerCapita(float ingPerCapita) {
        this.ingPerCapita = ingPerCapita;
    }

    @XmlTransient
    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(List<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    public SituacionEconomica getSituacionEconomica() {
        return situacionEconomica;
    }

    public void setSituacionEconomica(SituacionEconomica situacionEconomica) {
        this.situacionEconomica = situacionEconomica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoEconomico != null ? idIngresoEconomico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoEconomico)) {
            return false;
        }
        IngresoEconomico other = (IngresoEconomico) object;
        if ((this.idIngresoEconomico == null && other.idIngresoEconomico != null) || (this.idIngresoEconomico != null && !this.idIngresoEconomico.equals(other.idIngresoEconomico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.IngresoEconomico[ ingidIngresoEconomico=" + idIngresoEconomico + " ]";
    }
    
}
