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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @NamedQuery(name = "Persona.findByPerCedula", query = "SELECT p FROM Persona p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Persona.findByPerpApellido", query = "SELECT p FROM Persona p WHERE p.pApellido = :pApellido"),
    @NamedQuery(name = "Persona.findByPersApellido", query = "SELECT p FROM Persona p WHERE p.sApellido = :sApellido"),
    @NamedQuery(name = "Persona.findByPerNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByPerfechaNac", query = "SELECT p FROM Persona p WHERE p.fechaNac = :fechaNac")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "per_cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "per_pApellido")
    private String pApellido;
    @Basic(optional = false)
    @Column(name = "per_sApellido")
    private String sApellido;
    @Basic(optional = false)
    @Column(name = "per_nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "per_fechaNac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @JoinTable(name = "sid_personacontactos", joinColumns = {
        @JoinColumn(name = "pxc_cedula", referencedColumnName = "per_cedula")}, inverseJoinColumns = {
        @JoinColumn(name = "pxc_idContacto", referencedColumnName = "con_idContacto")})
    @ManyToMany
    private List<Contacto> contactos;
    @JoinColumn(name = "per_idDireccion", referencedColumnName = "dir_idDireccion")
    @ManyToOne
    private Direccion direccion;
    @JoinColumn(name = "per_idEscolaridad", referencedColumnName = "esc_idEscolaridad")
    @ManyToOne
    private Escolaridad escolaridad;
    @JoinColumn(name = "per_idTipoSeguro", referencedColumnName = "seg_idTipoSeguro")
    @ManyToOne
    private TipoSeguro tipoSeguro;
    @OneToMany(mappedBy = "cedula")
    private List<Acompannante> acompannantes;//mapeado por el campo cedula de Acompañante
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Usuario> usuarios;//mapeado por el campo cedula de Usuario
    @OneToMany(mappedBy = "persona")
    private List<Paciente> pacientes;//mapeado por el campo cedula de Paciente

    public Persona() {
    }
    
    public Persona(PersonaDto personaDto) {
        this.cedula= personaDto.getCedula();
        actualizarPersona(personaDto);
    }
    
    public void actualizarPersona(PersonaDto personaDto) {
        this.cedula = personaDto.getCedula();
        this.pApellido = personaDto.getPapellido();
        this.sApellido = personaDto.getSapellido();
        this.nombre = personaDto.getNombre();
        this.fechaNac =  Date.from(personaDto.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public Persona(String perCedula) {
        this.cedula = perCedula;
    }

    public Persona(String perCedula, String perpApellido, String persApellido, String perNombre, Date perfechaNac) {
        this.cedula = perCedula;
        this.pApellido = perpApellido;
        this.sApellido = persApellido;
        this.nombre = perNombre;
        this.fechaNac = perfechaNac;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @XmlTransient
    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Escolaridad getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(Escolaridad escolaridad) {
        this.escolaridad = escolaridad;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    @XmlTransient
    public List<Acompannante> getAcompannantes() {
        return acompannantes;
    }

    public void setAcompannantes(List<Acompannante> acompannantes) {
        this.acompannantes = acompannantes;
    }

    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.sidegi.model.Persona[ perCedula=" + cedula + " ]";
    }
    
}
