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
     EntityManager em = EntityManagerHelper.getInstance().getManager();
     private EntityTransaction et;
     public Respuesta getInsititucion(String parametro) {
        try {      
            InstitucionDto Asociado = new InstitucionDto();
            return new Respuesta(true, "", "", "Asociado", Asociado);
        } catch (Exception ex) {
            Logger.getLogger(InstitucionService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + parametro + "]", ex);
            return new Respuesta(false, "Error obteniendo la institucion.", "getInsititucion " + ex.getMessage());
        }
    }
    
    public Respuesta getAsociado(String id) {
        try {       
            Query qryTipoplanilla = em.createNamedQuery("Asociado.findByAsoFolio",Institucion.class);
            qryTipoplanilla.setParameter("folio", id);
            
            Institucion institucion = (Institucion) qryTipoplanilla.getSingleResult();
            InstitucionDto institucionDto = new InstitucionDto(institucion);
            
//            for(Cooperativa coop : asociado.getCooperativaList()){
//            institucionDto.getCooperativas().add(new CooperativaDto(coop));
//            }
            
//            for(Cuenta cuenta : asociado.getCuentaList()){
//            institucionDto.getCuentas().add(new CuentasDto(cuenta));
//            }
            return new Respuesta(true, "", "", "Institucion", institucionDto);
        
        }catch(NoResultException ex){
            return new Respuesta(false,"No existe un usuario con las credenciales ingresadas.","getAsociado NoResultException");
        }catch(NonUniqueResultException ex){
            Logger.getLogger(InstitucionService.class.getName()).log(Level.SEVERE,"Ocurrio un error al consultar el asociado",ex);
            return new Respuesta(false,"Ocurrio un error al consultar el asociado.","getAsociado NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(InstitucionService.class.getName()).log(Level.SEVERE, "Error obteniendo el Asociado [" + id + "]", ex);
            return new Respuesta(false, "Error obteniendo el Asociado.", "getAsociado " + ex.getMessage());
        }
    }
    
    public Respuesta getAsociados(String folio) {
//        try {
//            Query qryAsociado = em.createNamedQuery("Asociado.findByAsoFolio",Institucion.class);
//            qryAsociado.setParameter("folio",folio);
//            List<Asociado> asociados = qryAsociado.getResultList();
//            List<AsociadosDto> asociadosDto = new ArrayList<>();
//            asociados.forEach((Asociado) -> {
//            asociadosDto.add(new AsociadosDto(Asociado));
//            });
//            
//            return new Respuesta(true, "", "", "Asociados", asociadosDto);
//        } catch(NonUniqueResultException ex){
//            Logger.getLogger(AsociadosService.class.getName()).log(Level.SEVERE,"Ocurrio un error al consultar los asociados",ex);
//            return new Respuesta(false,"No existen asociados con los criterios ingresados.","getUsuario NonUniqueResultException");
//        }catch (Exception ex) {
//            Logger.getLogger(AsociadosService.class.getName()).log(Level.SEVERE, "Error obteniendo asociados.", ex);
//            return new Respuesta(false, "Error obteniendo Asociados.", "getAsociados " + ex.getMessage());
//        }
    return null;
    }
        public Respuesta guardarIInstitucion(InstitucionDto institucionDto) {
        try {
            et = em.getTransaction();
            et.begin();
                Institucion institucion;
            if(institucionDto.getInsId() != null ){
               institucion =  em.find(Institucion.class,institucionDto.getInsId());
            if(institucion == null){
                et.rollback();
                return new Respuesta(false,"No se encontro el asociado a modificar.","guardarTipoplanilla noResultException");
            }
                institucion.actualizarInstitucion(institucionDto);
                institucion = em.merge(institucion);
            }else{
                institucion = new Institucion(institucionDto);
                em.persist(institucion);
            }
            et.commit();
            return new Respuesta(true, "", "", "Asociado", new InstitucionDto());
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(InstitucionService.class.getName()).log(Level.SEVERE, "Error guardando el asociado.", ex);
            return new Respuesta(false, "Error guardando el Asociado.", "guardarAsociado " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarInstitucion(String folio) {
        try {
            et = em.getTransaction();
            et.begin();
                Institucion institucion;
            if(folio != null ){
                institucion = em.find(Institucion.class,folio);
            if(institucion== null){
               et.rollback();
               return new Respuesta(false, "no se encontro el asociado a eliminar", "eliminarAsocaido NoResultException");
            }
                em.remove(institucion);
            }else{
                et.rollback();
                return new Respuesta(false, "Debe cargar el asociado eliminar. ", "eliminarAsociado NoResultException");
            }
               et.commit();
                return new Respuesta(true," "," ");
        } catch (Exception ex) {
            et.rollback();
        if(ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class){
            return new Respuesta(false,"No se puede eliminar el empleado porque tiene relaciones con otros registros. ","eliminarEmpleado" + ex.getMessage());
        }
            Logger.getLogger(InstitucionService.class.getName()).log(Level.SEVERE, "Error eliminando el empleado.", ex);
            return new Respuesta(false, "Error eliminando el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }
}