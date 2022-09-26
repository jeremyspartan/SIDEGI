/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Escolaridad;
import cr.ac.una.sidegi.model.dto.EscolaridadDto;
import cr.ac.una.sidegi.util.EntityManagerHelper;
import cr.ac.una.sidegi.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Usuario
 */
public class EscolaridadService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(InstitucionService.class.getName());
    
    
    public Respuesta guardarEscolaridad(EscolaridadDto escolaridadDto) {
        try {
            Escolaridad direccion;
            if (escolaridadDto.getIdEscolaridad()!= null && escolaridadDto.getIdEscolaridad()> 0) {
                direccion = em.find(Escolaridad.class, escolaridadDto.getIdEscolaridad());
                if (direccion == null) {
                    return new Respuesta(false, "No se encrontró la escolaridad a modificar.", "guardarEscolaridad NoResultException");
                }
                direccion.actualizarEscolaridad(escolaridadDto);
                direccion = em.merge(direccion);
            } else {
                direccion = new Escolaridad(escolaridadDto);
                em.persist(direccion);
            }
            em.flush();
            return new Respuesta(true, "", "", "Escolaridad", new EscolaridadDto(direccion));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la escolaridad.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar la escolaridad.", "guardarEscolaridad " + ex.getMessage());
        }
    }
}
