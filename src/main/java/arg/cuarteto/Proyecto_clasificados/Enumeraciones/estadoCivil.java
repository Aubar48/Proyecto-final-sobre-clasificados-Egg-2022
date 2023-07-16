
package arg.cuarteto.Proyecto_clasificados.Enumeraciones;
public enum estadoCivil {
    
    SOLTERO("SOLTERO"),
    CASADO("CASADO"),
    DIVORCIADO("DIVORCIADO"),
    VIUDO("VIUDO");
    


    private String nombre;

    private estadoCivil(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
