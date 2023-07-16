/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Repository;



import arg.cuarteto.Proyecto_clasificados.Entity.experienciaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface experienciaUsuarioRepository extends JpaRepository<experienciaUsuario, String> {  

    @Query("SELECT e FROM experienciaUsuario e WHERE e.id = :id") // buscar por id
    public experienciaUsuarioRepository buscarPorId(@Param("id") String id);
    
    
}
