/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/main") // pagina main
    public String index() {
        return "/publicacionForm";
    }

//<<<<<<< HEAD
 @PreAuthorize("hasAnyRole ('ROLE_USUARIO_REGISTRADO')") // autorizacion para usuarios logeado "con esto podemos hacer que el admin tenga mas privilegios"
//=======
//     @PreAuthorize("hasAnyRole('ROLE_USUARIO_REGISTRADO')") // autorizacion para usuarios logeado "con esto podemos hacer que el admin tenga mas privilegios"
//>>>>>>> ec19752e46689df0c9bd4c0ec0d878de8a607b56
    @GetMapping("/exito") // pagina msj de exito del usuario registrado
    public String exito() {
        return "formularioClasificados.html";
    }

    @GetMapping("/login-registro") // toma como enlace al securitySettings donde valida 
    //el inicio de sesion y redirecciona al main
    public String login(@RequestParam(required = false) String error,
            @RequestParam(required = false) String logout, ModelMap model) {
// con ResquestParam (required = false) hacemos que no sea obligatorio el atributo solicitado
        if (error != null) {
            model.put("error", "Email o clave incorrectos.");
// <p th:if="${error !=null}" th:text ="${error}" style="color:red"></p>
        }

        if (logout != null) {
            model.put("logout", "Ha salido correctamente de la plataforma.");
            // <p th:if="${logout !=null}" th:text ="${logout}" style="color:green"></p>
        }
        return "registroaylogin.html";
    }

//    @GetMapping("/login-registro") // pagina registro
//    public String registro() {
//        return "registroaylogin.html";
//    }
    //registrar, envia datos del formlario a base datos, form th:action="@{/registrar}" method="POST"
    //RequestParam es para indicar que son necesarios para guardar y viajen  en metodo post
    //ModelMap guarda todo lo que neceistamos guardar temporariamente interfaz de usuario
    @PostMapping("/registrar") // metodo registrar para la pagina registro, carga en la base de datos lo solicitado
    public String register(ModelMap modelo,
            MultipartFile archivo,
            @RequestParam String nombre,
            @RequestParam String email, @RequestParam String clave) {
        try {
            System.out.println(archivo);
             System.out.println(nombre);
             System.out.println(email);
              System.out.println(clave);
            
            
            
            
            
            usuarioService.register(archivo, nombre, email, clave);
        } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>  

            modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            modelo.put("clave", clave);

            return "registro.html";
        }
        modelo.put("titulo", "Bienvenido a PostSolutions");
        // <h2 class="display-4" th:text="${titulo}"></h2> enlazado ala vista exito 
        //- msj que se ve una vez bien registrado el usuario
        modelo.put("descripcion", "Tu usuario fue registrado satisfactoriamente");
        // <p th:text="${descripcion}"></p>     
        return "/registroaylogin";
    }

    @GetMapping("/formulario-clasificados") // pagina registro
    public String formClasificados() {
        return "formularioClasificados.html";
    }

}
