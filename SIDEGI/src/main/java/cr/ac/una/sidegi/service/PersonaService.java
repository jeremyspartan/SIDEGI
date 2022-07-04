/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Persona;
import cr.ac.una.sidegi.model.dto.PersonaDto;

import cr.ac.una.sidegi.util.EntityManagerHelper;
import cr.ac.una.sidegi.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class PersonaService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
//    public Respuesta getAposento(Long id) {
//        try {
//            Query qryAposento = em.createNamedQuery("Aposento.findByApoId", Aposento.class);
//            qryAposento.setParameter("apoId", id);
//
//            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Aposento", new AposentoDto((Aposento) qryAposento.getSingleResult()));
//
//        } catch (NoResultException ex) {
//            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un aposento con el código ingresado.", "getAposento NoResultException");
//        } catch (NonUniqueResultException ex) {
//            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el aposento.", ex);
//            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el aposento.", "getAposento NonUniqueResultException");
//        } catch (Exception ex) {
//            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el aposento.", ex);
//            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el aposento.", "getAposento " + ex.getMessage());
//        }
//    }
    
    public Respuesta guardarPersona(PersonaDto personaDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Persona persona;
//            if(personaDto.getPerCedula() != null ){
//               persona =  em.find(Persona.class,personaDto.getPerCedula());
//            if(persona == null){
//                et.rollback();
//                return new Respuesta(false,"No se encontro el asociado a modificar.","guardarTipoplanilla noResultException");
//            }
//                persona.actualizarPersona(personaDto);
//                em.merge(persona);
//            }else{
                persona = new Persona(personaDto);
                em.persist(persona);
            //}
            et.commit();
            return new Respuesta(true, "", "", "Asociado", new PersonaDto());
        } catch (Exception ex) {
            et.rollback();
            //Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, "Error guardando el asociado.", ex.getMessage());
            return new Respuesta(false, "Error guardando el Asociado.", "guardarAsociado " + ex.getMessage());
        }
    }
    
//    public Respuesta getAposentos() {
//        try {
//            Query qryTipoProc = em.createNamedQuery("Aposento.findAll", Aposento.class);
//            List<Aposento> aposentos = qryTipoProc.getResultList();
//            List<AposentoDto> aposentosDto = new ArrayList<>();
//            aposentos.forEach(ap -> {
//                System.err.println(ap.getApoMesas().size()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//                aposentosDto.add(new AposentoDto(ap));
//            });
//            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Aposentos",aposentosDto);
//
//         } catch (NoResultException ex) {
//            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen aposentos guardados.", "getTipoProductos NoResultException");
//        } catch (Exception ex) {
//            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el aposento.", ex);
//            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los aposentos.", "getAposentos " + ex.getMessage());
//        }
//    }

//    public Respuesta eliminarAposento(Long id) {
//        try {
//            Aposento aposento;
//            if (id != null && id > 0) {
//                aposento = em.find(Aposento.class, id);
//                if (aposento == null) {
//                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el aposento a eliminar.", "eliminarAposento NoResultException");
//                }
//                em.remove(aposento);
//            } else {
//                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar el aposento a eliminar.", "eliminarAposento NoResultException");
//            }
//            em.flush();
//            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
//        } catch (Exception ex) {
//            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
//                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar el aposento porque tiene relaciones con otros registros.", "eliminarAposento " + ex.getMessage());
//            }
//            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el aposento.", ex);
//            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el aposento.", "eliminarAposento " + ex.getMessage());
//        }
//    }
}
