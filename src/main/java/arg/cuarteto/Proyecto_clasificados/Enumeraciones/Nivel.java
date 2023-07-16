
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum Nivel {
    
    PRINCIPIANTE("PRINCIPIANTE"),
    INTERMEDIO("INTERMEDIO"),
    AVANZADO("AVANZADO");
  

    private String nombre;

    private Nivel(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
