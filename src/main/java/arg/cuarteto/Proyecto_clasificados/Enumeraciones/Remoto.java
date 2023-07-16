
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Remoto {
    
    REMOTO("REMOTO"),
    HIBRIDO("HIBRIDO"),
    PRESENCIAL("PRESENCIAL");


    private String nombre;

    private Remoto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
