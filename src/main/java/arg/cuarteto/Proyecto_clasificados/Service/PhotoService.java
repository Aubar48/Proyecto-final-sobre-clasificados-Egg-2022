
package arg.cuarteto.Proyecto_clasificados.Service;

import arg.cuarteto.Proyecto_clasificados.Entity.Photo;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Repository.PhotoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nnahu
 */
@Service
public class PhotoService {
    
    @Autowired
    private PhotoRepository repositorio_de_fotos;
    
    @Transactional 
    public Photo guardar(MultipartFile archivo) throws ErrorService {
        if (archivo != null && !archivo.isEmpty()) {
            try { 
               Photo foto = new Photo();
               foto.setMime(archivo.getContentType());
                foto.setName(archivo.getName());
                foto.setContent(archivo.getBytes());
                 return repositorio_de_fotos.save(foto);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }   
        }
        return null;
    }
    
     @Transactional 
    public Photo editar(String idFoto, MultipartFile archivo) throws ErrorService{
        
        if (archivo != null) {
            try {
               Photo foto = new Photo();
               
               if(idFoto != null){
                   Optional <Photo> respuesta =  repositorio_de_fotos.findById(idFoto);
                   if(respuesta.isPresent()){
                       foto = respuesta.get();
                   }  
               }
                foto.setMime(archivo.getContentType());
                foto.setName(archivo.getName());
                foto.setContent(archivo.getBytes());
                 return repositorio_de_fotos.save(foto);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }    
        }            
        return null;      
    }
}
