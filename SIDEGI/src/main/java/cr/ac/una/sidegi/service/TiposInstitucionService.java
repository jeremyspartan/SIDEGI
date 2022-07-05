/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.TiposInstitucion;
import cr.ac.una.sidegi.model.dto.TiposInstitucionDto;
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
public class TiposInstitucionService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(TiposInstitucionService.class.getName());
    
    
    public Respuesta guardarTipoInstitucion(TiposInstitucionDto tipoInstitucionDto) {
        try {
            TiposInstitucion tipoInstitucion;
            if (tipoInstitucionDto.getTinsId()!= null && tipoInstitucionDto.getTinsId()> 0) {
                tipoInstitucion = em.find(TiposInstitucion.class, tipoInstitucionDto.getTinsId());
                if (tipoInstitucion == null) {
                    return new Respuesta(false, "No se encrontró el tipo de institucion a modificar", "guardarTipoInstitucion NoResultException");
                }
                tipoInstitucion.actualizarTiposInstitucion(tipoInstitucionDto);
                tipoInstitucion = em.merge(tipoInstitucion);
            } else {
                tipoInstitucion = new TiposInstitucion(tipoInstitucionDto);
                em.persist(tipoInstitucion);
            }
            em.flush();
            return new Respuesta(true, "", "", "TipoInstitucion", new TiposInstitucionDto(tipoInstitucion));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el tipo de institucion.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el tipo de institucion.", "guardarMesa " + ex.getMessage());
        }
    }
}
