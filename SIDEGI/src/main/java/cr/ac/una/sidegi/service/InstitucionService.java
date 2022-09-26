/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Institucion;
import cr.ac.una.sidegi.model.dto.InstitucionDto;
import cr.ac.una.sidegi.util.EntityManagerHelper;
import cr.ac.una.sidegi.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author computer
 */
public class InstitucionService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(InstitucionService.class.getName());
    
    
    public Respuesta guardarInstitucion(InstitucionDto institucionDto) {
        try {
            Institucion institucion;
            if (institucionDto.getIdInstituicion()!= null && institucionDto.getIdInstituicion()> 0) {
                institucion = em.find(Institucion.class, institucionDto.getIdInstituicion());
                if (institucion == null) {
                    return new Respuesta(false, "No se encrontró la institucion a modificar.", "guardarInstitucion NoResultException");
                }
                institucion.actualizarInstitucion(institucionDto);
                institucion = em.merge(institucion);
            } else {
                institucion = new Institucion(institucionDto);
                em.persist(institucion);
            }
            em.flush();
            return new Respuesta(true, "", "", "Institucion", new InstitucionDto(institucion));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la institucion.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar la institucion.", "guardarInstitucion " + ex.getMessage());
        }
    }
}