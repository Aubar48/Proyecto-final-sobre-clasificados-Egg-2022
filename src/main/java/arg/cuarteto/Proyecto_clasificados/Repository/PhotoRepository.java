/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Repository;

import arg.cuarteto.Proyecto_clasificados.Entity.Photo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
    
    
     @Query("Select p from Photo p Where p.id = :id")
    public Photo searchPhoto(@Param("id") String id);
}
