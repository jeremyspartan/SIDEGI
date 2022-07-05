/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Contacto;
import cr.ac.una.sidegi.model.dto.ContactoDto;
import cr.ac.una.sidegi.util.EntityManagerHelper;
import cr.ac.una.sidegi.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author computer
 */
public class ContactoService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(ContactoService.class.getName());
    
    
    public Respuesta guardarContacto(ContactoDto contactoDto) {
        try {
            Contacto contacto;
            if (contactoDto.getConIdContacto()!= null && contactoDto.getConIdContacto()> 0) {
                contacto = em.find(Contacto.class, contactoDto.getConIdContacto());
                if (contacto == null) {
                    return new Respuesta(false, "No se encrontró el contaco a modificar.", "guardarContacto NoResultException");
                }
                contacto.ActualizarContacto(contactoDto);
                contacto = em.merge(contacto);
            } else {
                contacto = new Contacto(contactoDto);
                em.persist(contacto);
            }
            em.flush();
            return new Respuesta(true, "", "", "Contacto", new ContactoDto(contacto));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el contacto.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el contacto.", "guardarContacto " + ex.getMessage());
        }
    }
}
