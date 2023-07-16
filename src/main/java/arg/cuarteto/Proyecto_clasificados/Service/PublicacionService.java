package arg.cuarteto.Proyecto_clasificados.Service;

import arg.cuarteto.Proyecto_clasificados.Entity.Photo;
import arg.cuarteto.Proyecto_clasificados.Entity.Publicacion;
import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;

import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.PublicacionRepository;
import arg.cuarteto.Proyecto_clasificados.Repository.UsuarioRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PhotoService fotoService;

    @Transactional(propagation = Propagation.NESTED)
    public void crearPublicacion(MultipartFile archivo, String idUsuario, String titulo,
            int precio, String descripcion, Oficio oficio,Provincia provincia) throws ErrorService {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        validar(titulo, precio, descripcion, oficio, provincia);
        Photo foto = fotoService.guardar(archivo);
        System.out.println("ENTRAAAA");
        Publicacion publicacion = new Publicacion();
        publicacion.setActivo(Boolean.TRUE);
        publicacion.setTitulo(titulo);
        publicacion.setOficio(oficio);
        publicacion.setPrecio(precio);
        publicacion.setDescripcion(descripcion);
        publicacion.setProvincia(provincia);
        publicacion.setFechaAltabaja(new Date());
        publicacion.setUsuario(usuario);
        publicacion.setPhoto(foto);
        publicacionRepository.save(publicacion);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void modificarPublicacion(MultipartFile archivo, String id, String titulo,
            int precio, String descripcion, Oficio oficio, Date fechaAltabaja, Provincia provincia) throws ErrorService {
        
        
        validar(titulo, precio, descripcion, oficio, provincia);
        Optional<Publicacion> respuesta = publicacionRepository.findById(id);
        Photo foto = fotoService.guardar(archivo);

        if (respuesta.isPresent()) {
            Publicacion publicacion = respuesta.get();
            publicacion.setActivo(Boolean.TRUE);
            publicacion.setTitulo(titulo);
            publicacion.setDescripcion(descripcion);
            publicacion.setOficio(oficio);
            publicacion.setFechaAltabaja(new Date());
            publicacion.setPhoto(foto);
            publicacion.setProvincia(provincia);
            publicacionRepository.save(publicacion);
        }else{
            throw new ErrorService("Error al modificar la publicacion");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void publicacionDeshabilitar(String id) throws ErrorService {
        Optional<Publicacion> respuesta = publicacionRepository.findById(id);
        if (respuesta.isPresent()) {
            Publicacion publicacion = respuesta.get();
            publicacion.setFechaAltabaja(new Date());
            publicacionRepository.save(publicacion);
        } else {
            throw new ErrorService("El ID consultado no se encuentra en la base de datos.");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void publicacionHabilitar(String id) throws ErrorService {
        Optional<Publicacion> respuesta = publicacionRepository.findById(id);
        if (respuesta.isPresent()) {
            Publicacion publicacion = respuesta.get();
            publicacion.setFechaAltabaja(null);
            publicacionRepository.save(publicacion);
        } else {
            throw new ErrorService("El ID consultado no se encuentra en la base de datos.");
        }
    }
    
    

    public void validar(String titulo, int precio, String descripcion,
            Oficio oficio, Provincia provincia) throws ErrorService {
        if (titulo == null || titulo.isEmpty()) {
            throw new ErrorService("El nombre no puede ser nulo ni puede estar vacio");
        }
        if (precio <= 0) {
            throw new ErrorService("El precio tiene que ser mayor a 0.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new ErrorService("La descripcion no puede ser nulo ni puede estar vacio");
        }
        if (oficio == null) {
            throw new ErrorService("Debe poseer un oficio identificado");
        }
        if(provincia == null){
          throw new ErrorService("Debe elegir una provincia de la lista");  
        }
      
    }
    
    
    
    
     public Publicacion buscarPorId(String id) { 
        return publicacionRepository.buscarPorId(id);
    }
     
     
     
     
     
    @Transactional(readOnly = true)
    public List<Publicacion> mostrarPublicaciones(){
        return publicacionRepository.findAll();
    }

}
