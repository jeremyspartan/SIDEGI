/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.TipoContacto;
import cr.ac.una.sidegi.model.dto.TipoContactoDto;
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
public class TipoContactoService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(TipoContactoService.class.getName());
    
    
    public Respuesta guardarTipoContacto(TipoContactoDto tipoContactoDto) {
        try {
            TipoContacto tipoContacto;
            if (tipoContactoDto.getTpcidTipoContacto()!= null && tipoContactoDto.getTpcidTipoContacto()> 0) {
                tipoContacto = em.find(TipoContacto.class, tipoContactoDto.getTpcidTipoContacto());
                if (tipoContacto == null) {
                    return new Respuesta(false, "No se encrontró el tipo de contacto a modificar.", "guardarTipoContacto NoResultException");
                }
                tipoContacto.actualizarTipoContacto(tipoContactoDto);
                tipoContacto = em.merge(tipoContacto);
            } else {
                tipoContacto = new TipoContacto(tipoContactoDto);
                em.persist(tipoContacto);
            }
            em.flush();
            return new Respuesta(true, "", "", "TipoContacto", new TipoContactoDto(tipoContacto));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el tipo de contacto.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el tipo de contacto.", "guardarTipoContacto " + ex.getMessage());
        }
    }
}
