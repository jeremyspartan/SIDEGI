/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Direccion;
import cr.ac.una.sidegi.model.TipoSeguro;
import cr.ac.una.sidegi.model.dto.DireccionDto;
import cr.ac.una.sidegi.model.dto.TipoSeguroDto;
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
public class TipoSeguroService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(InstitucionService.class.getName());
    
    
    public Respuesta guardarTipoSeguro(TipoSeguroDto tipoSeguroDto) {
        try {
            TipoSeguro tipoSeguro;
            if (tipoSeguroDto.getIdTipoSeguro()!= null && tipoSeguroDto.getIdTipoSeguro()> 0) {
                tipoSeguro = em.find(TipoSeguro.class, tipoSeguroDto.getIdTipoSeguro());
                if (tipoSeguro == null) {
                    return new Respuesta(false, "No se encrontró el tipo de seguro a modificar.", "guardarTipoSeguro NoResultException");
                }
                tipoSeguro.actualizarTipoSeguro(tipoSeguroDto);
                tipoSeguro = em.merge(tipoSeguro);
            } else {
                tipoSeguro = new TipoSeguro(tipoSeguroDto);
                em.persist(tipoSeguro);
            }
            em.flush();
            return new Respuesta(true, "", "", "TipoSeguro", new TipoSeguroDto(tipoSeguro));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el tipo seguro.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el tipo seguro.", "guardarTipoSeguro " + ex.getMessage());
        }
    }
}
