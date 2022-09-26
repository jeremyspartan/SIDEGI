/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Anexo.findByAneidAnexo", query = "SELECT a FROM Anexo a WHERE a.idAnexo = :idAnexo")})
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ane_idAnexo")
    private Integer idAnexo;
    @Basic(optional = false)
    @Lob
    @Column(name = "ane_documento")
    private byte[] documento;
    @JoinColumn(name = "ane_idPaciente", referencedColumnName = "pac_idPaciente")
    @ManyToOne
    private Paciente idPaciente;
    @JoinColumn(name = "ane_idTipoDocumento", referencedColumnName = "tdo_idTipoDocumento")
    @ManyToOne
    private TipoDocumento tipoDocumento;

    public Anexo() {
    }

    public Anexo(Integer aneidAnexo) {
        this.idAnexo = aneidAnexo;
    }

    public Anexo(Integer aneidAnexo, byte[] aneDocumento) {
        this.idAnexo = aneidAnexo;
        this.documento = aneDocumento;
    }

    public Integer getIdAnexo() {
        return idAnexo;
    }

    public void setIdAnexo(Integer idAnexo) {
        this.idAnexo = idAnexo;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnexo != null ? idAnexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anexo)) {
            return false;
        }
        Anexo other = (Anexo) object;
        if ((this.idAnexo == null && other.idAnexo != null) || (this.idAnexo != null && !this.idAnexo.equals(other.idAnexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Anexo[ aneidAnexo=" + idAnexo + " ]";
    }
    
}
