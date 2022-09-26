/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Direccion;
import cr.ac.una.sidegi.model.dto.DireccionDto;
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
public class DireccionService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(InstitucionService.class.getName());
    
    
    public Respuesta guardarDireccion(DireccionDto direccionDto) {
        try {
            Direccion direccion;
            if (direccionDto.getIdDireccion()!= null && direccionDto.getIdDireccion()> 0) {
                direccion = em.find(Direccion.class, direccionDto.getIdDireccion());
                if (direccion == null) {
                    return new Respuesta(false, "No se encrontró la direccion a modificar.", "guardarDireccion NoResultException");
                }
                direccion.actualizarDireccion(direccionDto);
                direccion = em.merge(direccion);
            } else {
                direccion = new Direccion(direccionDto);
                em.persist(direccion);
            }
            em.flush();
            return new Respuesta(true, "", "", "Direccion", new DireccionDto(direccion));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la direccion.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar la direccion.", "guardarDireccion " + ex.getMessage());
        }
    }
}
