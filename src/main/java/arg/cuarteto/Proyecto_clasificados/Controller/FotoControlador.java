package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Entity.Publicacion;
import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.PhotoRepository;
import arg.cuarteto.Proyecto_clasificados.Repository.UsuarioRepository;
import arg.cuarteto.Proyecto_clasificados.Service.PublicacionService;
import arg.cuarteto.Proyecto_clasificados.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foto")
public class FotoControlador {

    @Autowired
    private UsuarioService usuarioServicio;
    
    
    @Autowired
    private PublicacionService publicacionServicio;

    @Autowired
    private PhotoRepository repositorioFoto;
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> fotoUsuario(@PathVariable String id) throws ErrorService {

        Usuario usuario = usuarioServicio.buscarPorId(id);
        if (usuario.getFoto() == null) {
            throw new ErrorService("El Usuario no tiene foto asignada");
        }
        byte[] foto = usuario.getFoto().getContent();// saco la foto

        HttpHeaders headers = new HttpHeaders();//para indicar que es una foto
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(foto, headers, HttpStatus.OK);//como devuelvo

    }

    @GetMapping("/publicacion/{id}")
    public ResponseEntity<byte[]> fotoPublicacion(@PathVariable String id) throws ErrorService {

        Publicacion pulicacion =  publicacionServicio.buscarPorId(id);
        if (pulicacion.getPhoto() == null) {
            throw new ErrorService("El Usuario no tiene foto asignada");
        }
        byte[] foto = pulicacion.getPhoto().getContent();// saco la foto

        HttpHeaders headers = new HttpHeaders();//para indicar que es una foto
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(foto, headers, HttpStatus.OK);//como devuelvo

    }
    
    
    
    

//     @Autowired
//    private PublicacionService publicacionServicio;
//    @GetMapping("/usuario/{id}")
//    public ResponseEntity<byte[]> fotoUsuario(@PathVariable String id) throws ErrorService {
//        try {
//            
//       Photo foto = repositorioFoto.searchPhoto(id);
//         
//            if (foto == null) {
//                throw new ErrorService("El Usuario no tiene foto asignada");
//            }
//
//            byte[] fotoByte = foto.getContent();// saco la foto
//
//            HttpHeaders headers = new HttpHeaders();//para indicar que es una foto
//            headers.setContentType(MediaType.IMAGE_JPEG);
//            return new ResponseEntity<>(fotoByte, headers, HttpStatus.OK);//como devuelvo  
//
//        } catch (ErrorService e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//    }
}
