package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Entity.FormUsuario;
import arg.cuarteto.Proyecto_clasificados.Entity.Publicacion;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.FormUsuarioRepository;
import arg.cuarteto.Proyecto_clasificados.Service.FormUsuarioService;
import arg.cuarteto.Proyecto_clasificados.Service.PublicacionService;
import arg.cuarteto.Proyecto_clasificados.Service.UsuarioService;

import java.util.List;
import java.util.Optional;
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
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private FormUsuarioService formUsuarioService;
    @Autowired
    private FormUsuarioRepository formUsuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    // @PreAuthorize("hasAnyRole ('ROLE_USUARIO_REGISTRADO')") 
    // autorizacion para 
    //usuarios logeado "con esto podemos hacer que el admin tenga mas privilegios"
    @GetMapping("/publicacionForm")
    public String crear(ModelMap modelo) {
        modelo.put("oficios", Oficio.values()); //paso la lista de oficios
        //para que se muestre en una lista en el html
        modelo.put("provincias", Provincia.values()); //paso las provincias
        //para ponerlas en el html en forma de lista
        List<Publicacion> publicaciones = publicacionService.mostrarPublicaciones();
        System.out.println(publicaciones);
        modelo.put("publicaciones", publicaciones);
        return "publicacion.html";
    }

    @PostMapping("/cargarPublicacion") // metodo registrar para la pagina registro,
    //carga en la base de datos lo solicitado
    public String crearPublicacion(ModelMap modelo,
            MultipartFile archivo,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) int precio,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) Oficio oficio,
            @RequestParam(required = false) String idUsuario,
            @RequestParam(required = false) Provincia provincia) {

        try {
            System.out.println(titulo);
            System.out.println(precio);
            System.out.println(descripcion);
            System.out.println(provincia);
            System.out.println(oficio);
            System.out.println(idUsuario);
            publicacionService.crearPublicacion(archivo, idUsuario, titulo, precio,
                    descripcion, oficio, provincia);

            modelo.put("oficios", Oficio.values()); //paso la lista de oficios
            //para que se muestre en una lista en el html
            modelo.put("provincias", Provincia.values()); //paso las provincias
            //para ponerlas en el html en forma de lista
            List<Publicacion> publicaciones = publicacionService.mostrarPublicaciones();
            System.out.println(publicaciones);
            modelo.put("publicaciones", publicaciones);

        } catch (ErrorService ex) { // <p th:if="${Error != null}" th:text="${Error}" style=color:red;></p>   
            modelo.put("Error", ex.getMessage()); //estos msj estan enlazados en validation usuarioService
            modelo.put("Foto:", archivo);
            modelo.put("titulo:", titulo);
            modelo.put("precio:", precio);
            modelo.put("descripcion:", descripcion);
            modelo.put("oficio:", oficio);
            modelo.put("usuario", idUsuario);
            modelo.put("provincia", provincia);

            return "publicacion.html";
        }
        return "publicacion.html";

    }

   

    
//    @GetMapping("/mostrarPublicacion")
//    public String mostrarPublicacion(ModelMap modelo) {
//        List<Publicacion> publicaciones = publicacionService.mostrarPublicaciones();
//     
//        modelo.put("publicaciones", publicaciones);
//        return "publicacion3.html";
//    }
}
