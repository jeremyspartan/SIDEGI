/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.service;

import cr.ac.una.sidegi.model.Paciente;
import cr.ac.una.sidegi.model.dto.PacienteDto;
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
public class PacienteService {
    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;
    private static final Logger LOG = Logger.getLogger(PacienteService.class.getName());
    
    
public Respuesta guardarPaciente(PacienteDto pacienteDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Paciente paciente;
            
//            if (pacienteDto.getPacIdPaciente()!= null && pacienteDto.getPacIdPaciente()> 0) {
//                paciente = em.find(Paciente.class, pacienteDto.getInsId());
//                if (paciente == null) {
//                    return new Respuesta(false, "No se encrontró el paciente a modificar.", "guardarPaciente NoResultException");
//                }
//                paciente.actualizarPaciente(pacienteDto);
//                paciente = em.merge(paciente);
//            } else {
                paciente = new Paciente(pacienteDto);
                em.persist(paciente);
//            }
//            em.flush();
            et.commit();
            return new Respuesta(true, "", "", "Paciente", new PacienteDto(paciente));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el paciente.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el paciente.", "guardarPaciente " + ex.getMessage());
        }
    }
}
