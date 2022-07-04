/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.model;

import cr.ac.una.sidegi.model.dto.PersonaDto;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author computer
 */
@Entity
@Table(name = "sid_personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPerCedula", query = "SELECT p FROM Persona p WHERE p.perCedula = :perCedula"),
    @NamedQuery(name = "Persona.findByPerpApellido", query = "SELECT p FROM Persona p WHERE p.perpApellido = :perpApellido"),
    @NamedQuery(name = "Persona.findByPersApellido", query = "SELECT p FROM Persona p WHERE p.persApellido = :persApellido"),
    @NamedQuery(name = "Persona.findByPerNombre", query = "SELECT p FROM Persona p WHERE p.perNombre = :perNombre"),
    @NamedQuery(name = "Persona.findByPerfechaNac", query = "SELECT p FROM Persona p WHERE p.perfechaNac = :perfechaNac")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "per_cedula")
    private String perCedula;
    @Basic(optional = false)
    @Column(name = "per_pApellido")
    private String perpApellido;
    @Basic(optional = false)
    @Column(name = "per_sApellido")
    private String persApellido;
    @Basic(optional = false)
    @Column(name = "per_nombre")
    private String perNombre;
    @Basic(optional = false)
    @Column(name = "per_fechaNac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perfechaNac;
    @ManyToMany(mappedBy = "personas")
    private List<Contacto> contactos;
    @JoinColumn(name = "dir_idDireccion", referencedColumnName = "dir_idDireccion")
    @ManyToOne
    private Direccion diridDireccion;
    @JoinColumn(name = "esc_id", referencedColumnName = "esc_id")
    @ManyToOne
    private Escolaridad escId;
    @JoinColumn(name = "seg_id", referencedColumnName = "seg_id")
    @ManyToOne
    private TipoSeguro segId;
    @OneToMany(mappedBy = "perCedula")
    private List<Acompannante> acompannantes;
    @OneToMany(mappedBy = "perCedula")
    private List<Paciente> pacientes;

    public Persona() {
    }

    public Persona(String perCedula) {
        this.perCedula = perCedula;
    }

    public Persona(String perCedula, String perpApellido, String persApellido, String perNombre, Date perfechaNac) {
        this.perCedula = perCedula;
        this.perpApellido = perpApellido;
        this.persApellido = persApellido;
        this.perNombre = perNombre;
        this.perfechaNac = perfechaNac;
    }
    public Persona(PersonaDto personaDto) {
        this.perCedula= personaDto.getPerCedula();
        actualizarPersona(personaDto);
    }
    
    public void actualizarPersona(PersonaDto personaDto) {
        this.perCedula = personaDto.getPerCedula();
        this.perpApellido = personaDto.getPerPapellido();
        this.persApellido = personaDto.getPerSapellido();
        this.perNombre = personaDto.getPerNombre();
        this.perfechaNac =  Date.from(personaDto.getPerFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerpApellido() {
        return perpApellido;
    }

    public void setPerpApellido(String perpApellido) {
        this.perpApellido = perpApellido;
    }

    public String getPersApellido() {
        return persApellido;
    }

    public void setPersApellido(String persApellido) {
        this.persApellido = persApellido;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public Date getPerfechaNac() {
        return perfechaNac;
    }

    public void setPerfechaNac(Date perfechaNac) {
        this.perfechaNac = perfechaNac;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactos;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactos = contactoList;
    }

    public Direccion getDiridDireccion() {
        return diridDireccion;
    }

    public void setDiridDireccion(Direccion diridDireccion) {
        this.diridDireccion = diridDireccion;
    }

    public Escolaridad getEscId() {
        return escId;
    }

    public void setEscId(Escolaridad escId) {
        this.escId = escId;
    }

    public TipoSeguro getSegId() {
        return segId;
    }

    public void setSegId(TipoSeguro segId) {
        this.segId = segId;
    }

    @XmlTransient
    public List<Acompannante> getAcompannanteList() {
        return acompannantes;
    }

    public void setAcompannanteList(List<Acompannante> acompannanteList) {
        this.acompannantes = acompannanteList;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacientes;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacientes = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCedula != null ? perCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perCedula == null && other.perCedula != null) || (this.perCedula != null && !this.perCedula.equals(other.perCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Persona[ perCedula=" + perCedula + " ]";
    }
    
}
