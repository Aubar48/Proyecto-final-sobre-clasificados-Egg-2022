
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Roles {
    
    USUARIO ("USUARIO"), 
    ADMINISTRADOR("ADMINISTRADOR");

    private String nombre;

    private Roles(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
