/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Controller;

;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Service.experienciaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nnahu
 */
@Controller
public class experienciaUsuarioController {
    
    @Autowired
    private experienciaUsuarioService experienciaUsuarioService;
    
    @GetMapping("/experienciaUsuarioForm") // pagina registro
    public String cargarExperiencia() {
        return "experienciaUsuarioForm.html";
    } 
       
    
    @PostMapping("/cargarExperienciaFrom") // metodo registrar para la pagina registro, carga en la base de datos lo solicitado
    public String register2(ModelMap modelo, @RequestParam (required = false) String tituloExperiencia, @RequestParam (required = false) String fechaEmpresa,
         @RequestParam (required = false) String nombreEmpresa, @RequestParam (required = false) String puestoEmpresa,
         @RequestParam (required = false) String descripcionPuesto) {        
        try {                 
            experienciaUsuarioService.register2(tituloExperiencia, fechaEmpresa, nombreEmpresa, puestoEmpresa, descripcionPuesto);
            
                } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>   
                modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
                modelo.put("tituloExperiencia:", tituloExperiencia);
                modelo.put("fechaEmpresa:", fechaEmpresa);
                modelo.put("nombreEmpresa:", nombreEmpresa);
                modelo.put("puestoEmpresa:", puestoEmpresa);
                modelo.put("descripcionPuesto:", descripcionPuesto);
                    return "index.html";
        } 
            modelo.put("titulo", "Bienvenido a PostSolutions"); // <h2 class="display-4" th:text="${titulo}"></h2> enlazado ala vista exito - msj que se ve una vez bien registrado el usuario
            modelo.put("descripcion", "Tu usuario fue registrado satisfactoriamente"); // <p th:text="${descripcion}"></p>     
            return "index.html";        
    }
      
    
    
}
