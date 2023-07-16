
package arg.cuarteto.Proyecto_clasificados.Repository;

import arg.cuarteto.Proyecto_clasificados.Entity.Publicacion;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository  extends JpaRepository<Publicacion, String> {
    
    //Busca por Titulo
    @Query("SELECT u FROM Publicacion u WHERE u.titulo = :titulo")
    public Publicacion buscarPorTitulo(@Param("titulo") String titulo);
    
    // buscar por id
    @Query("SELECT c FROM Publicacion c WHERE c.id = :id")
    public Publicacion buscarPorId(@Param("id") String id);
    
//    //buscar por oficio
//    @Query("SELECT f FROM Publicacion f WHERE f.oficio = :oficio")
//    public Publicacion buscarporOficio (@Param("oficio") String oficio);
//    
//    //buscar por Provincia
//    @Query("SELECT q FROM Publicacion q WHERE q.provincia = :provincia")
//    public Publicacion buscarporProvincia (@Param("provincia") Provincia provincia);
    
  

}
