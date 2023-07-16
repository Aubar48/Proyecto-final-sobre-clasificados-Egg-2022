/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Service;

import arg.cuarteto.Proyecto_clasificados.Entity.experienciaUsuario;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.experienciaUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author Nnahu
 */
@Service
public class experienciaUsuarioService {
    
    @Autowired
    private experienciaUsuarioRepository experienciaUsuarioRepository;
     
     @Autowired
     private PhotoService fotoService;
     
     private void validation(String tituloExperiencia, String fechaEmpresa, String nombreEmpresa, String puestoEmpresa,
            String descripcionPuesto) throws ErrorService {// validation para no andar haciendo if anidados en cada transaccion
        if (tituloExperiencia== null || tituloExperiencia.isEmpty()) {//pd: esto enlaza al msj de ErrorService para controlador, que luego se ve reflejado en la vista
            throw new ErrorService("El tituloExperiencia del usuario no puede ser nulo.");
        }
        if (fechaEmpresa == null || fechaEmpresa.isEmpty()) {
            throw new ErrorService("La fechaEmpresa del usuario no puede ser nulo.");
        }
        if (nombreEmpresa == null || nombreEmpresa.isEmpty()) {
            throw new ErrorService("El nombreEmpresa del usuario no puede ser nulo.");
        }
        if (puestoEmpresa == null || puestoEmpresa.isEmpty()) {
            throw new ErrorService("El puestoEmpresa del usuario no puede ser nulo.");
        }
         if (descripcionPuesto == null || descripcionPuesto.isEmpty()) {
            throw new ErrorService("La descripcionPuesto del usuario no puede ser nulo.");
        }
    }
       
     
     @Transactional(propagation = Propagation.NESTED)
    public void register2(String tituloExperiencia, String fechaEmpresa, String nombreEmpresa, String puestoEmpresa,
            String descripcionPuesto) throws ErrorService {//este metodo registra al usuario en la base de datos
        validation(tituloExperiencia, fechaEmpresa, nombreEmpresa, puestoEmpresa, descripcionPuesto);// implementamos validation para no andar haciendo if en cada transaccion
        //llamamos a usuario entidad donde seteamos los atributos
        experienciaUsuario experienciaUsuario = new experienciaUsuario(); 
        
        
        experienciaUsuario.setTituloExperiencia(tituloExperiencia);
        experienciaUsuario.setFechaEmpresa(fechaEmpresa);
        experienciaUsuario.setNombreEmpresa(nombreEmpresa);    
        experienciaUsuario.setPuestoEmpresa(puestoEmpresa);   
        experienciaUsuario.setDescripcionPuesto(descripcionPuesto);   
                
     
           //guardamos los datos en un nuevo objeto usuario
           
     
        experienciaUsuarioRepository.save(experienciaUsuario);
    }
    
    
    @Transactional(propagation = Propagation.NESTED)
    public void modificar2(String id, String tituloExperiencia, String fechaEmpresa, String nombreEmpresa, String puestoEmpresa,
            String descripcionPuesto) throws ErrorService {// este metodo modifica al usuario en la base de datos
       validation(tituloExperiencia, fechaEmpresa, nombreEmpresa, puestoEmpresa, descripcionPuesto);
        
         //jpa nos devuelve un opcional  experienciaUsuario
        Optional<experienciaUsuario> respuesta = experienciaUsuarioRepository.findById(id);
        if (respuesta.isPresent()) {
            experienciaUsuario experienciaUsuario = respuesta.get();
        experienciaUsuario.setTituloExperiencia(tituloExperiencia);
        experienciaUsuario.setFechaEmpresa(fechaEmpresa);
        experienciaUsuario.setNombreEmpresa(nombreEmpresa);    
        experienciaUsuario.setPuestoEmpresa(puestoEmpresa);   
        experienciaUsuario.setDescripcionPuesto(descripcionPuesto);   
                
     
           //guardamos los datos en un nuevo objeto usuario
           
     
        experienciaUsuarioRepository.save(experienciaUsuario);
        } else {
            throw new ErrorService("No se encontro experienciaUsuario solicitado");
        }
    }
    

}
