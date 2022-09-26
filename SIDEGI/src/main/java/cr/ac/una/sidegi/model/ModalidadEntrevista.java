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
@Table(name = "sid_modalidadesentrevista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadEntrevista.findAll", query = "SELECT m FROM ModalidadEntrevista m"),
    @NamedQuery(name = "ModalidadEntrevista.findByMeidModalidadEntrevista", query = "SELECT m FROM ModalidadEntrevista m WHERE m.idModalidadEntrevista = :idModalidadEntrevista"),
    @NamedQuery(name = "ModalidadEntrevista.findByMeModalidad", query = "SELECT m FROM ModalidadEntrevista m WHERE m.modalidad = :modalidad")})
public class ModalidadEntrevista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "me_idModalidadEntrevista")
    private Integer idModalidadEntrevista;
    @Basic(optional = false)
    @Column(name = "me_modalidad")
    private String modalidad;
    @OneToMany(mappedBy = "modalidadEntrevista")
    private List<Entrevista> entrevistas;

    public ModalidadEntrevista() {
    }

    public ModalidadEntrevista(Integer meidModalidadEntrevista) {
        this.idModalidadEntrevista = meidModalidadEntrevista;
    }

    public ModalidadEntrevista(Integer meidModalidadEntrevista, String meModalidad) {
        this.idModalidadEntrevista = meidModalidadEntrevista;
        this.modalidad = meModalidad;
    }

    public Integer getIdModalidadEntrevista() {
        return idModalidadEntrevista;
    }

    public void setIdModalidadEntrevista(Integer idModalidadEntrevista) {
        this.idModalidadEntrevista = idModalidadEntrevista;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
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
        hash += (idModalidadEntrevista != null ? idModalidadEntrevista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadEntrevista)) {
            return false;
        }
        ModalidadEntrevista other = (ModalidadEntrevista) object;
        if ((this.idModalidadEntrevista == null && other.idModalidadEntrevista != null) || (this.idModalidadEntrevista != null && !this.idModalidadEntrevista.equals(other.idModalidadEntrevista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.ModalidadEntrevista[ meidModalidadEntrevista=" + idModalidadEntrevista + " ]";
    }
    
}
