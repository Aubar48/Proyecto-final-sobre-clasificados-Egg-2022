/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Repository;

import arg.cuarteto.Proyecto_clasificados.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nnahu
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
     @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email") String email); // buscar por email

    @Query("SELECT c FROM Usuario c WHERE c.id = :id") // buscar por id
    public Usuario buscarPorId(@Param("id") String id);
}
