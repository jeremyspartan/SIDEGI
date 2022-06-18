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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_anexos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anexo.findAll", query = "SELECT a FROM Anexo a"),
    @NamedQuery(name = "Anexo.findByAneidAnexo", query = "SELECT a FROM Anexo a WHERE a.aneidAnexo = :aneidAnexo")})
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ane_idAnexo")
    private Long aneidAnexo;
    @Basic(optional = false)
    @Lob
    @Column(name = "ane_documento")
    private byte[] aneDocumento;
    @JoinColumn(name = "pac_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente pacidPaciente;
    @JoinColumn(name = "tdo_idTipoDocumento", referencedColumnName = "tdo_idTipoDocumento")
    @ManyToOne
    private TipoDocumento tdoidTipoDocumento;

    public Anexo() {
    }

    public Anexo(Long aneidAnexo) {
        this.aneidAnexo = aneidAnexo;
    }

    public Anexo(Long aneidAnexo, byte[] aneDocumento) {
        this.aneidAnexo = aneidAnexo;
        this.aneDocumento = aneDocumento;
    }

    public Long getAneidAnexo() {
        return aneidAnexo;
    }

    public void setAneidAnexo(Long aneidAnexo) {
        this.aneidAnexo = aneidAnexo;
    }

    public byte[] getAneDocumento() {
        return aneDocumento;
    }

    public void setAneDocumento(byte[] aneDocumento) {
        this.aneDocumento = aneDocumento;
    }

    public Paciente getPacidPaciente() {
        return pacidPaciente;
    }

    public void setPacidPaciente(Paciente pacidPaciente) {
        this.pacidPaciente = pacidPaciente;
    }

    public TipoDocumento getTdoidTipoDocumento() {
        return tdoidTipoDocumento;
    }

    public void setTdoidTipoDocumento(TipoDocumento tdoidTipoDocumento) {
        this.tdoidTipoDocumento = tdoidTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aneidAnexo != null ? aneidAnexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anexo)) {
            return false;
        }
        Anexo other = (Anexo) object;
        if ((this.aneidAnexo == null && other.aneidAnexo != null) || (this.aneidAnexo != null && !this.aneidAnexo.equals(other.aneidAnexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Anexo[ aneidAnexo=" + aneidAnexo + " ]";
    }
    
}
