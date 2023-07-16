/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.ErrorService;

/**
 *
 * @author Nnahu
 */
public class ErrorService extends Exception {
    public ErrorService(String msn){ //enlazado a usuarioService y usuarioController para mostrar en las vistas
        super(msn);
        
    }
}
